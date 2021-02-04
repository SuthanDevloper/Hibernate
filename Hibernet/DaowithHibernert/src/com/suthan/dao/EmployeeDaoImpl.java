package com.suthan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.suthan.factory.HibernateUtil;
import com.suthan.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	String status="";
	Employee emp = null;

	@Override
	public String addEmployee(Employee employee) {
		try {
			SessionFactory sessionfactory= HibernateUtil.getSessionFactory();
			Session session = sessionfactory.openSession();
			emp =(Employee)session.get(Employee.class, employee.getEno());
			if (emp == null) {
				Transaction tx = session.beginTransaction();
				session.save(employee);
				tx.commit();
				status="success";
			}else {
				status="existed";	
		}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee searchEmployee(int eno) {
		Employee emp =null;
		try {
			SessionFactory sessionfactory= HibernateUtil.getSessionFactory();// calling session we want to call seesion factory
			Session session = sessionfactory.openSession(); // session object
			emp =(Employee)session.get(Employee.class,eno);/* if we get load(),
			if record not their exception arise,, get () display null value */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String UpdateEmployee(Employee emp) {
		try {
			SessionFactory sessionfactory= HibernateUtil.getSessionFactory();// calling session we want to call seesion factory
			Session session = sessionfactory.openSession();
			Transaction tx=session.beginTransaction(); 
			session.update(emp);
			tx.commit();
			status="success";
			
		} catch (Exception e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
	}

	@Override
	public String deleteEmployee(int eno) {
	try {
		SessionFactory sessionfactory= HibernateUtil.getSessionFactory();// calling session we want to call seesion factory
		Session session = sessionfactory.openSession();
		Transaction tx=session.beginTransaction(); 
		Employee employee = new Employee();
		employee.setEno(eno);
		session.delete(employee );
		tx.commit();
		status="success";
	} catch (Exception e) {
		e.printStackTrace();
		status="failure"; 
	}
	return status;
}
}
