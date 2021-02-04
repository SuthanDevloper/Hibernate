package com.suthan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="emp1")
public class Employee implements  Serializable {

		
	@Id
	@Column(name="ENO")
	private int eno;

	@Id
	@Column(name="ENAME")
	private String ename;


@Column(name="ESAL")
	private float esal;


	@Column(name="EADDR")
	private String eaddr;

	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

}
