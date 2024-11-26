package model.DAO;

/**
 *
 * @author Alejandro Ojea
 */
import java.util.List;
import model.Department;

public interface DepartmentDAO {
    
    public Department findById(int id) throws Exception;
    public Department findByName(String name) throws Exception;
    public List<Department> findAll() throws Exception;
    public int findPermissionById(int id) throws Exception;
    public int countDepartments() throws Exception;
    public void insert(Department depto) throws Exception;
    public void update(Department depto) throws Exception;
    public void delete(int id) throws Exception;
}
