package io.github.bismarckmuniz.productorjavaapi.model.statistic;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class that implements the Statistic structure.
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "statistics")
public class Statistic implements Serializable {
	
	private static final long serialVersionUID = -7804600023031651840L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "transactions_sum")
	private BigDecimal sum;
	
	@Column(name = "transactions_avg")
	private BigDecimal avg;
	
	@Column(name = "transactions_max")
	private BigDecimal max;
	
	@Column(name = "transactions_min")
	private BigDecimal min;
	
	@Column(name = "transactions_count")
	private long count;
	
	public Statistic (BigDecimal sum, BigDecimal avg, BigDecimal max, BigDecimal min, long count) {
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}
}
