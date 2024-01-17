package enthrallIt.learning.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
	private Integer id;
	private String name;
	
//	public Department() {
//		System.out.println("This is from department");
//	}
//	
//	public Department(Integer id, String name) {
//		this.id = id;
//		this.name = name;
//	}
//	
//	public Integer getDepartmentId() {
//		return id;
//	}
//	
//	public void setDepartmentId(Integer departmentId) {
//		this.id = departmentId;
//	}
//	
//	public String getDepartmentName() {
//		return name;
//	}
//	
//	public void setDepartmentName(String departmentName) {
//		this.name = departmentName;
//	}
}
