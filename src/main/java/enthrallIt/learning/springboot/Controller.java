package enthrallIt.learning.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1")
public class Controller {

	@Autowired
	private EmployeeService employeeService;
	
	//@GetMapping
	@RequestMapping("/greetings")
	public String gretting() {
		return "Hello Everybody! Here I am " + System.getProperty("user.name");
	}
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	//@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return employee;
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		employeeService.updateEmployee(employee, id);
		return "employee: " +id +", has been updated";
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "employee: " +id +", has been deleted";
	}
}
