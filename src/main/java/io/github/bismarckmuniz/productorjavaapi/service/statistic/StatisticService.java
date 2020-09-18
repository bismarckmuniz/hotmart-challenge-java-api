package io.github.bismarckmuniz.productorjavaapi.service.statistic;

import java.math.BigDecimal;

import io.github.bismarckmuniz.productorjavaapi.exception.DuplicateStatisticsException;
import io.github.bismarckmuniz.productorjavaapi.model.statistic.Statistic;

/**
 * Interface that provides methods for manipulating Statistics objects.
 * 
 * @author Bismarck Muniz
 * @since 18/09/2020
 */
public interface StatisticService {
	
	/**
	 * Method that saves a statistic.
	 * 
	 * @author Bismarck Muniz
	 * @since 08/06/2020
	 * 
	 * @param statistic
	 * @return <code>Statistic</code> object
	 */
	Statistic save(Statistic statistic);
	
	/**
	 * Method that verifies if the statistics already exists in the database.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param sum
	 * @param avg
	 * @param max
	 * @param min
	 * @param count
	 * @return <code>Optional<Statistic></code> object
	 */
	Statistic verifyIfStatisticsIsSame(BigDecimal sum, BigDecimal avg, BigDecimal max, 
			BigDecimal min, long count) throws DuplicateStatisticsException;
	
}
