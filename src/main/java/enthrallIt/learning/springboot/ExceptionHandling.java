package enthrallIt.learning.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//@RequestMapping("/api/v1/admin")
public class ExceptionHandling {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handlingInvalidArguments(MethodArgumentNotValidException e){
		Map<String, String> map = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(err -> map.put(err.getField(), err.getDefaultMessage()));
		return map;
	}
	
	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> handlingEmployeeNotFoundException(EmployeeNotFoundException e){
		Map<String, String> map = new HashMap<>();
		map.put("errorMsg", e.getMessage());
		return map;
	}
}
