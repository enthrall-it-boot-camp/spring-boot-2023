package enthrallIt.learning.springboot;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE_DATA")
//@Component
//@Scope(value = "prototype")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "First Name should not blank")
	private String firstName;
	
	@NotBlank(message = "Last Name should not blank")
	private String lastName;
	
	@Column(name = "DATE_OF_BIRTH")
	@NotNull(message = "Date of birth should not blank")
	private LocalDate dob;
	
	@Transient
	private String fullName;
	
	private String age;
	
	public Employee() {
		System.out.println("This is Employee Default Constructor");
	}
	
	public Employee(String firstName, String lastName, LocalDate dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.fullName = getFullName();
		this.age = getAge();
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
	
	public String getFullName() {
		return firstName+" "+lastName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAge() {
		return Period.between(dob, LocalDate.now()).getYears() + " Years "
		+ Period.between(dob, LocalDate.now()).getMonths() + " Months "
		+ Period.between(dob, LocalDate.now()).getDays() + " Days";
	}
	
	public void setAge(String age) {
		this.age = age;
	}
}
