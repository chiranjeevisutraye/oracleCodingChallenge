package com.oracle.cc.exceptions;

/**
 * 
 * @author Chiranjeevi Sutraye
 * Base exception for all the exception in the application
 *
 */
public class OCCException extends Exception {

	private static final long serialVersionUID = 1L;
	protected String message;
	
	public OCCException(String message) {
		super(message);
	}    

	public OCCException(String str,Throwable cause) {
		super(str,cause);
	}
}
