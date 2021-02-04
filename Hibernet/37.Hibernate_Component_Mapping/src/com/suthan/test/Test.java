package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import com.suthan.pojo.Account;
import com.suthan.pojo.Address;
import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try {
		
		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml");
		/*
		 * StandardServiceRegistryBuilder builder = new
		 * StandardServiceRegistryBuilder();
		 * builder=builder.applySettings(configure.getProperties());
		 * 
		 * StandardServiceRegistry registry = builder.build();
		 */
		sf=configure.buildSessionFactory();
		session=sf.openSession();
		tx = session.beginTransaction();
		
		
		Account acc = new Account();
		acc.setAccNo("a112");
		acc.setAccName("hsm");
		acc.setAccType("current");
		
	
		
		Address addr = new Address();
		addr.setPno("101");
		addr.setStreet("peradeniya");
		addr.setCity("Kandy");
		
		Employee emp = new Employee();
		emp.setEno(112);
		emp.setEname("KK");
		emp.setEsal(10000);
		emp.setAcc(acc);
		emp.setAddr(addr);
		
		
		session.save(emp);
		tx.commit();
		System.out.println("employess insert successfully");
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("employess insert failure");
			e.printStackTrace();
			
		}finally {
			session.close();
			sf.close();
		}

	}

}
