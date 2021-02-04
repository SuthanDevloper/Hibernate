package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {
	
	//C3P0ConnectionProvider
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;	
		Transaction tx = null;
	try {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder();
		builder=builder.applySettings(cfg.getProperties());
		
		StandardServiceRegistry register = builder.build();
		
		sessionFactory = cfg.buildSessionFactory(register);
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEno(113);
		emp.setEname("param");
		emp.setEsal(10000);
		emp.setEaddr("London");
		session.save(emp);
		tx.commit();
	} catch (Exception e) {
		tx.rollback();
		e.printStackTrace();
	}finally {
		session.close();
		sessionFactory.close();
	}
	}

}
