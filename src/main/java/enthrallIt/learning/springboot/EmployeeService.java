package enthrallIt.learning.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public Optional<Employee> getEmployee(Long id) {
		if(employeeRepository.existsById(id)) {
			return employeeRepository.findById(id);
		}else {
			throw new IllegalStateException("Employee not found");
		}
	}
	
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		}
	}
	
	public void updateEmployee(Employee employee, Long id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.save(employee);
		}
	}
}
