package com.oracle.cc.commands;

/**
 * 
 * @author Chiranjeevi Sutraye
 * This class would execute a command to provide unique customer count 
 * for a given geoZone
 *
 */
public class CustomerCountGeozone implements Command {
	
	private CustomerCommandReceiver customerCommandReceiver;
	
	public CustomerCountGeozone(CustomerCommandReceiver customerCommandReceiver) {
		this.customerCommandReceiver=customerCommandReceiver;
	}

	@Override
	public Object execute(Object param) {
		return customerCommandReceiver.customerCountByGeoZone((String) param);
	}

}
