package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
	
	private static SessionFactory factory;
	//static init block to create singleton SF
	//Configuration --> configure --> buildSessionFactory
	static {
		System.out.println("In static init block");
		//build SF
		factory = new Configuration()//empty config created
				  .configure() //reads hibernate config xml file and populates the config
		          .buildSessionFactory(); //build instance of SF from the population 
		System.out.println("Created SF....");
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
	

}
