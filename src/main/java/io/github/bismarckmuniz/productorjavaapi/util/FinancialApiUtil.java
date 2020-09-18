package io.github.bismarckmuniz.productorjavaapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import io.github.bismarckmuniz.productorjavaapi.dto.model.transaction.TransactionDTO;
import io.github.bismarckmuniz.productorjavaapi.model.transaction.Transaction;

/**
 * Class that implements the productorAPI utility methods.
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
public class productorApiUtil {
	
	/**
	 * Field to represent API version on the requests/responses header
	 */
	public static final String HEADER_productor_API_VERSION = "productorapi-version";
	
	/**
	 * Field to represent API key on the requests/responses header
	 */
	public static final String HEADER_API_KEY = "X-api-key";
	
	/**
	 * Field to represent API Rate Limit Remaining on the requests/responses header
	 */
	public static final String HEADER_LIMIT_REMAINING = "X-Rate-Limit-Remaining";
    
	/**
	 * Field to represent API Rate Limit Retry After Seconds on the requests/responses header
	 */
	public static final String HEADER_RETRY_AFTER = "X-Rate-Limit-Retry-After-Seconds";
	
	private productorApiUtil() {}
	
	/**
	 * Method that check if the Transaction is being created in the future.
	 * 
	 * @author Bismarck Muniz
	 * @since 08/09/2019
	 * 
	 * @param transaction
	 * @return boolean
	 */
	public static boolean isTransactionInFuture(Transaction transaction) {
		return transaction.getTransactionDate().isAfter(LocalDateTime.now());
	}
	
	/**
	 * Method that check if the TransactionDTO is being created in the future.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param dto
	 * @return boolean
	 */
	public static boolean isTransactionDTOInFuture(TransactionDTO dto) {
		return dto.getTransactionDate().isAfter(LocalDateTime.now());
	}
	
	/**
	 * Method that format a date as yyyy-MM-dd.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @return <code>DateTimeFormatter</code> object
	 */
	public static DateTimeFormatter getDateFormater() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
	
	/**
	 * Method that format a date as yyyy-MM-dd'T'HH:mm:ss.SSS'Z'.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @return <code>DateTimeFormatter</code> object
	 */
	public static DateTimeFormatter getDateTimeFormater() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	}
	
	/**
	 * Method that converts a string to a LocalDateTime.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param dateAsString
	 * 
	 * @return <code>LocalDateTime</code> object
	 * @throws ParseException
	 */
	public static LocalDateTime getLocalDateTimeFromString(String dateAsString) throws ParseException{
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date dateISO8601 = inputFormat.parse(dateAsString);
        return dateISO8601.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	/**
	 * Method that converts a local date to a local date time.
	 * 
	 * @author Bismarck Muniz
	 * @since 09/17/2020
	 * 
	 * @param date
	 * @return <code>LocalDateTime</code> object
	 */
	public static LocalDateTime convertLocalDateToLocalDateTime(LocalDate date) {
		return date.atTime(0, 0, 0);
	}
	
}
