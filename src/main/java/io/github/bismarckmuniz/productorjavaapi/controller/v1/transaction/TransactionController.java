package io.github.bismarckmuniz.productorjavaapi.controller.v1.transaction;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.bismarckmuniz.productorjavaapi.dto.model.transaction.TransactionDTO;
import io.github.bismarckmuniz.productorjavaapi.dto.response.Response;
import io.github.bismarckmuniz.productorjavaapi.exception.NotParsableContentException;
import io.github.bismarckmuniz.productorjavaapi.exception.TransactionInvalidUpdateException;
import io.github.bismarckmuniz.productorjavaapi.exception.TransactionNotFoundException;
import io.github.bismarckmuniz.productorjavaapi.model.enumeration.PageOrderEnum;
import io.github.bismarckmuniz.productorjavaapi.model.transaction.Transaction;
import io.github.bismarckmuniz.productorjavaapi.service.transaction.TransactionService;
import io.github.bismarckmuniz.productorjavaapi.util.productorApiUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * SpringBoot RestController that creates all service end-points related to the transaction.
 * 
 * @author Bismarck Muniz
 * @since 18/09/2020
 */
@Log4j2
@RestController
@RequestMapping("/productor/v1/transactions")
public class TransactionController {
	
	private TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	/**
	 * Method that creates a transaction in the database.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param dto, where: id - transaction id; nsu - identification number of a sales transaction using cards. May be null if transaction was paid in cash;
	 * authorizationNumber - is a one-time code used in the processing of online transactions; amount – transaction amount; a string of arbitrary length that is 
	 * parsable as a BigDecimal; transactionDate – transaction time in the ISO 8601 format YYYY-MM-DDThh:mm:ss.sssZ in the Local timezone; type - transaction type: 
	 * CARD (credit-card) or MONEY (paid in cash). 
	 * @param result - Bind result
	 * 
	 * @return ResponseEntity with a <code>Response<TransactionDTO></code> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 201 - Created: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 422 – Unprocessable Entity: if any of the fields are not parsable or the transaction date is in the future.
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).
	 * 
	 * @throws NotParsableContentException
	 * @throws BadRequestException 
	 */
	@PostMapping
	@ApiOperation(value = "Route to create a transaction")
	public ResponseEntity<Response<TransactionDTO>> create(@RequestHeader(value=productorApiUtil.HEADER_productor_API_VERSION, defaultValue="${api.version}") 
		String apiVersion, @RequestHeader(value=productorApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey, 
		@Valid @RequestBody TransactionDTO dto, BindingResult result) throws NotParsableContentException {
		
		Response<TransactionDTO> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		if(productorApiUtil.isTransactionDTOInFuture(dto)) {
			throw new NotParsableContentException("Date of the transaction is in the future.");
		}
		
		Transaction transaction = transactionService.save(convertDTOToEntity(dto));
		TransactionDTO dtoSaved = convertEntityToDTO(transaction);
		createSelfLink(transaction, dtoSaved);
		
		response.setData(dtoSaved);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(productorApiUtil.HEADER_productor_API_VERSION, apiVersion);
		headers.add(productorApiUtil.HEADER_API_KEY, apiKey);
		
		return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
	}
	
	/**
	 * Method that updates a transaction in the database.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param dto, where: id - transaction id; NSU - identification number of a sales transaction using cards. May be null if transaction was paid in cash;
	 * autorizationNumber - is a one-time code used in the processing of online transactions; amount – transaction amount; a string of arbitrary length that is 
	 * parsable as a BigDecimal; transactionDate – transaction time in the ISO 8601 format YYYY-MM-DDThh:mm:ss.sssZ in the Local timezone; type - transaction type: 
	 * CARD (credit-card) or MONEY (paid in cash).
	 * @param result - Bind result
	 * 
	 * @return ResponseEntity with a <code>Response<TransactionDTO></code> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 200 - OK: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 422 – Unprocessable Entity: if any of the fields are not parsable or the transaction date is in the future.
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).
	 * 
	 * @throws TransactionNotFoundException
	 * @throws TransactionInvalidUpdateException
	 * @throws NotParsableContentException 
	 */
	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Route to update a transaction")
	public ResponseEntity<Response<TransactionDTO>> update(@RequestHeader(value=productorApiUtil.HEADER_productor_API_VERSION, defaultValue="${api.version}") 
		String apiVersion, @RequestHeader(value=productorApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey, @Valid @RequestBody TransactionDTO dto, 
		BindingResult result) throws TransactionNotFoundException, TransactionInvalidUpdateException, NotParsableContentException {
		
		Response<TransactionDTO> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		if(productorApiUtil.isTransactionDTOInFuture(dto)) {
			throw new NotParsableContentException("Date of the transaction is in the future.");
		}

		Transaction transactionToFind = transactionService.findById(dto.getId());
		if (transactionToFind.getId().compareTo(dto.getId()) != 0) {
			throw new TransactionInvalidUpdateException("You don't have permission to change the transaction id=" + dto.getId());
		}

		Transaction transaction = transactionService.save(convertDTOToEntity(dto));
		TransactionDTO itemDTO = convertEntityToDTO(transaction);
		
		createSelfLink(transaction, itemDTO);
		response.setData(itemDTO);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(productorApiUtil.HEADER_productor_API_VERSION, apiVersion);
		headers.add(productorApiUtil.HEADER_API_KEY, apiKey);
		
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}

	/**
	 * Method that search for all the transactions saved in a period of time.
	 *  
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param startDate - the start date of the search
	 * @param endDate - the end date of the search
	 * @param page - the page that will be return in the search
	 * @param order - the sort order that the results should be shown: ASC - ascending order; DESC - descending order
	 * 
	 * @return ResponseEntity with a <code>Response<Page<TransactionDTO>></code> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 200 - OK: Everything worked as expected.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).
	 * 
	 * @throws TransactionNotFoundException 
	 */
	@GetMapping
	@ApiOperation(value = "Route to find all transactions of the API in a period of time")
	public ResponseEntity<Response<Page<TransactionDTO>>> findAllBetweenDates(@RequestHeader(value=productorApiUtil.HEADER_productor_API_VERSION, defaultValue="${api.version}") 
		String apiVersion, @RequestHeader(value=productorApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") 
	    LocalDate startDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate, @RequestParam(name="page", defaultValue = "0") int page,
	    @RequestParam(name="order", defaultValue = "ASC") String order) throws TransactionNotFoundException {
		
		Response<Page<TransactionDTO>> response = new Response<>();
		
		LocalDateTime startDateTime = productorApiUtil.convertLocalDateToLocalDateTime(startDate);
		LocalDateTime endDateTime = productorApiUtil.convertLocalDateToLocalDateTime(endDate);
		
		Page<Transaction> transactions = transactionService.findBetweenDates(startDateTime, endDateTime, 
				page, PageOrderEnum.getSortDirection(order));
		
		if (transactions.isEmpty()) {
			throw new TransactionNotFoundException("There are no transactions registered between startDate=" + startDate 
					+ " and endDate=" + endDate);
		}
		
		Page<TransactionDTO> itemsDTO = transactions.map(this::convertEntityToDTO);
		itemsDTO.stream().forEach(dto -> {
			try {
				createSelfLinkInCollections(apiVersion, apiKey, dto);
			} catch (TransactionNotFoundException e) {
				log.error("There are no transactions registered between startDate= {} and endDate= {}", startDate, endDate);
			}
		});
		
		response.setData(itemsDTO);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(productorApiUtil.HEADER_productor_API_VERSION, apiVersion);
		headers.add(productorApiUtil.HEADER_API_KEY, apiKey);
		
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}

	/**
	 * Method that search for all the transactions given a NSU.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param transactionNSU - the NSU of the transaction
	 * 
	 * @return ResponseEntity with a <code>Response<String></code> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 200 - OK: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential backoff of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).
	 * 
	 * @throws TransactionNotFoundException
	 */
	@GetMapping(value = "/byNsu/{nsu}")
	@ApiOperation(value = "Route to find transactions by the NSU in the API")
	public ResponseEntity<Response<List<TransactionDTO>>> findByNsu(@RequestHeader(value=productorApiUtil.HEADER_productor_API_VERSION, defaultValue="${api.version}") 
		String apiVersion, @RequestHeader(value=productorApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey, 
		@PathVariable("nsu") String transactionNSU) throws TransactionNotFoundException {
		
		Response<List<TransactionDTO>> response = new Response<>();
		List<Transaction> transactions = transactionService.findByNsu(transactionNSU);
		
		if (transactions.isEmpty()) {
			throw new TransactionNotFoundException("There are no transactions registered with the nsu=" + transactionNSU);
		}
		
		List<TransactionDTO> transactionsDTO = new ArrayList<>();
		transactions.stream().forEach(t -> transactionsDTO.add(convertEntityToDTO(t)));
		
		transactionsDTO.stream().forEach(dto -> {
			try {
				createSelfLinkInCollections(apiVersion, apiKey, dto);
			} catch (TransactionNotFoundException e) {
				log.error("There are no transactions registered with the nsu= {}", transactionNSU);
			}
		});
		
		response.setData(transactionsDTO);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(productorApiUtil.HEADER_productor_API_VERSION, apiVersion);
		headers.add(productorApiUtil.HEADER_API_KEY, apiKey);
		
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	/**
	 * Method that search a transactions by the id.
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param transactionId - the id of the transaction
	 * 
	 * @return ResponseEntity with a <code>Response<TransactionDTO></code> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 200 - OK: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential backoff of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).
	 * 
	 * @throws TransactionNotFoundException
	 */
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Route to find a transaction by your id in the API")
	public ResponseEntity<Response<TransactionDTO>> findById(@RequestHeader(value=productorApiUtil.HEADER_productor_API_VERSION, defaultValue="${api.version}") 
		String apiVersion, @RequestHeader(value=productorApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey, 
		@PathVariable("id") Long transactionId) throws TransactionNotFoundException {
		
		Response<TransactionDTO> response = new Response<>();
		Transaction transaction = transactionService.findById(transactionId);
		
		TransactionDTO dto = convertEntityToDTO(transaction);
		createSelfLink(transaction, dto);
		response.setData(dto);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(productorApiUtil.HEADER_productor_API_VERSION, apiVersion);
		headers.add(productorApiUtil.HEADER_API_KEY, apiKey);
		
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
	
	/**
	 * Method that delete an transaction.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param transactionId - the id of the transaction
	 * 
	 * @return ResponseEntity with a <code>Response<String></code> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 204 - OK: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on Goldgem's end (These are rare).
	 * 
	 * @throws TransactionNotFoundException 
	 */
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Route to delete a transaction in the API")
	public ResponseEntity<Response<String>> delete(@RequestHeader(value=productorApiUtil.HEADER_productor_API_VERSION, defaultValue="${api.version}") 
		String apiVersion, @RequestHeader(value=productorApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey, 
		@PathVariable("id") Long transactionId) throws TransactionNotFoundException {
		
		Response<String> response = new Response<>();
		Transaction transaction = transactionService.findById(transactionId);
		
		transactionService.deleteById(transaction.getId());
		response.setData("Transaction id=" + transaction.getId() + " successfully deleted");
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(productorApiUtil.HEADER_productor_API_VERSION, apiVersion);
		headers.add(productorApiUtil.HEADER_API_KEY, apiKey);
		
		return new ResponseEntity<>(response, headers, HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Method to convert an Transaction DTO to a Transaction entity.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param dto
	 * @return a <code>Transaction</code> object
	 */
	private Transaction convertDTOToEntity(TransactionDTO dto) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Transaction.class);
	}

	/**
	 * Method to convert an Transaction entity to a Transaction DTO.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param transaction
	 * @return a <code>TransactionDTO</code> object
	 */
	private TransactionDTO convertEntityToDTO(Transaction transaction) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(transaction, TransactionDTO.class);
	}
	
	/**
	 * Method that creates a self link to transaction object
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param transaction
	 * @param transactionDTO
	 */
	private void createSelfLink(Transaction transaction, TransactionDTO transactionDTO) {
		Link selfLink = WebMvcLinkBuilder.linkTo(TransactionController.class).slash(transaction.getId()).withSelfRel();
		transactionDTO.add(selfLink);
	}
	
	/**
	 * Method that creates a self link in a collection of transactions
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param apiVersion - API version at the moment
	 * @param apiKey - API Key to access the routes
	 * @param transactionDTO
	 * @throws TransactionNotFoundException
	 */
	private void createSelfLinkInCollections(String apiVersion, String apiKey, final TransactionDTO transactionDTO) 
			throws TransactionNotFoundException {
		Link selfLink = linkTo(methodOn(TransactionController.class).findById(apiVersion, apiKey, 
				transactionDTO.getId())).withSelfRel();
		transactionDTO.add(selfLink);
	}
	
}
