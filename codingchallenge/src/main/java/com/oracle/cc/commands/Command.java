package com.oracle.cc.commands;

/**
 * 
 * @author Chiranjeevi Sutraye
 * Its implementations invoke the corresponding commands in the command receiver
 *
 */
public interface Command {
	public Object execute(Object param);
}
