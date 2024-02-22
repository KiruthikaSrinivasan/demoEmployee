package employeeEntity;

public class Employee {
	private String id;
	private String firstName;
	private String lastName;
	private String dept;
	private Integer sal;
	public void setId(String id) {
		this.id = id;	
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public String getId() {
		
		return id;
	}
	public String getfirstName() {
		
		return firstName;
	}
	public String getlastName() {
		
		return lastName;
	}
	public String getDept() {
		
		return dept;
	}
public Integer getSal() {
		
		return sal;
	}
}
