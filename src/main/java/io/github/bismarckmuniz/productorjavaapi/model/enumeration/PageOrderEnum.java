package io.github.bismarckmuniz.productorjavaapi.model.enumeration;

/**
 * Enum that classifies the ascending order or descending order 
 * in the sort operations in API routes.
 * 
 * @author Bismarck Muniz
 * @since 09/17/2020
 */
public enum PageOrderEnum {
	
	ASC("ASC"), DESC("DESC");

	private String value;
	
	private PageOrderEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	/**
     * Method to get the sort order of a search result.
     * 
     * @author Bismarck Muniz
     * @since 09/17/2020
     * 
     * @return <code>PageOrderEnum</code> object
     */
	public static PageOrderEnum getSortDirection(String value){
		if(ASC.getValue().equals(value)) {
			return ASC;
		}
		return DESC;
	}
}
