package com.suthan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=null;
		Session s = null;
		try { 
			Configuration cfg = new Configuration();
			cfg.configure("/com/suthan/resources/hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
			s=sf.openSession();
			Employee emp = (Employee)s.get(Employee.class,122);
			
		System.out.println(emp);
//			if (emp==null) {
//				
//		System.out.println("Employee does not existed");
//		
//			}
//			else
//			{
//				System.out.println("Employee Details");
//				System.out.println("-------------------");
//				System.out.println(emp.getEno());
//				System.out.println(emp.getEname());
//				System.out.println(emp.getEsal());
//				System.out.println(emp.getEaddr());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
			sf.close();
			
		}
		
	}

}
