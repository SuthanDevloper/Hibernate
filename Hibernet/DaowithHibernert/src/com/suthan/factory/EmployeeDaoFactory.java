package com.suthan.factory;

import com.suthan.dao.EmployeeDao;
import com.suthan.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {

	private static EmployeeDao empDao;
	
	static {
		empDao=new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao()
	{
		return empDao;
	}
	
}
