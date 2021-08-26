import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Employee_Hb {

	private int id;
	private String name;
	private int salary;
	
	public Employee_Hb() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee_Hb(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee_Hb [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


	public Employee_Hb(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	
	
}
