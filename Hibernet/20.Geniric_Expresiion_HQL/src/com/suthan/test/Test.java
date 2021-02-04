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
			
				//
			 // Query query= session.createQuery("select e.eno,lower(e.ename), e.esal ,upper(e.eaddr) from Employee as e ");
			  Query query1= session.createQuery("select e.ename, e.esal from Employee as e where e.ename IN('suthan','nani')");
			  Query query2= session.createQuery("select e.ename, e.esal from Employee as e where e.ename BETWEEN 'DDD' AND 'suthan'");
			  Query query3= session.createQuery("select e.ename, e.esal from Employee as e where e.ename LIKE 's%'");
			  Query query4= session.createQuery("select e.ename, e.esal from Employee as e where e.eaddr is null");
			  List<Object[]> list =query4.list();
			 // List<Object[]> list1 =query2.list();
			  System.out.println("ENO\tENAME\tESAL\tEADDR");
			  System.out.println("------------------------------");
			  for(Object[] obj:list)
			  {
				  for(Object ob:obj)
			  { 
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
