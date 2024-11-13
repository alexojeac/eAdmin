package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.DepartmentDAO;
import model.Department;

public class DepartmentDAOImpl implements DepartmentDAO {

    private Connection connection;
    private QueryProcessor query;

    public DepartmentDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Department findById(int id) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" dept_id, nombre, permisos");
        sql.append(" FROM DEPARTAMENTOS");
        sql.append(" WHERE dept_id = ").append(id).append(";");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return (new Department(rs.getInt("dept_id"), rs.getString("nombre"), rs.getInt("permisos")));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Department();
    }

    @Override
    public Department findByName(String name) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" dept_id, nombre, permisos");
        sql.append(" FROM DEPARTAMENTOS");
        sql.append(" WHERE nombre = '").append(name).append("';");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return (new Department(rs.getInt("dept_id"), rs.getString("nombre"), rs.getInt("permisos")));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Department();
    }

    @Override
    public List<Department> findAll() {
        List<Department> deptos = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" dept_id, nombre, permisos");
        sql.append(" FROM DEPARTAMENTOS;");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                deptos.add(new Department(rs.getInt("dept_id"), rs.getString("nombre"), rs.getInt("permisos")));
            }

            return deptos;
        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deptos;
    }

    @Override
    public int findPermissionById(int id) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" permisos");
        sql.append(" FROM DEPARTAMENTOS");
        sql.append(" WHERE dept_id = ").append(id).append(";");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return rs.getInt("permisos");
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void insert(Department depto) {
        StringBuilder sql = new StringBuilder("INSERT INTO DEPARTAMENTOS ");
        sql.append("(nombre, permisos) ");
        sql.append("VALUES ('")
                .append(depto.getName()).append("', ")
                .append(depto.getRight()).append(");");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Department depto) {
        final StringBuilder sql = new StringBuilder("UPDATE DEPARTAMENTOS SET ");

        sql.append("nombre = '").append(depto.getName()).append("', ");
        sql.append("permisos = ").append(depto.getRight()).append(" ");
        sql.append("WHERE dept_id = ").append(depto.getId()).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        final StringBuilder sql = new StringBuilder("DELETE FROM DEPARTAMENTOS WHERE dept_id = ");
        sql.append(id).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
