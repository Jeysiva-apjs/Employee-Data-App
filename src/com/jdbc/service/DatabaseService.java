package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Scrollable;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseUtil;

public class DatabaseService {
	
	DatabaseUtil databaseUtil = new DatabaseUtil();
	
	public void insertEmployee(Employee employee) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertEmployeeQuery());
				){
			
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeAddress());
			preparedStatement.setDouble(3, employee.getEmployeeSalary());
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Record created successfully");
			}else {
				System.out.println("Insert Record Failed");
			}
		}
	}
	
	public void getAllEmployee() throws SQLException {
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectAllEmployeeQuery());){
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				printEmployee(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
						resultSet.getDouble(4)));
			}
		}
	}
	
	public boolean getEmployeeById(int id) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectEmployeeById());){
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				printEmployee(new Employee(resultSet.getInt("employee_id"), resultSet.getString("employee_name"), 
						resultSet.getString("employee_address"), resultSet.getDouble("employee_salary")));
				return true;
			}else {
				System.out.println("Employee ID is not present.");
			}	
		}	
		return false;
	}
	public void deleteEmployeeById(int id) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.deleteEmployeeById());){
			
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println("Employee deleted sucessfully");
			}else {
				System.out.println("Employee ID is not present.");
			}	
		}	
	}
		
	
	public void updateEmployee(Employee employee) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.
						prepareStatement(QueryUtil.updateEmployeeQuery(employee.getEmployeeId()));
				){
			
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeAddress());
			preparedStatement.setDouble(3, employee.getEmployeeSalary());
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println("Employee updated sucessfully");
			}else {
				System.out.println("Failed to update record.");
			}	
			
			
		}
	}

	private void printEmployee(Employee employee) {
		System.out.println("Employee Id: " + employee.getEmployeeId());
		System.out.println("Employee Name: " + employee.getEmployeeName());
		System.out.println("Employee Address: " + employee.getEmployeeAddress());
		System.out.println("Employee Id: " + employee.getEmployeeSalary());
		System.out.println("-----------------------------");	
	}
}
