package io.github.bismarckmuniz.productorjavaapi.service.transaction;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import io.github.bismarckmuniz.productorjavaapi.exception.TransactionNotFoundException;
import io.github.bismarckmuniz.productorjavaapi.model.enumeration.PageOrderEnum;
import io.github.bismarckmuniz.productorjavaapi.model.transaction.Transaction;

/**
 * Service Interface that provides methods for manipulating Transaction objects.
 * 
 * @author Bismarck Muniz
 * @since 18/09/2020
 */
public interface TransactionService {
	
	/**
	 * Method that save a transaction.
	 * 
	 * @author Bismarck Muniz
	 * @since 18/09/2020
	 * 
	 * @param transaction
	 * @return <code>Transaction</code> object
	 */
	Transaction save(Transaction transaction);
	
	/**
	 * Method that remove a transaction by an id.
	 * 
	 * @author Bismarck Muniz
	 * @since 18/09/2020
	 * 
	 * @param transactionId
	 */
	void deleteById(Long transactionId);
	
	/**
	 * Method that find a transaction by an id.
	 * 
	 * @author Bismarck Muniz
	 * @since 18/09/2020
	 * 
	 * @param id
	 * @return <code>Optional<Transaction></code> object
	 */
	Transaction findById(Long id) throws TransactionNotFoundException;
	
	/**
	 * Method that find one or more transactions by a nsu.
	 * 
	 * @author Bismarck Muniz
	 * @since 18/09/2020
	 * 
	 * @param nsu
	 * @return <code>List<Transaction></code> object
	 */
	List<Transaction> findByNsu(String nsu);
	
	/**
	 * Method that find all transactions.
	 * 
	 * @author Bismarck Muniz
	 * @since 18/09/2020
	 * 
	 * @return <code>List<Transaction></code> object
	 */
	List<Transaction> findAll();
	
	/**
	 * Method that find all transactions in a period of time.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param startDate - the start date of the search
	 * @param endDate - the end date of the search
	 * @param page - the page that will be return in the search
	 * @param order - the sort order that the results should be shown: 
	 *        ASC - ascending order; DESC - descending order
	 * 
	 * @return <code>Page<Transaction></code> object
	 */
	Page<Transaction> findBetweenDates(LocalDateTime startDate, LocalDateTime endDate, int page,
			PageOrderEnum order);

}
