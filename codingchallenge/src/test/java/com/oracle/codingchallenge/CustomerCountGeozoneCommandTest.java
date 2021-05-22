package com.oracle.codingchallenge;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.oracle.cc.aggregators.AggregatorToggle;
import com.oracle.cc.aggregators.AggregratorFactory;
import com.oracle.cc.aggregators.CustomerAggregrator;
import com.oracle.cc.commands.AvgDurationGeozone;
import com.oracle.cc.commands.Command;
import com.oracle.cc.commands.CustomerCommandReceiver;
import com.oracle.cc.commands.CustomerCountGeozone;
import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;

import junit.framework.Assert;

public class CustomerCountGeozoneCommandTest extends BaseDataTest {

	List<BaseObject> customers = null;


	@Before
	public void initilize() throws OCCException {
		customers = super.setupCustomerData(AggregatorToggle.CUSTOMER.name());
	}


	@Test
	public void customerCountTest() {
		CustomerCommandReceiver commandReceiver = new CustomerCommandReceiver(customers);
		Command countCommand = new CustomerCountGeozone(commandReceiver);

		Integer customerCount = (Integer) countCommand.execute("eu_west");
		Assert.assertEquals(2, customerCount.intValue());

		customerCount = (Integer) countCommand.execute("us_east");
		Assert.assertEquals(1, customerCount.intValue());

		customerCount = (Integer) countCommand.execute("us_west");
		Assert.assertEquals(2, customerCount.intValue());
	}
}
