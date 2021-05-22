package com.oracle.cc.commands;

/**
 * 
 * @author Chiranjeevi Sutraye
 * This class would execute a command to provide unique customer list 
 * for a given Geozone
 *
 */
public class CustomersGeozone implements Command {
	
	private CustomerCommandReceiver customerCommandReceiver;
	
	public CustomersGeozone(CustomerCommandReceiver customerCommandReceiver) {
		this.customerCommandReceiver=customerCommandReceiver;
	}

	@Override
	public Object execute(Object param) {
		return customerCommandReceiver.customersByGeoZone((String) param);
	}

}
