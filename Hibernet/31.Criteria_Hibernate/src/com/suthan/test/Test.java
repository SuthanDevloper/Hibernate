package com.suthan.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			sf = cfg.buildSessionFactory();
			session = sf.openSession();
				
			//Create Criteria object 
				Criteria criteria  = session.createCriteria(Employee.class);
				
				//create ProjectionList and add all projection
				ProjectionList projectionlist = Projections.projectionList();
				projectionlist.add(Projections.property("eno"));
				projectionlist.add(Projections.property("ename"));
				projectionlist.add(Projections.property("esal"));
				projectionlist.add(Projections.property("eaddr"));
				
				//add to ProjectionList to criteria
				criteria.setProjection(projectionlist);
				
				//Make criterion 
				Criterion c1=Restrictions.gt("esal",2.0f);
				Criterion c2=Restrictions.lt("esal",9000.0f);
				
				// criterion  add to criterio
				criteria.add(c1);
				criteria.add(c2);
				
				//create oreder
				Order order =Order.desc("ename");
				
				//add order ti criteria
				criteria.addOrder(order);

		List<Object[]> list = criteria.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("---------------------------");
		for(Object[] obj:list) {
			System.out.print(obj[0]+"\t");
			System.out.print(obj[1]+"\t");
			System.out.print(obj[2]+"\t");
			System.out.println(obj[3]);
		} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		session.close();
		sf.close();
	}

	}


