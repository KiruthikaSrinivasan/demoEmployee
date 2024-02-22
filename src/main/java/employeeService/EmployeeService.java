package employeeService;

import org.springframework.stereotype.Service;

import employeeEntity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
	

	    private static final String FILE_PATH = "employees.txt";

	    public List<Employee> getEmployees() {
	        List<Employee> employees = new ArrayList<>();
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                Employee employee = new Employee();
	                employee.setId(parts[0]);
	                employee.setfirstName(parts[1]);
	                employee.setlastName(parts[2]);
	                employee.setDept(parts[3]);
	                employee.setSal(Integer.valueOf(parts[4]));
	                employees.add(employee);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }

	    public String saveEmployee(Employee employee) {
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
	            writer.write("\n" + employee.getId() + "," + employee.getfirstName() + "," +employee.getlastName()+","+ employee.getDept()+"," + employee.getSal());
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return employee.getId();
	    }

		public Employee getEmployeesById(Integer idV) {
		   String id ;
		   id = Integer.toString(idV);
		   Employee employee = new Employee();
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
	            String line;
	            while ((line = reader.readLine()) != null)  {
	            	String[] parts = line.split(","); 
	            	if( parts[0].equalsIgnoreCase(id)) {
	            		employee.setId(parts[0]);
		                employee.setfirstName(parts[1]);
		                employee.setlastName(parts[2]);
		                employee.setDept(parts[3]);
		                employee.setSal(Integer.valueOf(parts[4]));	
		                break;
	            	}	
	            }
	            reader.close();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
			return employee;
		}


		public List<Employee> getEmployeesByCon(String name,Integer fromSal, Integer toSal) {
			List<Employee> employees = new ArrayList<>();
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                Employee employee = new Employee();
	                if(name != null)
	                {
	                	if((parts[1].equalsIgnoreCase(name)) || (parts[2].equalsIgnoreCase(name))) {
	                		 employee.setId(parts[0]);
	     	                employee.setfirstName(parts[1]);
	     	                employee.setlastName(parts[2]);
	     	                employee.setDept(parts[3]);
	     	                employee.setSal(Integer.valueOf(parts[4]));
	     	                employees.add(employee);
	                	}
	                }
	                else {
	                if(fromSal != null && toSal != null) {
	                if((Integer.valueOf(parts[4])>= fromSal) && (Integer.valueOf(parts[4])<= toSal ))
	                {
	                employee.setId(parts[0]);
	                employee.setfirstName(parts[1]);
	                employee.setlastName(parts[2]);
	                employee.setDept(parts[3]);
	                employee.setSal(Integer.valueOf(parts[4]));
	                employees.add(employee);
	                }
	                }
	                else {
	                	if((toSal == null) && (Integer.valueOf(parts[4])>= fromSal)) {
	                	employee.setId(parts[0]);
		                employee.setfirstName(parts[1]);
		                employee.setlastName(parts[2]);
		                employee.setDept(parts[3]);
		                employee.setSal(Integer.valueOf(parts[4]));
		                employees.add(employee);
	                }
                       if((fromSal == null) && (Integer.valueOf(parts[4])<= toSal )) {
	                	employee.setId(parts[0]);
		                employee.setfirstName(parts[1]);
		                employee.setlastName(parts[2]);
		                employee.setDept(parts[3]);
		                employee.setSal(Integer.valueOf(parts[4]));
		                employees.add(employee);
	                }
	                }
	                }
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return employees;
		}
	}

