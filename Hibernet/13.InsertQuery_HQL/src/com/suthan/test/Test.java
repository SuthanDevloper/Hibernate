package com.suthan.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		
		try {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(cfg.getProperties());
		
		StandardServiceRegistry registry=builder.build();
		sf =cfg.buildSessionFactory(registry);
		session=sf.openSession();
		
		Query insert_query = session.createQuery("insert into Employee2(eno,ename,esal,eaddr)select e.eno, e.ename, e.esal, e.eaddr from Employee1 as e");
		int rowCount = insert_query.executeUpdate();
		System.out.println("All record insert success ");
		System.out.println("Record insert "+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}

}
