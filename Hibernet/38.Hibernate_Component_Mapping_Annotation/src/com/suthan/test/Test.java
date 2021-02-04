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
		//tx = session.beginTransaction();
		Employee emp =(Employee)session.get(Employee.class, 112);
		System.out.println("Employee details");
		System.out.println("------------------");
		System.out.println("ENO     "+emp.getEno());
		System.out.println("Name    "+emp.getEname());
		System.out.println("SALARY   "+emp.getEsal());
		System.out.println();
		Account acc = emp.getAcc(); /* here account object in employee object ,,
		 we get from get()in Employee class*/
		System.out.println("Account details");
		System.out.println("------------------");
		System.out.println("ACCNO    "+acc.getAccNo());
		System.out.println("ACCName  "+acc.getAccName());
		System.out.println("ACCTYPE  "+acc.getAccType());
		
		System.out.println();
		
		Address add = emp.getAddr();
		System.out.println("Address details");
		System.out.println("------------------");
		System.out.println("pno    "+add.getPno());
		System.out.println("street  "+add.getStreet());
		System.out.println("city "+add.getCity());
			
		} catch (Exception e) {
			//tx.rollback();
			//System.out.println("employess insert failure");
			e.printStackTrace();
			
		}finally {
			session.close();
			sf.close();
		}

	}

}
