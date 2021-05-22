package com.oracle.cc.aggregators;

import java.util.List;

import com.oracle.cc.exceptions.DataParsingException;
import com.oracle.cc.exceptions.OCCException;
import com.oracle.cc.model.BaseObject;

/**
 * 
 * @author Chiranjeevi Sutraye
 *
 */
public interface DataAggregator {
		
	public List<BaseObject> aggregate(String data) throws OCCException;

}
