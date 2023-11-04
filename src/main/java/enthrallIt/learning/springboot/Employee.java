package enthrallIt.learning.springboot;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	@Autowired
	private Department department;
	
	public Employee() {
		System.out.println("This is Employee Default Constructor");
	}
	
	public Employee(Long id, String firstName, String lastName, LocalDate dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String fullName() {
		return getFirstName() + " " + getLastName();
	}
	
	public void getLog() {
		System.out.println("Logging : Employee class object");
		department.getLog();
	}
}
