package com.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;

public class MainClass {

	public static void main(String[] args) {
		
		DatabaseService databaseService = new DatabaseService();
		
		try (Scanner scan = new Scanner(System.in);) {
			
			boolean isRunning = true;
			while (isRunning) {
				System.out.println();
				System.out.println("Enter Choice");
				System.out.println("1. Insert");
				System.out.println("2. Select all");
				System.out.println("3. Select employee by id");
				System.out.println("4. Delete employee");
				System.out.println("5. Update Employee");
				System.out.println("6. Exit");
				System.out.println();

				int choice = scan.nextInt();
				scan.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter name, address and salary: ");
					Employee employee = new Employee(scan.nextLine(), scan.nextLine(), scan.nextDouble());
					databaseService.insertEmployee(employee);
					break;
				case 2:
					databaseService.getAllEmployee();
					break;
				case 3:
					System.out.print("Enter ID of an employee: ");
					databaseService.getEmployeeById(scan.nextInt());
					break;
				case 4:
					System.out.print("Enter ID of an employee: ");
					databaseService.deleteEmployeeById(scan.nextInt());
					break;
				case 5:
					System.out.print("Enter ID of an employee: ");
					int updateId = scan.nextInt();
					scan.nextLine();
					boolean isFound = databaseService.getEmployeeById(updateId);
					
					if(isFound) {
						System.out.println("Enter name, address and salary");
						databaseService.updateEmployee(new Employee(updateId, scan.nextLine(), scan.nextLine(), 
								scan.nextDouble()));	
					}else {
						System.out.println("Employee ID doesn't exist. ");
					}
					break;
				case 6:
					System.out.println("Thankyou! Visit again");
					isRunning = false;
					break;

				default:
					break;
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong...." + e.fillInStackTrace());
		}

	}

}
