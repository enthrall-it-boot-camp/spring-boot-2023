package enthrallIt.learning.springboot;

import org.springframework.stereotype.Component;

@Component("dept")
public class Department {
	
	private Integer departmentId;
	private String departmentName;
	
	public Department() {
		System.out.println("This is from department");
	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void getLog() {
		System.out.println("Logging : Department Class object");
	}
}
