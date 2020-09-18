package io.github.bismarckmuniz.productorjavaapi.test.repository.transaction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import io.github.bismarckmuniz.productorjavaapi.model.enumeration.TransactionTypeEnum;
import io.github.bismarckmuniz.productorjavaapi.model.transaction.Transaction;
import io.github.bismarckmuniz.productorjavaapi.repository.transaction.TransactionRepository;

/**
 * Class that implements tests of the TransactionRepository features
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class TransactionRepositoryTest {
	
	@Autowired
	private TransactionRepository repository;
	
	/**
	 * Method to setup a Transaction to use in the tests.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 */
	@BeforeAll
	private void setUp() {
		
		Transaction transaction = new Transaction();
		transaction.setNsu("220788");
		transaction.setAuthorizationNumber("000123");
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setAmount(new BigDecimal(100d));
		transaction.setType(TransactionTypeEnum.CARD);
		
		repository.save(transaction);
	}
	
	/**
	 * Method that test the repository that save a Transaction in the API.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 */
	@Test
	public void testSave() {
		
		Transaction transaction = new Transaction();
		transaction.setNsu("270257");
		transaction.setAuthorizationNumber("000123");
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setAmount(new BigDecimal(100d));
		transaction.setType(TransactionTypeEnum.CARD);
		
		Transaction response = repository.save(transaction);
		
		assertNotNull(response);
	}
	
	/**
	 * Method that test the repository that search for a Transaction by the NSU.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 */
	@Test
	public void testFindByNsu(){
		
		List<Transaction> response = repository.findByNsu("220788");
		assertFalse(response.isEmpty());
	}
	
	/**
	 * Method to remove all transactions test data.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 */
	@AfterAll
	private void tearDown() {
		repository.deleteAll();
	}

}
