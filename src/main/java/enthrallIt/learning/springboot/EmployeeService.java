package enthrallIt.learning.springboot;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private List<Employee> employees = new ArrayList<>(List.of(
			new Employee(101L, "MS", "Dhoni", LocalDate.of(1988, Month.APRIL, 26)),
			new Employee(102L, "Sakib", "Al Hasan", LocalDate.of(1999, Month.JANUARY, 2)),
			new Employee(103L, "Rickey", "Ponting", LocalDate.of(2000, Month.DECEMBER, 6))
			));
	
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	public Employee getEmployee(Long id) {
		Employee employee = null;
		for(Employee employe : employees) {
			if(employe.getId().equals(id)) {
				employee = employe;
			}
		}
		return employee;
	}
	
	public void createEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void deleteEmployee(Long id) {
		for(Employee employee: employees) {
			if(employee.getId().equals(id)) {
				employees.remove(employee);
			}
		}
	}
	
	public void updateEmployee(Employee employee, Long id) {
		int index = 0;
		for(Employee employe: employees) {
			if(employe.getId().equals(id)) {
				employees.set(index,employee);
			}
			index++;
		}
	}
}
