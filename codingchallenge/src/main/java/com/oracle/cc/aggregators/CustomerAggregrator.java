package com.oracle.cc.aggregators;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.model.BaseObject;
import com.oracle.cc.model.Customer;

public class CustomerAggregrator implements DataAggregator {
	
	public static int STANDARD_CUSTOMER_FIELD_COUNT=6;
	private static Logger log = Logger.getLogger(CustomerAggregrator.class.getName());

	public List<BaseObject> aggregate(String data) throws DataParsingException {
		List<BaseObject> customers = new ArrayList<BaseObject>();
		String[] rows = data.split("\r\n");
		for(String row : rows) {
			String[] columnsInRow = row.split(",");
			if(columnsInRow.length!=STANDARD_CUSTOMER_FIELD_COUNT) {
				DataParsingException dpe = new DataParsingException();
				log.log(Level.SEVERE, dpe.getMessage(), dpe.getCause());
				throw dpe;
			}
				
			Customer customer = new Customer(columnsInRow[0]);
			customer.setContractId(columnsInRow[1]);
			customer.setGeozone(columnsInRow[2]);
			customer.setTeamcode(columnsInRow[3]);
			customer.setProjectcode(columnsInRow[4]);
			customer.setBuildDuration(columnsInRow[5]);
			customers.add(customer);
		}
		log.info(CustomerAggregrator.class.getName()+" generated data");
		return customers;
	}

}
