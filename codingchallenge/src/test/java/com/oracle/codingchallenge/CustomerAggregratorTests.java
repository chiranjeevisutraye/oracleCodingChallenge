package com.oracle.codingchallenge;

import java.util.List;

import org.junit.Test;

import com.oracle.cc.aggregators.AggregatorToggle;
import com.oracle.cc.aggregators.AggregratorFactory;
import com.oracle.cc.aggregators.CustomerAggregrator;
import com.oracle.cc.commands.Command;
import com.oracle.cc.commands.CustomerCommandReceiver;
import com.oracle.cc.commands.CustomerCountGeozone;
import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;
import com.oracle.cc.model.Customer;

import junit.framework.Assert;

public class CustomerAggregratorTests extends BaseDataTest {
	

	@Test
	public void testCustomerAggregator() throws OCCException {
		List<BaseObject> customers = null;
		customers = super.setupCustomerData(AggregatorToggle.CUSTOMER.name());
		Assert.assertEquals(5, customers.size());
	}
	
	@Test
	public void testNegativeAggregator() {
		String data = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\r\n"+
				 "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\r\n"+
				 "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\r\n"+
				 "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\r\n"+
				 "3244132,2346,eu_west,YellowTeam3,ProjectEgg";
		
		CustomerAggregrator customerAgg = (CustomerAggregrator) AggregratorFactory.getAggregrator(AggregatorToggle.CUSTOMER.name());
		List<BaseObject> customers = null;
		try {
			customers = customerAgg.aggregate(data);
		} catch (DataParsingException e) {
			String message = e.getMessage();
			Assert.assertEquals("The input data is of incorrect format", message);
		}
	}
}
