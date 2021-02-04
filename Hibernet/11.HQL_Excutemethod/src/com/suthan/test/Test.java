package com.suthan.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = null;
		Session session =null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			 sf = cfg.buildSessionFactory();
			 session = sf.openSession();
			 Transaction tx = session.beginTransaction();
				/*
				 * //Query query = session.createQuery("from Employee");
				 * 
				 * 
				 * 
				 * Query query_update = session.
				 * createQuery("update Employee  e set e.esal=e.esal+500 where e.esal< 10000");
				 * int update_rowCount=query_update.executeUpdate();
				 * System.out.println("Record update "+update_rowCount); System.out.println();
				 */
			
			
			
			
			
			Query update_query = session.createQuery("update Employee  set esal=esal +500 where esal<9000");
			int update_rowCount =update_query.executeUpdate();
			System.out.println("Record update "+update_rowCount);
			tx.commit();
			System.out.println(); 
			
			/*
			Query delete_query =session.createQuery("delete from Employee as e where e.esal < 11000");
			int delete_rowCount =delete_query.executeUpdate();
			System.out.println("Record deleted "+delete_rowCount);*/
			System.out.println();
		} catch (Exception e) {
		e.printStackTrace();
		}
		sf.close();
		session.close();
	}

}
