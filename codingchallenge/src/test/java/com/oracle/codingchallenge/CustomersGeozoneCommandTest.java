package com.oracle.codingchallenge;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.oracle.cc.aggregators.AggregatorToggle;
import com.oracle.cc.aggregators.AggregratorFactory;
import com.oracle.cc.aggregators.CustomerAggregrator;
import com.oracle.cc.commands.Command;
import com.oracle.cc.commands.CustomerCommandReceiver;
import com.oracle.cc.commands.CustomersGeozone;
import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;

import junit.framework.Assert;

public class CustomersGeozoneCommandTest extends BaseDataTest {
	
	List<BaseObject> customers = null;
	
	@Before
	public void initilize() throws OCCException {
		customers = super.setupCustomerData(AggregatorToggle.CUSTOMER.name());
	}
	
	@Test
	public void customersGeozone() {
		CustomerCommandReceiver commandReceiver = new CustomerCommandReceiver(customers);
		Command customersGeozoneCommand = new CustomersGeozone(commandReceiver);
		
		Set<String> customers = (Set<String>) customersGeozoneCommand.execute("eu_west");
		Assert.assertEquals(2, customers.size());
		
		String containedCustomerId = "3244132";
		Assert.assertEquals(true, customers.contains(containedCustomerId));
		
		String missedCustomerId = "1223456";
		Assert.assertEquals(false, customers.contains(missedCustomerId));
		
		customers = (Set<String>) customersGeozoneCommand.execute("us_west");
		Assert.assertEquals(2, customers.size());
		
		containedCustomerId = "1223456";
		Assert.assertEquals(true, customers.contains(containedCustomerId));
		
		missedCustomerId = "3244132";
		Assert.assertEquals(false, customers.contains(missedCustomerId));
	}

}
