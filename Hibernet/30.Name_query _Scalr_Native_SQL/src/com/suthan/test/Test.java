package com.suthan.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			 sf = cfg.buildSessionFactory();
			session = sf.openSession();
	

		
		
		// 03. WITHOUT SQL QUERY ---SQL QUERY IN MAPPING FULE.
		
		Query query =session.getNamedQuery("sql_query");
		
		query.setFloat(0,1000);
		query.setFloat("max",10000); 
		List<Object[]> list = query.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("---------------------------");
		for(Object[] obj:list) {
			System.out.print(obj[0]+"\t");
			System.out.print(obj[1]+"\t");
			System.out.print(obj[2]+"\t");
			System.out.println(obj[3]);
		} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
		sf.close();
	}

	}


