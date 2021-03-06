package io.github.bismarckmuniz.productorjavaapi.service.transaction.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import io.github.bismarckmuniz.productorjavaapi.exception.TransactionNotFoundException;
import io.github.bismarckmuniz.productorjavaapi.model.enumeration.PageOrderEnum;
import io.github.bismarckmuniz.productorjavaapi.model.transaction.Transaction;
import io.github.bismarckmuniz.productorjavaapi.repository.transaction.TransactionRepository;
import io.github.bismarckmuniz.productorjavaapi.service.transaction.TransactionService;

/**
 * Class that implements the transaction's service methods
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionRepository transactionRepository;
	
	@Value("${pagination.items_per_page}")
	private int itemsPerPage;
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	/**
	 * @see TransactionService#save(Transaction)
	 */
	@Override
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	/**
	 * @see TransactionService#findByNsu(String)
	 */
	@Override
	@Cacheable(value="transactionNsuCache", key="#nsu", unless="#result==null")
	public List<Transaction> findByNsu(String nsu) {
		return transactionRepository.findByNsu(nsu);
	}

	/**
	 * @see TransactionService#deleteById(Long)
	 */
	@Override
	public void deleteById(Long transactionId) {
		transactionRepository.deleteById(transactionId);		
	}

	/**
	 * @see TransactionService#findById(Long)
	 * @throws TransactionNotFoundException 
	 */
	@Override
	@Cacheable(value="transactionIdCache", key="#id")
	public Transaction findById(Long id) throws TransactionNotFoundException {
		return transactionRepository.findById(id).orElseThrow(() -> 
			new TransactionNotFoundException("Transaction id=" + id + " not found"));
	}

	/**
	 * @see TransactionService#findBetweenDates()
	 */
	@Override
	public Page<Transaction> findBetweenDates(LocalDateTime startDate, LocalDateTime endDate, int page, 
			PageOrderEnum order) {
		Sort sort = Direction.ASC.name().equals(order.getValue()) ? 
				Sort.by("id").ascending() : Sort.by("id").descending();
		PageRequest pg = PageRequest.of(page, itemsPerPage, sort);
		return transactionRepository.
				findAllByTransactionDateGreaterThanEqualAndTransactionDateLessThanEqual(startDate, 
					endDate, pg);
	}

	/**
	 * @see TransactionService#findAll()
	 */
	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

}
