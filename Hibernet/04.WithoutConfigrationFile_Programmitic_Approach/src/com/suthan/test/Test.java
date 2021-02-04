package com.suthan.test;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=null;
		Session session= null;				
//		try {
//		
//		Configuration config = new Configuration();
//		
//		/*config.setProperty("hibernate.connection.driver_Class","oracle.jdbc.OracleDriver");
//		config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
//		config.setProperty("hibernate.connection.username", "system");
//		config.setProperty("hibernate.connection.password", "suthan");
//		config.setProperty("show_sql","true");
//		config.setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect"); */
//		config.addResource("Employee.hbm.xml");
//		  
//		
//		//config.addAnnotatedClass(Employee.class);
//		
//		sessionFactory = config.buildSessionFactory();
//		session =sessionFactory.openSession();
//		
//		Employee emp=(Employee)session.get(Employee.class,124);
//		if(emp == null) {
//			System.out.println("Employee doesnot existed");
//		}else {
//			System.out.println("Employee Details");
//			System.out.println("------------------------");
//			System.out.println("Employee No...." +emp.getEno());
//			System.out.println("Employee Name..."+emp.getEname());
//			System.out.println("Employee Salary."+emp.getEsal());
//			System.out.println("Employee Address."+emp.getEaddr());
//		}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//			sessionFactory.close();
//		}	
		
		try {
		Configuration cfg = new Configuration();
		SessionFactory  sfg = cfg.buildSessionFactory();
			
		} catch (Exception e) {
			//e.p
		}
		
	}
}
