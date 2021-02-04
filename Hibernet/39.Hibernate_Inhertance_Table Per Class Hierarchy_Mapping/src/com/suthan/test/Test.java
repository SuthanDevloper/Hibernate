package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.EmployeeAccount;
import com.suthan.pojo.StudentAccount;

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
		StudentAccount sa =new StudentAccount();
		
		sa.setAccNo("a3"); 
		 sa.setAccName("AAA"); 
		 sa.setAccType("Savings"); 
		sa.setSid("S2"); 
		 sa.setSbranch("cg");

		sa.setSmarks(87) ;

		 EmployeeAccount ea = new EmployeeAccount(); 
		 ea.setAccNo("a4"); 
		 ea.setAccName("BBB");
		 ea.setAccType("Savings"); 
		 ea.setEid("E2"); 
		 ea.setEsal(5000); 
		 ea.setEaddr("Hyd");
		
		System.out.println("Object save successfuly");
		
		 session.save(sa); session.save(ea);  tx.commit(); 
		 
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Object save failure");
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
			
			
		}
		
	}

}
