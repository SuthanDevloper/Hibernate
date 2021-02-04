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
			
			  
			
			
		
			
			//------------------------------------------------------------------------------------- 
		 //Aggregate Function
		//sum is double value 
		//min , MAX ---float
		//average -double 
		Query query = session.createQuery("select avg(e.esal) from Employee as e ");
		Query query1 = session.createQuery("select sum(e.esal) from Employee as e ");
		Query query2 = session.createQuery("select min(e.esal) from Employee as e ");
		Query query3= session.createQuery("select max(e.esal) from Employee as e ");
		Query query4= session.createQuery("select count(e.esal) from Employee as e ");
		List<Double> list =query.list();
		System.out.print("Avg"+list);
		
		List<Double> list1 =query1.list();
		System.out.print("Sum"+list1);
		
		List<Float> list2 =query2.list();
		System.out.print("min"+list2);
		
		List<Float> list3 =query3.list();
		System.out.print("max"+list3);
		
		List<Float> list4 =query4.list();
		System.out.print("count"+list4);
		
		
			/*
		//---Parameters ---------------------------------
			// -- position parameters-- 
		
			//Query query = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal < ? ");
			// query.setParameter(0, 10000.0f); // parameters
			// -- position parameters-- 
		
			//Query query = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal > ? and e.esal< ? ");
			//query.setParameter(0, 10000.0f); // parameters
			//query.setParameter(1, 20000.0f);
		
			// Named parametrs 
			
			//Query query = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal <:Sal_Range ");
			//query.setParameter("Sal_Range", 10000.0f);
			
		//Query query = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal >=:min and  e.esal <= :max ");
		//query.setParameter("min", 6000.0f);
		//query.setParameter("max", 16000.0f);
		
		//  position paarameters and name parameters 
		// Should be position paarameter come first
		//Query query = session.createQuery("select e.eno, e.ename,e.esal, e.eaddr FROM Employee as e where e.esal >=? and  e.esal <= :max ");
		//query.setParameter(0, 6000.0f);
		//query.setParameter("max", 16000.0f);
			
		//----------SUB QUERYS-------------------------------------------
		/*
		 * Query query = session.
		 * createQuery("select e1.eno, e1.ename,e1.esal, e1.eaddr FROM Employee as e1 where e1.esal < (select e2.esal from Employee as e2 where e2.eno=114) "
		 * ); List<Object[] > list =query.list();
		 * 
		 * 
		 * System.out.println("ENO\tENAME\tESAL\tEADDR");
		 * System.out.println("------------------------------"); for(Object[] obj:list)
		 * { for(Object ob:obj) { System.out.print(ob+"\t"); } System.out.println(); }
		 */
				
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
			sf.close();
		}
	}

}
