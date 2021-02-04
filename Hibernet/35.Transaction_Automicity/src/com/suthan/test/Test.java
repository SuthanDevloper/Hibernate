package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Account;

public class Test {

	public static void main(String[] args) {
		
		Configuration oracle_cfg = null;
		Configuration sql_cfg = null;
		
		SessionFactory oracle_sf = null;
		SessionFactory sql_sf = null;
		
		Session oracle_session=null;
		Session sql_session = null;
		
		Transaction oracle_tx = null;
		Transaction sql_tx=null;
		try {
		
		oracle_cfg = new Configuration();
		oracle_cfg.configure("hibernate_oracle.cfg.xml");
		
		sql_cfg = new Configuration();
		sql_cfg.configure("hibernate_sql.cfg.xml");
			
			
			
		StandardServiceRegistryBuilder oracle_builder = new StandardServiceRegistryBuilder();
		oracle_builder = oracle_builder.applySettings(oracle_cfg.getProperties());
		StandardServiceRegistry  oracle_register = oracle_builder.build();
		oracle_sf=oracle_cfg.buildSessionFactory(oracle_register);
		
		
		StandardServiceRegistryBuilder sql_builder = new StandardServiceRegistryBuilder();
		sql_builder = sql_builder.applySettings(sql_cfg.getProperties());
		StandardServiceRegistry sql_registry = sql_builder.build();
		sql_sf=sql_cfg.buildSessionFactory(sql_registry);
		
		
		oracle_session =oracle_sf.openSession();
		sql_session = sql_sf.openSession();
		
		
		oracle_tx=oracle_session.beginTransaction();
		sql_tx = sql_session.beginTransaction();
		
		
		Account source_account = (Account)oracle_session.get(Account.class,"abc121");
		source_account.setBalance(source_account.getBalance()-3000);
		oracle_session.update(source_account);
		
		Account target_account = (Account)sql_session.get(Account.class,"xyz123");
		target_account.setBalance(target_account.getBalance() +5000);
		sql_session.update(target_account);
		
		oracle_tx.commit();
		sql_tx.commit();
		System.out.println("Transaction Success");
		
			
		}catch (Exception e) {
			//e.printStackTrace();
			oracle_tx.rollback();
			sql_tx.rollback();
			System.out.println("Transaction failure");
			System.out.println("Reason"+e.getMessage());
		}finally {
			oracle_session.close();
			oracle_sf.close();
			
			sql_session.close();
			sql_sf.close();
		}
	}

}
