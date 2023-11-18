package enthrallIt.learning.springboot;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeesDataService {
	
	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return args -> {
			Employee empl1 = new Employee(101L, "MS", "Dhoni", LocalDate.of(1988, Month.APRIL, 26));
			Employee empl2 = new Employee(102L, "Sakib", "Al Hasan", LocalDate.of(1999, Month.JANUARY, 2));
			Employee empl3 = new Employee(103L, "Rickey", "Ponting", LocalDate.of(2000, Month.DECEMBER, 6));
			
			employeeRepository.saveAll(List.of(empl1,empl2,empl3));
		};
	}
}
