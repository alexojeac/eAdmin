package model.DAO.Impl;

import db.QueryProcessor;
import java.util.List;
import model.DAO.EmployeeDAO;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Connection connection;
    private QueryProcessor query;

    public EmployeeDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Employee findById(int id) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, salario, correo, direccion, tlf, departamento_id, notas");
        sql.append(" FROM EMPLEADOS");
        sql.append(" WHERE emp_id = '").append(id).append("';");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return (new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(), rs.getDouble("salario"), rs.getString("correo"),
                        rs.getString("direccion"), rs.getString("tlf"), rs.getInt("departamento_id"), rs.getString("notas")));
            }

        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Employee();
    }
    
    @Override
    public Employee findByNameAndLastName(String name, String lastname) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, salario, correo, direccion, tlf, departamento_id, notas");
        sql.append(" FROM EMPLEADOS");
        sql.append(" WHERE nombre = '").append(name);
        sql.append("' AND apellido1 = '").append(lastname).append("';");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return (new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(), rs.getDouble("salario"), rs.getString("correo"),
                        rs.getString("direccion"), rs.getString("tlf"), rs.getInt("departamento_id"), rs.getString("notas")));
            }

        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Employee();
    }

    @Override
    public List<Employee> finadAll() {
        List<Employee> employees = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, direccion, tlf");
        sql.append(" FROM EMPLEADOS;");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                employees.add(new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(),
                        rs.getString("direccion"), rs.getString("tlf")));
            }

            return employees;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @Override
    public List<Employee> findByDeptId(int dept_id) {
        List<Employee> employees = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" emp_id, nombre, apellido1, apellido2, fecha_contrato, direccion, tlf");
        sql.append(" FROM EMPLEADOS");
        sql.append(" WHERE departamento_id = ").append(dept_id).append(";");;

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                employees.add(new Employee(rs.getInt("emp_id"), rs.getString("nombre"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getDate("fecha_contrato").toLocalDate(),
                        rs.getString("direccion"), rs.getString("tlf")));
            }

            return employees;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @Override
    public void insert(Employee employee) {
        StringBuilder sql = new StringBuilder("INSERT INTO EMPLEADOS ");
        sql.append("(nombre, apellido1, apellido2, fecha_contrato, departamento_id, salario, correo, tlf, direccion) ");
        sql.append("VALUES ('")
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

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override

    public void update(Employee employee) {
        final StringBuilder sql = new StringBuilder("UPDATE EMPLEADOS");
        sql.append(" SET departamento_id = ").append(employee.getDept_id());
        sql.append(" , salario = ").append(employee.getSalary());
        sql.append(" , correo = '").append(employee.getMail());
        sql.append("' WHERE emp_id = ").append(employee.getId()).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateNotes(int id, String notes) {
        final StringBuilder sql = new StringBuilder("UPDATE EMPLEADOS");
        sql.append(" SET notas = '").append(notes);
        sql.append("' WHERE emp_id = ").append(id).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDept(int id, int dept_id) {
        final StringBuilder sql = new StringBuilder("UPDATE EMPLEADOS");
        sql.append(" SET departamento_id = '").append(dept_id);
        sql.append("' WHERE emp_id = ").append(id).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        final StringBuilder sql = new StringBuilder("DELETE FROM EMPLEADOS WHERE emp_id = ");
        sql.append(id).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
