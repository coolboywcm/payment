package com.payment.frame.dynasql;

public enum LinkType {

	AND ("AND"), 
	OR ("OR"),
	EMPTY (" ");
	LinkType(String code){
		this.code=code;
	}
	
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}; 