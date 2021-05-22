package com.oracle.cc.exceptions;

public class DataParsingException extends OCCException {
	
	private static final long serialVersionUID = 1L;

	public DataParsingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public DataParsingException() {
		super("The input data is of incorrect format");
	}
	
	public DataParsingException(String str,Throwable cause) {
		super(str,cause);
	}


}
