package com.suthan.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf=null;
		Session session =null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			 sf = cfg.buildSessionFactory();
			session = sf.openSession();
	 

		//---Parameters ---------------------------------
			// -- position parameters-- 
		
			Query query = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal < ? ");
			 query.setParameter(0, 10000.0f); // parameters
			 
		
			Query query1 = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal > ? and e.esal< ? ");
			query1.setParameter(0, 2000.0f); // parameters
			query1.setParameter(1, 9000.0f);
		
		List<Object[] > list =query1.list();
			
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------------");
			for(Object[] obj:list) {
				for(Object ob:obj) {
					System.out.print(ob+"\t");
				}
				System.out.println();
			}
		
				
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
			sf.close();
		}
	}

}
