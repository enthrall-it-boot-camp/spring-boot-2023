package enthrallIt.learning.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping
	public String gretting() {
		return "Hello Everybody! Here I am " + System.getProperty("user.name");
	}
}
