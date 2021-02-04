package com.suthan.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import oracle.jdbc.internal.OracleTypes;

public class Test {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","suthan");
			cst = con.prepareCall("{?=call getEmployees}");
			
			cst.registerOutParameter(1,OracleTypes.CURSOR);
			cst.execute();
			rs=(ResultSet)cst.getObject(1);
			
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDR")+"\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				rs.close();
				cst.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}



	}


