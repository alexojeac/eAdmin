package model.dao;

import java.util.HashMap;
import model.Employee;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.QueryProcessor;
import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String getAll = "SELECT * FROM empleados",
            getById = "SELECT * FROM empleados WHERE emp_id = ";

    private final HashMap<Integer, Employee> employees;
    private Connection connection;
    private final QueryProcessor query;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
        this.employees = new HashMap<>();
        this.query = new QueryProcessor(connection);
    }

    @Override
    public HashMap<Integer, Employee> getAll() {
        try {
            ResultSet rs = query.executeQuery(getAll);
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("emp_id"));
                emp.setName(rs.getString("nombre"));
                emp.setLastname1(rs.getString("apellido1"));
                emp.setLastname2(rs.getString("apellido2"));
                emp.setBornDate(String.valueOf(rs.getString("fecha_nac")));
                emp.setContractDate(String.valueOf(rs.getString("fecha_contrato")));
                emp.setSalary(rs.getDouble("salario"));
                emp.setMail(rs.getString("correo"));
                emp.setTelephone(rs.getString("tlf"));
                emp.setAddress(rs.getString("direccion"));
                emp.setCity(rs.getString("ciudad"));
                emp.setCp(rs.getString("codigo_postal"));
                emp.setCountry(rs.getString("pais"));
                emp.setDept_id(rs.getInt("departamento_id"));
                employees.put(emp.getId(), emp);
            }

            return employees;

        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return employees;
        }
    }

    @Override
    public Employee getById(int id) {
        try {
            ResultSet rs = query.executeQuery(getById);

            if (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("emp_id"));
                emp.setName(rs.getString("nombre"));
                emp.setLastname1(rs.getString("apellido1"));
                emp.setLastname2(rs.getString("apellido2"));
                emp.setBornDate(String.valueOf(rs.getString("fecha_nac")));
                emp.setContractDate(String.valueOf(rs.getString("fecha_contrato")));
                emp.setSalary(rs.getDouble("salario"));
                emp.setMail(rs.getString("correo"));
                emp.setTelephone(rs.getString("tlf"));
                emp.setAddress(rs.getString("direccion"));
                emp.setCity(rs.getString("ciudad"));
                emp.setCp(rs.getString("codigo_postal"));
                emp.setCountry(rs.getString("pais"));
                emp.setDept_id(rs.getInt("departamento_id"));
                
                return emp;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
}
