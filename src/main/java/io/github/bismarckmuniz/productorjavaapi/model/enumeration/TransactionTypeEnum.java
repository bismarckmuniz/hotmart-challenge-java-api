package io.github.bismarckmuniz.productorjavaapi.model.enumeration;

/**
 * Enum that classifies the transaction's payment type.
 * 
 * @author Bismarck Muniz
 * @since 17/09/2020
 */
public enum TransactionTypeEnum {
	
	CARD("CARD"), MONEY("MONEY");
	
	private String value;
	
	private TransactionTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
