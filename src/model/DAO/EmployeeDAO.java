package model.DAO;

/**
 *
 * @author Alejandro Ojea
 */
import java.util.List;
import model.Employee;

public interface EmployeeDAO {
    
    public Employee findById(String id) throws Exception;
    public List<Employee> finadAll() throws Exception;
    public List<Employee> findByDeptId(int dept_id) throws Exception;
    public int countEmployees() throws Exception;
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void updateNotes(String id, String notes) throws Exception;
    public void updateDept(String id, int dept_id) throws Exception;
    public void delete(String id) throws Exception;
    
}
