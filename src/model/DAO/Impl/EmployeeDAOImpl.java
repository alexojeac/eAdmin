package model.DAO.Impl;

import db.QueryProcessor;
import java.util.List;
import model.DAO.EmployeeDAO;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Ojea
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private Connection connection;
    private QueryProcessor query;

    public EmployeeDAOImpl(Connection connection) throws SQLException, Exception {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Employee findById(String id) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, salario, correo, direccion, tlf, departamento_id, notas");
        sql.append(" FROM EMPLEADOS");
        sql.append(" WHERE emp_id = '").append(id).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Employee(rs.getString("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                    rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(), rs.getDouble("salario"), rs.getString("correo"),
                    rs.getString("tlf"), rs.getString("direccion"), rs.getInt("departamento_id"), rs.getString("notas")));
        }
        return new Employee();
    }

    @Override
    public List<Employee> finadAll() throws Exception {
        List<Employee> employees = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, salario, correo, direccion, tlf, departamento_id, notas");
        sql.append(" FROM EMPLEADOS;");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            employees.add(new Employee(rs.getString("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                    rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(), rs.getDouble("salario"), rs.getString("correo"),
                    rs.getString("tlf"), rs.getString("direccion"), rs.getInt("departamento_id"), rs.getString("notas")));
        }

        return employees;
    }

    @Override
    public List<Employee> findByDeptId(int dept_id) throws Exception {
        List<Employee> employees = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, salario, correo, direccion, tlf, departamento_id, notas");
        sql.append(" FROM EMPLEADOS");
        sql.append(" WHERE departamento_id = ").append(dept_id).append(";");;

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            employees.add(new Employee(rs.getString("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                    rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(), rs.getDouble("salario"), rs.getString("correo"),
                    rs.getString("tlf"), rs.getString("direccion"), rs.getInt("departamento_id"), rs.getString("notas")));
        }

        return employees;
    }

    @Override
    public int countEmployees() throws Exception {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM EMPLEADOS;";

        ResultSet rs = query.executeQuery(sql);
        if (rs.next()) {
            count = rs.getInt("total");
        }

        return count;
    }

    @Override
    public void insert(Employee employee) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO EMPLEADOS ");
        sql.append("(emp_id, nombre, apellido1, apellido2, fecha_contrato, departamento_id, salario, correo, tlf, direccion) ");
        sql.append("VALUES ('")
                .append(employee.getId()).append("', '")
                .append(employee.getName()).append("', '")
                .append(employee.getLastname1()).append("', '")
                .append(employee.getLastname2() != null ? employee.getLastname2() : "NULL").append("', '")
                .append(employee.getContractDate()).append("', ")
                .append(employee.getDept_id()).append(", ");

        Double salary = employee.getSalary();
        if (salary != null) {
            sql.append(salary);
        } else {
            sql.append("NULL");
        }

        sql.append(", '")
                .append(employee.getMail()).append("', '")
                .append(employee.getTelephone() != null ? employee.getTelephone() : "NULL").append("', '")
                .append(employee.getAddress() != null ? employee.getAddress() : "NULL").append("');");

        query.executeStatement(sql.toString());
    }

    @Override
    public void update(Employee employee) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE EMPLEADOS");
        sql.append(" SET departamento_id = ").append(employee.getDept_id());
        sql.append(" , salario = ").append(employee.getSalary());
        sql.append(" , correo = '").append(employee.getMail());
        sql.append("' , direccion = '").append(employee.getAddress());
        sql.append("' , tlf = '").append(employee.getTelephone());
        sql.append("' WHERE emp_id = '").append(employee.getId()).append("';");

        query.executeStatement(sql.toString());
    }

    @Override
    public void updateNotes(String id, String notes) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE EMPLEADOS");
        sql.append(" SET notas = '").append(notes);
        sql.append("' WHERE emp_id = '").append(id).append("';");

        query.executeStatement(sql.toString());
    }

    @Override
    public void updateDept(String id, int dept_id) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE EMPLEADOS");
        sql.append(" SET departamento_id = '").append(dept_id);
        sql.append("' WHERE emp_id = '").append(id).append("';");

        query.executeStatement(sql.toString());
    }

    @Override
    public void delete(String id) throws Exception {
        final StringBuilder sql = new StringBuilder("DELETE FROM EMPLEADOS WHERE emp_id = '");
        sql.append(id).append("';");

        query.executeStatement(sql.toString());
    }

}
