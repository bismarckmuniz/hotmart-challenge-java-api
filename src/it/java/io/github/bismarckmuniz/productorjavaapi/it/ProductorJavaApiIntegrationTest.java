package io.github.bismarckmuniz.productorjavaapi.it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import io.github.bismarckmuniz.productorjavaapi.dto.model.transaction.TransactionDTO;
import io.github.bismarckmuniz.productorjavaapi.model.enumeration.APIUsagePlansEnum;
import io.github.bismarckmuniz.productorjavaapi.model.enumeration.TransactionTypeEnum;
import io.github.bismarckmuniz.productorjavaapi.util.productorApiUtil;

/**
 * Class that implements API integration tests.
 * 
 * @author Bismarck Muniz
 * @since 18/09/2020
 */
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class productorJavaApiIntegrationTest {
	
	@LocalServerPort
	private int port;
	 
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    @Order(1)
    public void testCreateTransactionNSU123456() throws ParseException {
    	
    	//id=1
        TransactionDTO dtoNsu123456 = new TransactionDTO(); 
        dtoNsu123456.setNsu("123456");
        dtoNsu123456.setAuthorizationNumber("014785");
        dtoNsu123456.setTransactionDate(productorApiUtil.
        		getLocalDateTimeFromString("2020-9-18T2:32:04.150Z"));
        dtoNsu123456.setAmount(new BigDecimal(100d));
        dtoNsu123456.setType(TransactionTypeEnum.CARD);
        
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<TransactionDTO> entity = new HttpEntity<>(dtoNsu123456, headers);
        
        ResponseEntity<String> responseEntity = this.restTemplate
        		.exchange("http://localhost:" + port + "/productor/v1/transactions", 
        				HttpMethod.POST, entity, String.class);
        
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
    @Test
    @Order(2)
    public void testCreateTransactionNSU258963() throws ParseException {
    	
    	//id=2
    	TransactionDTO dtoNsu258963 = new TransactionDTO(); 
        dtoNsu258963.setNsu("258963");
        dtoNsu258963.setTransactionDate(productorApiUtil.
        		getLocalDateTimeFromString("2020-09-18T18:32:04.150Z"));
        dtoNsu258963.setAmount(new BigDecimal(2546.93));
        dtoNsu258963.setType(TransactionTypeEnum.MONEY);
        
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<TransactionDTO> entity = new HttpEntity<>(dtoNsu258963, headers);
        
        ResponseEntity<String> responseEntity = this.restTemplate
        		.exchange("http://localhost:" + port + "/productor/v1/transactions", 
        				HttpMethod.POST, entity, String.class);
        
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
    @Test
    @Order(3)
    public void testFindAllTransactions() throws ParseException {
    	
    	final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        
        LocalDateTime startDateTime = productorApiUtil.
        		getLocalDateTimeFromString("2020-09-18T18:32:04.150Z");
        LocalDateTime endDateTime = startDateTime.plusDays(5);
        
        String startDate = startDateTime.format(productorApiUtil.getDateFormater());
		String endDate = endDateTime.format(productorApiUtil.getDateFormater());

		ResponseEntity<String> responseEntity = this.restTemplate
        		.exchange("http://localhost:" + port + "/productor/v1/transactions?startDate=" + startDate + "&endDate=" + endDate,  
        				HttpMethod.GET, entity, String.class);
    	
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
    
    @Test
    @Order(4)
    public void testFindTransactionById() {
    	
    	final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> responseEntity = this.restTemplate
        		.exchange("http://localhost:" + port + "/productor/v1/transactions/1", 
        				HttpMethod.GET, entity, String.class);
    	
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
    
    @Test
    @Order(5)
    public void testFindTransactionByIdThatNotExists() {
    	
    	final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> responseEntity = this.restTemplate
        		.exchange("http://localhost:" + port + "/productor/v1/transactions/3", 
        				HttpMethod.GET, entity, String.class);
    	
    	//Transaction not found
        assertEquals(404, responseEntity.getStatusCodeValue()); 
    }
    
    @Test
    @Order(6)
    public void testFindTransactionByNsu() {
    	
    	final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> responseEntity = this.restTemplate
        		.exchange("http://localhost:" + port + "/productor/v1/transactions/byNsu/258963", 
        				HttpMethod.GET, entity, String.class);
    	
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
    
    @Test
    @Order(7)
    public void testCreateStatistics() {
    	
    	final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");
        
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);
    	
    	ResponseEntity<String> responseEntity = this.restTemplate.exchange("http://localhost:" + port 
        		+ "/productor/v1/statistics", HttpMethod.GET, entity, String.class);
        
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
    @Test
    @Order(8)
	public void testRequestExceedingRateLimitCapacity() throws Exception {
	    
	    final HttpHeaders headers = new HttpHeaders();
        headers.set("X-api-key", "FX001-ZBSY6YSLP");

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);

        for (int i = 1; i <= APIUsagePlansEnum.FREE.getBucketCapacity(); i++) {
        	this.restTemplate.exchange("http://localhost:" + port + "/productor/v1/transactions/1", 
        			HttpMethod.GET, entity, String.class);
        }
        
        ResponseEntity<String> responseEntity = this.restTemplate.exchange("http://localhost:" + port 
        		+ "/productor/v1/transactions/1", HttpMethod.GET, entity, String.class);
        
    	//Too many requests
        assertEquals(429, responseEntity.getStatusCodeValue());
	}

}
