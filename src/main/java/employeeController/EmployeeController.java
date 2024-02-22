package employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import employeeEntity.Employee;
import employeeService.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@PostMapping("/save")
	public String saveEmployees(@RequestBody Employee employee) {
		 return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id){
		return employeeService.getEmployeesById(id);
	}
	
	@GetMapping("/listByCon")
	public List<Employee> getEmployeesByCon(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer fromSal, 
			@RequestParam(required = false) Integer toSal) {
		return employeeService.getEmployeesByCon(name,fromSal, toSal);
	}
	
	}
