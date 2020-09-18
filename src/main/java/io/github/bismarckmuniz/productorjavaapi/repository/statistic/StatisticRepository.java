package io.github.bismarckmuniz.productorjavaapi.repository.statistic;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.bismarckmuniz.productorjavaapi.model.statistic.Statistic;

/**
 * Interface that implements the Statistic Repository, with JPA CRUD methods.
 *  
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long>{
	
	/**
	 * Method that search for a statistic that already exists on the API.
	 * 
	 * @param sum
	 * @param avg
	 * @param max
	 * @param min
	 * @param count
	 * @return <code>Optional<Statistic></code> object
	 */
	@Query(value = "select s.id, s.sum, s.avg, s.max, s.min, s.count from Statistic s "
			+ "where s.sum = :sum and s.avg = :avg and s.max = :max and s.min = :min "
			+ "and s.count = :count")
	Optional<Statistic> verifyIfStatisticsIsSame(@Param("sum") BigDecimal sum, @Param("avg") BigDecimal avg,
		@Param("max") BigDecimal max, @Param("min") BigDecimal min, @Param("count") long count);

}
