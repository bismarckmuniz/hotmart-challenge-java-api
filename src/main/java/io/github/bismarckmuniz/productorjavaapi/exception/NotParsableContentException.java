package io.github.bismarckmuniz.productorjavaapi.exception;

/**
 * Class that implements NotParsableContentException in the API
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
public class NotParsableContentException extends Exception{

	private static final long serialVersionUID = 6208890125157318839L;
	
	public NotParsableContentException(String msg){
		super(msg);
	}
	
	public NotParsableContentException(String msg, Throwable cause){
		super(msg, cause);
	}

}
