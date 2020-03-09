package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Singleton {
	public static final Logger log =  LogManager.getLogger();

	private static Singleton singleton = new Singleton( );


	private Singleton() { }


	public static Singleton getInstance( ) {
		return singleton;
	}


	protected static void demoMethod( ) {
		log.info("demoMethod for singleton");
	}
}
