package com.oracle.cc.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.oracle.cc.aggregators.CustomerAggregrator;
import com.oracle.cc.model.BaseObject;
import com.oracle.cc.model.Customer;

public class CustomerCommandReceiver {
	
	private static Logger log = Logger.getLogger(CustomerCommandReceiver.class.getName());
	private List<BaseObject> customers;
	
	public CustomerCommandReceiver(List<BaseObject> customers) {
		this.customers=customers;
	}
	
	/**
	 * 
	 * @param contractId
	 * @return number customerIds which are unique by contractId
	 */
	public Integer uniqueCustomerCountByContract(String contractId) {
		log.info("Executing command uniqueCustomerCountByContract");
		Set<String> customerIds = new HashSet<String>();
		for(BaseObject baseCustomer : customers) {
			Customer customer = (Customer)baseCustomer;
			if(contractId.equalsIgnoreCase(customer.getContractId())) {
				customerIds.add(customer.getCustomerId());
			}
		}
		return customerIds.size();
	}
	
	/**
	 * 
	 * @param geoZone
	 * @return number of customers per given geoZone
	 */
	public Integer customerCountByGeoZone(String geoZone) {
		log.info("Executing command customerCountByGeoZone");
		Set<String> customerIds = new HashSet<String>();
		for(BaseObject baseCustomer : customers) {
			Customer customer = (Customer)baseCustomer;
			if(geoZone.equalsIgnoreCase(customer.getGeozone())) {
				customerIds.add(customer.getCustomerId());
			}
		}
		return customerIds.size();
	}
	
	/**
	 * 
	 * @param geoZone
	 * @return average build duration for a given geoZone
	 */
	public Double avgBuildDurationByZone(String geoZone) {
		log.info("Executing command avgBuildDurationByZone");
		double sum=0 ,count = 0;
		for(BaseObject baseCustomer : customers) {
			Customer customer = (Customer)baseCustomer;
			if(customer.getGeozone().equalsIgnoreCase(geoZone)) {
				String durationText = customer.getBuildDuration();
				durationText = durationText.substring(0, durationText.length()-1); //Avoiding seconds 's' character at the end
				double duration = Double.parseDouble(durationText);
				sum = sum+duration;
				++count;
			}
		}
		return sum/count;
	}
	
	/**
	 * 
	 * @param geoZone
	 * @return a set of unique customers by geoZone
	 */
	public Set<String> customersByGeoZone(String geoZone) {
		log.info("Executing command customersByGeoZone");
		Set<String> customerIds = new HashSet<String>();
		for(BaseObject baseCustomer : customers) {
			Customer customer = (Customer)baseCustomer;
			if(geoZone.equalsIgnoreCase(customer.getGeozone())) {
				customerIds.add(customer.getCustomerId());
			}
		}
		return customerIds;
	}
}
