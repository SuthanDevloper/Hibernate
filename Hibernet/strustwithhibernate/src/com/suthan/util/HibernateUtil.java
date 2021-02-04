package com.suthan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
static {
	try {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory=cfg.buildSessionFactory();
	} catch (Exception e) {
	e.printStackTrace();
	}
}
public static SessionFactory getSessionFactory() {
	return sessionFactory;
	
}

}