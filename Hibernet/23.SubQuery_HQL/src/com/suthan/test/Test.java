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
	 
		//----------SUB QUERYS-------------------------------------------
		Query query = session.createQuery("select e1.eno, e1.ename,e1.esal, e1.eaddr FROM Employee as e1 where e1.esal > (select e2.esal from Employee as e2 where e2.eno=201) ");
		List<Object[] > list =query.list();
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
