package employemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private List<Employee> employees;
	public Company() {
		this.employees = new ArrayList<>();
	}
	// Method to add Employee
	public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }
	// Method to remove Employee
	public void removeEmployee(int id) throws EmployeeNotFoundException{
		Employee employee = findEmployee(id);
		if(employee!=null) {
			employees.remove(employee);
			System.out.println("Employee removed Successfully");
		}
		else {
			throw new EmployeeNotFoundException("Employee with ID"+id+"not found");
		}
	}
	// Method to Find the Employee by Employee Id
	public Employee findEmployee(int id) {
		for (Employee employee:employees) {
			 if (employee.getId() == id) {
	                return employee;
	            }
		}
		return null;
    }
	// Method to List the Employee
	public void listEmployees() {
		if (employees.isEmpty()) {
			System.out.println("No employees found.");
	    }
		else {
			employees.forEach(System.out::println);
	    }
	 }
	// Method to update Salary of Employee by Employee Id
	 public void updateSalary(int id, double newSalary) throws EmployeeNotFoundException {
		 Employee employee = findEmployee(id);
		 if (employee != null) {
	            employee.setSalary(newSalary, newSalary); // Set the new salary
	            System.out.println("Salary updated successfully for employee with ID: " + id);
	            System.out.println("Updated details: " + employee); // Print updated employee details
	     }
		 else {
	            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
	     }
     }
}
