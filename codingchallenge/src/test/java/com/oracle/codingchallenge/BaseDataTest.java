package com.oracle.codingchallenge;

import java.util.List;

import com.oracle.cc.aggregators.AggregratorFactory;
import com.oracle.cc.aggregators.DataAggregator;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;

/**
 * 
 * @author Chiranjeevi Sutraye
 * This class all the data building activity for its sub-classes which can directly 
 * run the commands and test them.
 *
 */
public class BaseDataTest {
	
	protected List<BaseObject> setupCustomerData(String aggregatorToggle) throws OCCException {
		String data = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\r\n"+
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\r\n"+
				"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\r\n"+
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s\r\n"+
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s\r\n";

		return AggregratorFactory.getAggregrator(aggregatorToggle).aggregate(data);
	}
	
	//TODO: All upcoming data setup for different models would go here
	
}
