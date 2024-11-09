package model.DAO;

import java.util.List;
import model.Department;

public interface DepartmentDAO {
    
    public Department findById(int id);
    public Department findByName(String name);
    public List<Department> findAll();
    public int findPermissionById(int id);
    public void insert(Department depto);
    public void update(Department depto);
    public void delete(int id);
}
