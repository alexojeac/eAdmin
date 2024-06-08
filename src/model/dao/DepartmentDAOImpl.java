package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import utils.QueryProcessor;

public class DepartmentDAOImpl implements DepartmentDAO{
    private final String getAll = "SELECT * FROM departamentos",
            getById = "SELECT * FROM departamentos WHERE dept_id = ";
    
    private HashMap<Integer, Department> departments;
    private Connection connection;
    private final QueryProcessor query;

    public DepartmentDAOImpl(Connection connection) {
        this.connection = connection;
        this.departments = new HashMap<>();
        this.query = new QueryProcessor(connection);
    }

    @Override
    public HashMap<Integer, Department> getAll() {
         try {
            ResultSet rs = query.executeQuery(getAll);
            
            while(rs.next()) {
                Department dept = new Department(rs.getInt("dept_id"), rs.getString("nombre"));
                departments.put(dept.getId(), dept);
            }
            
            return departments;
         } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return departments;
        }
    }

    @Override
    public Department getById() {
        try {
            ResultSet rs = query.executeQuery(getById);
            
            if(rs.next()) {
                return new Department(rs.getInt("dept_id"), rs.getString("nombre"));
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
}
