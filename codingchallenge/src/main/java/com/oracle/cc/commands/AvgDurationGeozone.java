package com.oracle.cc.commands;

/**
 * 
 * @author Chiranjeevi Sutraye
 * This class would execute a command to provide average build duration  
 * per timezone
 *
 */
public class AvgDurationGeozone implements Command {
	
	private CustomerCommandReceiver customerCommandReceiver;
	
	public AvgDurationGeozone(CustomerCommandReceiver customerCommandReceiver) {
		this.customerCommandReceiver=customerCommandReceiver;
	}
	
	@Override
	public Object execute(Object param) {
		return customerCommandReceiver.avgBuildDurationByZone((String) param);
	}

}
