// class for holding employee information
public class Employee extends User{
	int employee_id;
	
	// create new employee
    public Employee newEmployee(int employee_id, String first_name, String last_name, Address address) {
	    this.id = 0;
	    this.employee_id = employee_id;
	    this.first_name = first_name;
	    this.last_name = last_name;
	    this.address = address;
	    users.add(this);
	    
	    return this;
    }
}
