package com.oracle.cc.aggregators;

import java.util.logging.Logger;

public class AggregratorFactory {
	
	private static Logger log = Logger.getLogger(AggregratorFactory.class.getName());
	
	public static DataAggregator getAggregrator(String aggregratorToggle)  {
		if(aggregratorToggle.equalsIgnoreCase(AggregatorToggle.CUSTOMER.name())) {
			log.info("Creating aggregator of type "+aggregratorToggle);
			return new CustomerAggregrator();
		}
		//More aggregators can be added here..
		return new CustomerAggregrator(); //Default aggregrator will be returned
	}
}
