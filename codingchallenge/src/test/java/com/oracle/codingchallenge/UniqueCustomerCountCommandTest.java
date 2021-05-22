package com.oracle.codingchallenge;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.oracle.cc.aggregators.AggregatorToggle;
import com.oracle.cc.aggregators.AggregratorFactory;
import com.oracle.cc.aggregators.CustomerAggregrator;
import com.oracle.cc.commands.Command;
import com.oracle.cc.commands.CustomerCommandReceiver;
import com.oracle.cc.commands.UniqueCustomerCountContract;
import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;

import junit.framework.Assert;

public class UniqueCustomerCountCommandTest extends BaseDataTest {
	
List<BaseObject> customers = null;
	
	
	@Before
	public void initilize() throws OCCException {
		customers = super.setupCustomerData(AggregatorToggle.CUSTOMER.name());
	}
	
	@Test
	public void testUniqueCustomerCountByContract() {
		CustomerCommandReceiver commandReceiver = new CustomerCommandReceiver(customers);
		Command uniqueCustomerCommand = new UniqueCustomerCountContract(commandReceiver);
		
		Integer customerCount = (Integer) uniqueCustomerCommand.execute("2345");
		Assert.assertEquals(3, customerCount.intValue());
		
		customerCount = (Integer) uniqueCustomerCommand.execute("2346");
		Assert.assertEquals(2, customerCount.intValue());
	}

}
