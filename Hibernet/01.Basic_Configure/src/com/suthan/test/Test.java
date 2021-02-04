package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;// predefine class for congigration class

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		/*
		 * // Activating Hibernate software Configuration cfg = new
		 * Configuration();//create configure object in heap file only.
		 * cfg.configure();// now and keep a all the configuration file details here
		 * 
		 * SessionFactory sf = cfg.buildSessionFactory();create SessionFactory object
		 * able to load driver, cretae connection, statement
		 * 
		 * Session session = sf.openSession(); //create Session object for database
		 * operation
		 * 
		 * Transaction tx = session.beginTransaction();//create Transaction object for
		 * non-select object
		 * 
		 * // step 3 //creating object pojo class Employee emp = new Employee();
		 * emp.setEno(125); emp.setEname("arun"); emp.setEsal(5000);
		 * emp.setAddr("kandy"); // then give to hibernate software
		 * 
		 * //step 4 // Peristance operation System.out.println(); step 5 try prepare sql
		 * query , internally identify(refflection api) the pojo class name and go to
		 * identify the mapping file and getting value of the table name, column and
		 * create insert sql query tx.commit();
		 * System.out.println("Employeeed saved succes"); session.close(); sf.close();
		 */

	}

}
