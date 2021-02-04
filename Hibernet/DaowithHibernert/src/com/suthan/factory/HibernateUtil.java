package com.suthan.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionfactory;
	
	static {
		try {
		Configuration config = new Configuration();
		config.configure("/com/suthan/resources/hibernate.cfg.xml");
		sessionfactory = config.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionfactory;
		
	}
	
	public static void cleanup() {
		try {
			sessionfactory.close();
		} catch (Exception e) {
			
		}
	}
}
