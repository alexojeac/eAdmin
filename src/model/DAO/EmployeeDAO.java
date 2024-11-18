package model.DAO;

import java.util.List;
import model.Employee;

public interface EmployeeDAO {
    
    public Employee findById(int id);
    public Employee findByNameAndLastName(String name, String lastname);
    public List<Employee> finadAll();
    public List<Employee> findByDeptId(int dept_id);
    public void insert(Employee employee);
    public void update(Employee employee);
    public void updateNotes(int id, String notes);
    public void updateDept(int id, int dept_id);
    public void delete(int id);
    
}
