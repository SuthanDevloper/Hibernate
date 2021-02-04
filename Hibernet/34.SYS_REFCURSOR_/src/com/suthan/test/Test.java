package com.suthan.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

import oracle.jdbc.internal.OracleTypes;

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
			
			// NAMED PARAMETERS REQUIRED FOR SYS_REFCURSOR IN HIBERNATE
			Query query =session.getNamedQuery("getEmps_proc");
			
			query.setFloat("sal_Range",10000);
			
			List<Employee> list = query.list(); 
			
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("---------------------------");
			for(Employee emp:list) {
				System.out.print(emp.getEno()+"\t");
				System.out.print(emp.getEname()+"\t");
				System.out.print(emp.getEsal()+"\t");
				System.out.print(emp.getEaddr()+"\n");
				
			}
		
			}catch(Exception e) {
				e.printStackTrace();
			}
			session.close();
			sf.close();
		}
		
	}

	




