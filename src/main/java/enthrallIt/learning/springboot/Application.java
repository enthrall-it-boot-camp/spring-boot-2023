package enthrallIt.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Employee employee = context.getBean(Employee.class);
		employee.getLog();
		
		Employee employee1 = context.getBean(Employee.class);
		employee1.getLog();
	}
}
