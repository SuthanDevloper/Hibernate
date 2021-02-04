package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Customer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		 
		customer.setCid("c-113");
		customer.setCname("BALA");
	customer.setCaddr("SURREY");
	customer.setCemail("123@gmail.com");
		session.save(customer);
		tx.commit();
		
		System.out.println("Table created successfully");
		session.close();
		sessionFactory.close();

}
	
}
