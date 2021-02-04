package com.suthan.dao;

import com.suthan.pojo.Employee;

public interface EmployeeDao {
public String addEmployee(Employee emp);
public Employee searchEmployee(int eno);
public String UpdateEmployee(Employee emp);
public String deleteEmployee(int eno);


}
