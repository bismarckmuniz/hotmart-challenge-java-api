package io.github.bismarckmuniz.productorjavaapi.dto.response;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Class that implements a generic response error object to the API endpoints.
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseError {
	
	@NotNull(message="Timestamp cannot be null")
	private LocalDateTime timestamp;
	
	@NotNull(message="Details cannot be null")
    private String details;

}