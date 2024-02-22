package employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/listBySal/{fromSal}/{toSal}")
	public List<Employee> getEmployeesBySal(@PathVariable Integer fromSal, @PathVariable Integer toSal) {
		return employeeService.getEmployeesBySal(fromSal, toSal);
	}
	}
