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
import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;

import junit.framework.Assert;

public class AverageDurationCommandTest extends BaseDataTest {
	
	List<BaseObject> customers = null;
	
	
	@Before
	public void initilize() throws OCCException {
		customers = super.setupCustomerData(AggregatorToggle.CUSTOMER.name());
	}
	
	@Test
	public void durationTest() {
		CustomerCommandReceiver commandReceiver = new CustomerCommandReceiver(customers);
		Command durationCommand = new AvgDurationGeozone(commandReceiver);
		
		Double averageDuration = (Double) durationCommand.execute("eu_west");
		Assert.assertEquals(4222.0, averageDuration.doubleValue());
		
		averageDuration = (Double) durationCommand.execute("us_east");
		Assert.assertEquals(3445.0, averageDuration.doubleValue());
	}

}
