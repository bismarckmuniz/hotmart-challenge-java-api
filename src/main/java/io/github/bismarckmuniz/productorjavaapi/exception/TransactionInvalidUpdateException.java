package io.github.bismarckmuniz.productorjavaapi.exception;

/**
 * Class that implements TransactionInvalidUpdateException in the API.
 * 
 * @author Bismarck Muniz
 * @since 17/09/2020
 */
public class TransactionInvalidUpdateException extends Exception{

	private static final long serialVersionUID = -6443362632495638948L;
	
	public TransactionInvalidUpdateException(){
		super();
	}
	
	public TransactionInvalidUpdateException(String msg){
		super(msg);
	}
	
	public TransactionInvalidUpdateException(String msg, Throwable cause){
		super(msg, cause);
	}

}
