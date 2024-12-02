package employemanagementsystem;

import java.util.Scanner;

public class Employeedetails {
	private int idToUpdate;
	public void employeedetails(){
	Scanner scanner = new Scanner(System.in);
	Company company = new Company();
	while (true) {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. List Employees");
        System.out.println("4. Update Employees salary");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } 
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            continue;
        }
        switch (choice) {
            case 1:
                // Add Employee
                try {
                    System.out.print("Enter Employee ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Employee Salary:");
                    int salary = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Employee Age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();

                    Employee employee = new Employee(id, name, age, position,salary);
                    company.addEmployee(employee);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for ID, Age.");
                }
                break;
            case 2:
                // Remove Employee
                try {
                    System.out.print("Enter Employee ID to remove: ");
                    int idToRemove = Integer.parseInt(scanner.nextLine());
                    company.removeEmployee(idToRemove);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for Employee ID.");
                } catch (EmployeeNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                // List Employees
                company.listEmployees();
                break;         
            case 4:
            	//Update Employees
            	 try {
                     System.out.print("Enter Employee ID to update salary: ");
                     int idToUpdate = Integer.parseInt(scanner.nextLine());
                     System.out.print("Enter new salary: ");
                     double newSalary = Double.parseDouble(scanner.nextLine());
                     company.updateSalary(idToUpdate, newSalary);
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid input for Employee ID or Salary.");
                 } catch (EmployeeNotFoundException e) {
                     System.out.println(e.getMessage());
                 }
                 break;
            case 5:
                // Exit the system
                System.out.println("Exiting the system.");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Choose choise from 1-5.");
        }
    }
}
}


