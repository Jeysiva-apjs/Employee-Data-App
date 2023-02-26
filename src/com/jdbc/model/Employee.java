package com.jdbc.model;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private String EmployeeAddress;
	private double employeeSalary;
	
	

	public Employee(int employeeId, String employeeName, String employeeAddress, double employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		EmployeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
	}
	public Employee(String employeeName, String employeeAddress, double employeeSalary) {
		super();
		this.employeeName = employeeName;
		EmployeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return EmployeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		EmployeeAddress = employeeAddress;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
		
}
