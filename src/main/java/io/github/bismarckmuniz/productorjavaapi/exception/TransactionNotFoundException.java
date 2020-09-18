package io.github.bismarckmuniz.productorjavaapi.exception;

/**
 * Class that implements TransactionNotFoundException in the API
 * 
 * @author Bismarck Muniz
 * @since 17/09/2020
 */
public class TransactionNotFoundException extends Exception {

	private static final long serialVersionUID = -2586209354700102349L;
	
	public TransactionNotFoundException(){
		super();
	}
	
	public TransactionNotFoundException(String msg){
		super(msg);
	}
	
	public TransactionNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
	
}
