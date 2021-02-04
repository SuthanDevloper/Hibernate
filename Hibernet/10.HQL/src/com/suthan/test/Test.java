package com.suthan.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) throws Exception{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> emplist=query.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------");
		
		for(Employee emp:emplist) {
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.print(emp.getEaddr()+"\n");
		}
		System.out.println("");
		System.out.println("Getting from List");
		Iterator<Employee> iterator = query.iterate(); // 2 method 
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------");
		while(iterator.hasNext()) {
			Employee emp = iterator.next();
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.print(emp.getEaddr()+"\n");
		}
		/*
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder= builder.applySettings(cfg.getProperties());
		
		
		
		StandardServiceRegistry registry = builder.build();
		
		
		SessionFactory sf = cfg.buildSessionFactory(registry);
		Session session = sf.openSession();
		
		Query query=session.createQuery("from Employee"); // such as select * from emp1;
		// hHIBERNATE SW INTERNALLY , SQL QUERY CHANGE TO DATABASE DEPENCE SQL QUERY
		Object obj =query.uniqueResult(); // only one data we will get from the database
		Employee emp =(Employee)obj;
		System.out.println("getting from uniqueresult"); // 3 method 
		System.out.println(emp.getEno());
		System.out.println(emp.getEname());
		System.out.println(emp.getEsal());
		System.out.println(emp.getEaddr());
		------------------------------------------
		List<Employee> emp_list = query.list(); // 1 method 
		System.out.println("Getting from List");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------");
		
		for(Employee emp:emp_list) {
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.print(emp.getEaddr()+"\n");
		}
		System.out.println("");
		System.out.println("Getting from List");
		-----------------------------------------
		Iterator<Employee> iterator = query.iterate(); // 2 method 
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------");
		while(iterator.hasNext()) {
			Employee emp = iterator.next();
			System.out.print(emp.getEno()+"\t");
			System.out.print(emp.getEname()+"\t");
			System.out.print(emp.getEsal()+"\t");
			System.out.print(emp.getEaddr()+"\n");
		} */
		
	
		
		session.close();
		sf.close();
	}
	
}
