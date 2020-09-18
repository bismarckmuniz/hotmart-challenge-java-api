package io.github.bismarckmuniz.productorjavaapi.service.statistic.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.bismarckmuniz.productorjavaapi.exception.DuplicateStatisticsException;
import io.github.bismarckmuniz.productorjavaapi.model.statistic.Statistic;
import io.github.bismarckmuniz.productorjavaapi.repository.statistic.StatisticRepository;
import io.github.bismarckmuniz.productorjavaapi.service.statistic.StatisticService;

/**
 * Class that implements the statistic's service methods
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Service("statisticService")
public class StatisticServiceImpl implements StatisticService {

	private StatisticRepository statisticRepository;
	
	@Autowired
	public StatisticServiceImpl(StatisticRepository statisticRepository) {
		this.statisticRepository = statisticRepository;
	}
	
	/**
	 * @see StatisticService#save(Statistic)
	 */
	@Override
	public Statistic save(Statistic statistic) {
		return statisticRepository.save(statistic);
	}

	/**
	 * @see StatisticService#verifyIfStatisticsIsSame(BigDecimal, BigDecimal, BigDecimal, BigDecimal, long)
	 * @throws DuplicateStatisticsException 
	 */
	@Override
	public Statistic verifyIfStatisticsIsSame(BigDecimal sum, BigDecimal avg, BigDecimal max, 
			BigDecimal min, long count) throws DuplicateStatisticsException {
		return statisticRepository.verifyIfStatisticsIsSame(sum, avg, max, min, count).orElseThrow(() -> 
			new DuplicateStatisticsException("Already exists a statistic in the database with the same parameters."));
	}
	
}
