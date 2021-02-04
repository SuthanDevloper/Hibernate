package com.suthan.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.suthan.pojo.Employee;
import com.suthan.util.HibernateUtil;

public class EmployeeService {

	public String registration(Employee emp)
{		Transaction tx = null;
		String status = "";
		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =sessionFactory.openSession();
		Employee emp1=(Employee)session.get(Employee.class, emp.getEno());
		if(emp1== null) {
			tx= session.beginTransaction();
			session.save(emp);
			tx.commit();
			status = "success";
		}else {
			tx.rollback();
			status="existed";
		}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		
		return status;
		}
	
}
