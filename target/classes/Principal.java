import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
	private EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("EmployeeService");
	
	private EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		
		
	}
	
	public Employee createEmployee(int id, String name, long salary) {
		Employee employee = new Employee(id);
		employee.setName(name);
		employee.setSalary(salary);
		em.persist(employee);
		return employee;
	}
	
	public Employee find(int id) {
		return em.find(Employee.class, id);
	}
	
	public void remove(int id) {
		Employee employee = em.find(Employee.class, id);
		em.remove(employee);
	}
	
	public Employee updateWithMerge(Employee employee) {
		return em.merge(employee);
	}
	
	public Employee updateWithOutMerge(int id) {
		Employee employee = em.find(Employee.class, id);
		employee.setName("Carlos");
		return employee;
	}
	
	
	
}
