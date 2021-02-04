package com.suthan.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session =null;
		try {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder=builder.applySettings(cfg.getProperties());
		StandardServiceRegistry registry=builder.build();
		sf=cfg.buildSessionFactory(registry);
		session=sf.openSession();
		
		Query query = session.createQuery("from Employee");
		Filter filter = session.enableFilter("empFilter"); 
		 Scanner s = new Scanner(System.in); 
		 System.out.println("Employee Types:"); 
		 System.out.println("1.PERM"); 
		 System.out.println("2.TEMP"); 
		 System.out.print("Your Option :"); 
		 String type = s.next(); 
		 filter.setParameter("type", type);
		 
		//Filter filter= session.enableFilter("empFilter");// logica name
		//filter.setParameter("type","PERM"); // provide parameter name, and conditon name
		 List<Employee> list = query.list(); 
		 
		 System.out.println("ENO\tENAME\tESAL\tEADDR\tETYPE");
		  System.out.println("-----------------------------------------"); 
		  for(Employee emp: list) { 
		  System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getEsal()+"\t"+emp.getEaddr()+"\t"+emp.getEtype()); 
		 } 
		 session.close(); 
		 sf.close();
		  }catch(Exception e) {
		  e.printStackTrace(); 
		  } 
		  }
}