package enthrallIt.learning.springboot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		ArrayList<Employee> employees = new ArrayList<>();
		
		for(Employee employee: employeeRepository.findAll()) {
			employees.add(employee);
		}
		return employees;
	}
	
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found"));
	}
	
	public List<Employee> getEmployee(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		}
	}
	
	public Employee updateEmployee(Employee employee, Long id) {
		 return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employe Not Found"));
	}
}
