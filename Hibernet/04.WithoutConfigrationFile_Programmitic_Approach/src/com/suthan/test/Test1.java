package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory sf =null;
		Session  session  = null;
		try {
			Configuration config = new Configuration();
			
			config.setProperty("hibernate.connection.driver_Class","oracle.jdbc.OracleDriver");
			config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
			config.setProperty("hibernate.connection.username", "system");
			config.setProperty("hibernate.connection.password", "suthan");
			config.setProperty("show_sql","true");
			config.setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect"); 
			//config.addResource("Employee.hbm.xml");
			config.addAnnotatedClass(Employee.class);
			sf =config.buildSessionFactory();
			session =sf.openSession();
			
			Employee emp = (Employee) session.get(Employee.class,111);
			if(emp==null) {
				System.out.println("Employee not existed");
				
			}else {
				System.out.println("Employee Id "+emp.getEno());
				System.out.println("Employee Id "+emp.getEname());
				System.out.println("Employee Id "+emp.getEsal());
				System.out.println("Employee Id "+emp.getEaddr());
				//System.out.println("Employee Id "+emp.getEsal());
			}
	
		
		} catch (Exception e) {
		e.printStackTrace();	
		}finally {
			 session.close();
			sf.close();
		}
	}

}
