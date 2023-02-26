package com.jdbc.service;

public class QueryUtil {
	
	public static String insertEmployeeQuery() {
		return "INSERT INTO employee_info(employee_name, employee_address, employee_salary) VALUES(?,?,?)";
	}

	public static String selectAllEmployeeQuery() {
		return "SELECT * FROM employee_info";
	}

	public static String selectEmployeeById() {
		return "SELECT * FROM employee_info WHERE employee_id = ?";
	}
	
	public static String deleteEmployeeById() {
		return "DELETE FROM employee_info WHERE employee_id = ?";
	}
	
	public static String updateEmployeeQuery(int employee_id) {
		return "UPDATE employee_info SET employee_name=?, employee_address=?, employee_salary=? "
				+ "WHERE employee_id = " + employee_id;
	}

}
