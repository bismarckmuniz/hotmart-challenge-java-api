package io.github.bismarckmuniz.productorjavaapi.dto.model.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import io.github.bismarckmuniz.productorjavaapi.model.enumeration.TransactionTypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Class that implements Transaction data transfer object (DTO)
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TransactionDTO extends RepresentationModel<TransactionDTO> {
	
	private Long id;
	
	@NotNull(message="Nsu cannot be null")
	@Length(min=6, message="Nsu must contain at least 6 characters")
	private String nsu;

	private String authorizationNumber;
	
	@NotNull(message="TransactionDate cannot be null")
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", locale = "en-US", timezone = "Brazil/East")
	private LocalDateTime transactionDate;
	
	@NotNull(message="Amount cannot be null")
	private BigDecimal amount;
	
	@NotNull(message="Type cannot be null")
	private TransactionTypeEnum type;

}
