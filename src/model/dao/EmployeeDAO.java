package model.dao;

import java.util.HashMap;
import model.Employee;

public interface EmployeeDAO {

    public HashMap<Integer, Employee> getAll();

    public Employee getById(int id);
}
