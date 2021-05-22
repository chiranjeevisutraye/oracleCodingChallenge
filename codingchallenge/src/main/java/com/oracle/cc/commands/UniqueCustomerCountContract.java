package com.oracle.cc.commands;

/**
 * 
 * @author Chiranjeevi Sutraye
 * This class would execute a command to provide unique customer count 
 * for a given contractId
 *
 */
public class UniqueCustomerCountContract implements Command {
	
	private CustomerCommandReceiver customerCommandReceiver;
	
	public UniqueCustomerCountContract(CustomerCommandReceiver customerCommandReceiver) {
		this.customerCommandReceiver=customerCommandReceiver;
	}

	@Override
	public Object execute(Object param) {
		return customerCommandReceiver.uniqueCustomerCountByContract((String) param);
	}

}
