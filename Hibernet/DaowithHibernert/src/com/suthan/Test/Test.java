package com.suthan.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.suthan.dao.EmployeeDao;
import com.suthan.factory.EmployeeDaoFactory;
import com.suthan.factory.HibernateUtil;
import com.suthan.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Employee emp= null;
		BufferedReader br =null;
		String status ="";
		int eno =0;
		String ename= "";
		float esal = 0.0f;
		String eaddr ="";
		
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		br=new BufferedReader( new InputStreamReader(System.in));
		try {
		while(true) {
			System.out.println("1.Insert Employee");
			System.out.println("2.Serch Employee");
			System.out.println("3.UpdateEmployee");
			System.out.println("4.Delete Employee");
			//System.out.println("5.Insert Employee");
			System.out.print("u r  option");
			int option = Integer.parseInt(br.readLine());
			switch (option) {
			case 1:
				System.out.println("-------ADD Employees module--------");
				System.out.print("Employee number");
				eno=Integer.parseInt(br.readLine());
				System.out.print("Enter Employee Name");
				 ename=br.readLine();
				System.out.print("Enter Employee Salary");
				 esal = Float.parseFloat(br.readLine());
				System.out.print("Enter Employee Address");
				 eaddr= br.readLine();
				
				emp = new Employee();
				emp.setEno(eno);
				emp.setEname(ename);
				emp.setEsal(esal);
				emp.setEaddr(eaddr);
				
				status =dao.addEmployee(emp);
				if(status.equals("success")) {
					System.out.println(" Employee Insert sucess");
				}
				if(status.equals("failure")) {
					System.out.println(" Employee Insert failure");
				}
					if(status.equals("existed")) {
						System.out.println(" Employee not exited");
					}
			
				break;
			case 2:
			
				System.out.println("-------search Employees module--------");
				System.out.print("enter Employee number");
				 eno = Integer.parseInt(br.readLine());
				emp=dao.searchEmployee(eno);
				if (emp == null) {
					System.out.println("Employee not exited");
				}else {
					System.out.println("Employee Details");
					System.out.println("Employee number --"+emp.getEno());
					System.out.println("Employee name ----"+emp.getEname());
					System.out.println("Employee salary ----"+emp.getEsal());
					System.out.println("Employee address ----"+emp.getEaddr());
				}
				break;
			case 3:
				System.out.println("-------Updare Employees module--------");
				System.out.print("enter Employee number");
				 eno = Integer.parseInt(br.readLine());
				emp=dao.searchEmployee(eno);
				if (emp == null) {
					System.out.println("Employee not exited");
				}else {
					System.out.println("Enter new Employee Details");
					System.out.println("Employee Details");
					System.out.println("Employee number --"+emp.getEno());
					System.out.println("Emp old value--"+emp.getEname()+",New value:");
					String empName=br.readLine();
					System.out.println("Employee olg salary ----"+emp.getEsal()+", New Value");
					String empSal=br.readLine();
					System.out.println("Employee old address ----"+emp.getEaddr()+",New Value");
					String empAddr=br.readLine();
					
					Employee employee = new Employee();
					employee.setEno(eno);
					if(empName == null || empName.equals("")) {
						employee.setEname(emp.getEname());
					}else
					{
						employee.setEname(empName);
					}
					
					if(empSal == null || empSal.equals("")) {
						employee.setEsal(emp.getEsal());
					}else
					{
						employee.setEsal(Float.parseFloat(empSal));
					}
					
					if(empAddr == null || empAddr.equals("")) {
						employee.setEaddr(emp.getEaddr());
						}
						else
						{
							employee.setEaddr(empAddr);
						}
					
					status=dao.UpdateEmployee(employee);
					if(status.equals("success")) {
						System.out.println(" Employee update sucess");
					}
					if(status.equals("failure")) {
						System.out.println(" Employee update failure");
					}
					
				}
				
				break;
			case 4:
				System.out.print("----Delete Module ----");
				System.out.print("enter Employee number");
				 eno = Integer.parseInt(br.readLine());
				emp=dao.searchEmployee(eno);
				if (emp == null) {
					System.out.println("Employee not exited");
				}else {
					status = dao.deleteEmployee(eno);
					if (status.equals("success")) {
						System.out.println("Employee  delete succes");
					}else
					{if (status.equals("failure")) {
						System.out.println("Employee  delete failed");
					}
						
					}
				}
			
				break;
			case 5 :
				System.out.println("tHANKS");
				HibernateUtil.cleanup();
				System.exit(0);
			
				
				
				break;
			default:
				System.out.println("Enter 1, 2,3,4,5");
				break;
			}
		}
			
		} catch (Exception e) {
			
		}

	}

}
