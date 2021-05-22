package com.oracle.codingchallenge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author ChiranjeeviSutraye
 * Test suite for the application
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	CustomerAggregratorTests.class,
	AverageDurationCommandTest.class,
	CustomerCountGeozoneCommandTest.class,
	UniqueCustomerCountCommandTest.class,
	CustomersGeozoneCommandTest.class
})
public class TestSuite {
    
}
