package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.suthan.entity.Employee;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf =null;
		Session session =null;

		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			
		sf= cfg.buildSessionFactory();
		session=sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp =new Employee();
		emp.setEno(103);
		emp.setEname("suthanji");
		emp.setEsal(1000);
		emp.setEaddr("Kandy");
		
		session.save(emp);
		tx.commit();
		System.out.println("Employee Insert success fully");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}

}
