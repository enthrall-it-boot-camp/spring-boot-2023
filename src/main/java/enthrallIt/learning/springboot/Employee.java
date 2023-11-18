package enthrallIt.learning.springboot;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
//@Component
//@Scope(value = "prototype")
public class Employee {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	//@Autowired
	//@ManyToOne
	//private Integer departmentId;
	//private Department department;
	
	public Employee() {
		System.out.println("This is Employee Default Constructor");
	}
	
	public Employee(Long id, String firstName, String lastName, LocalDate dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
//	public Employee(Long id, String firstName, String lastName, LocalDate dob, Integer departmentId) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.departmentId = departmentId;
//	}
	
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
	
//	public Integer getDepartment() {
//		return departmentId;
//	}
//	
//	public void setDepartment(Integer departmentId) {
//		this.departmentId = departmentId;
//	}
	
	public String fullName() {
		return getFirstName() + " " + getLastName();
	}

}
