package employemanagementsystem;

public class Employee {
	 private int id;
	    private String name;
	    private int age;
	    private String position;
	    private double salary;
	    //Constructor
	    public Employee(int id, String name, int age, String position, double salary) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.position = position;
	        this.salary=salary;
	    }
        // Getter Method
	    public int getId() {
	        return id;
	    }
	    public String getName() {
	        return name;
	    }
	    public int getAge() {
	        return age;
	    }
	    public String getPosition() {
	        return position;
	    }    
	    public double getsalary() {
	    	return salary;
	    }
        //Setter Method
	    public void setSalary(double newSalary, double salary) {
			this.salary=salary;
			
		}
	    @Override
	    public String toString() {
	        return "Employee [ID=" + id + ", Name=" + name + ", Age=" + age + ", Position=" + position + ",Salary="+salary+"]";
	    }
}
