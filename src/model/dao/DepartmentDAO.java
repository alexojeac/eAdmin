package model.dao;

import java.util.HashMap;
import model.Department;

public interface DepartmentDAO {

    public HashMap<Integer, Department> getAll();

    public Department getById();
}
