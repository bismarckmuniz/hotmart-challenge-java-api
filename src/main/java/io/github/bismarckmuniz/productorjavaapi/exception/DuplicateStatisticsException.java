package io.github.bismarckmuniz.productorjavaapi.exception;

/**
 * Class that implements DuplicateStatisticsException in the API
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
public class DuplicateStatisticsException extends Exception {

	private static final long serialVersionUID = 6082551323004629906L;
	
	public DuplicateStatisticsException(){
		super();
	}
	
	public DuplicateStatisticsException(String msg){
		super(msg);
	}
	
	public DuplicateStatisticsException(String msg, Throwable cause){
		super(msg, cause);
	}

}
