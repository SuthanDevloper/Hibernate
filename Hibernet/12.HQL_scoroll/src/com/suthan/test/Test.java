package com.suthan.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
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
		
		System.out.println();
		ScrollableResults sr =query.scroll();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		while(sr.next()) {
			Object[] obj = sr.get();
			Employee emp =(Employee) obj[0]; 
			System.out.print(emp.getEno()+"\t");
			 System.out.print(emp.getEname()+"\t"); 
			 System.out.print(emp.getEsal()+"\t");
			 
			 System.out.print(emp.getEaddr()+"\n"); 
		}
		System.out.println("previous ");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		while(sr.previous()) {
			Object[] obj = sr.get();
			Employee emp =(Employee) obj[0]; 
			System.out.print(emp.getEno()+"\t");
			 System.out.print(emp.getEname()+"\t"); 
			 System.out.print(emp.getEsal()+"\t");
			 
			 System.out.print(emp.getEaddr()+"\n"); 
		}
		session.close();
		sf.close();
	}
	
}
