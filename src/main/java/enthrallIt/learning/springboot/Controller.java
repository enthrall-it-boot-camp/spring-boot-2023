package enthrallIt.learning.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/api/v1/admin")
public class Controller {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public ResponseEntity<Message> homepage() {
		return ResponseEntity.ok(new Message("Welcome to Employee Portal"));
				//"Welcome to Employee Portal";
	}
	
	//@GetMapping
	@RequestMapping("/greetings")
	//@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Message> gretting() {
		return ResponseEntity.ok(new Message("Hello Everybody! Here I am " + System.getProperty("user.name")));
	}
	
	@RequestMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	//@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee) {
		return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable Long id) {
		return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Message> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok(new Message("employee: " +id +", has been deleted"));
	}
	
	@GetMapping("/employees/search/{lastName}")
	public ResponseEntity<List<Employee>> getEmployeeByLastName(@PathVariable(name = "lastName") String name) {
		return ResponseEntity.ok(employeeService.getEmployee(name));
	}
}
