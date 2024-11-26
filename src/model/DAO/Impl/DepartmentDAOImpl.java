package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.DepartmentDAO;
import model.Department;

/**
 *
 * @author Alejandro Ojea
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    private Connection connection;
    private QueryProcessor query;

    public DepartmentDAOImpl(Connection connection) throws SQLException, Exception {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Department findById(int id) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" dept_id, nombre, permisos");
        sql.append(" FROM DEPARTAMENTOS");
        sql.append(" WHERE dept_id = ").append(id).append(";");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Department(rs.getInt("dept_id"), rs.getString("nombre"), rs.getInt("permisos")));
        }
        return new Department();
    }

    @Override
    public Department findByName(String name) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" dept_id, nombre, permisos");
        sql.append(" FROM DEPARTAMENTOS");
        sql.append(" WHERE nombre = '").append(name).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Department(rs.getInt("dept_id"), rs.getString("nombre"), rs.getInt("permisos")));
        }
        return new Department();
    }

    @Override
    public List<Department> findAll() throws Exception {
        List<Department> deptos = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" dept_id, nombre, permisos");
        sql.append(" FROM DEPARTAMENTOS;");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            deptos.add(new Department(rs.getInt("dept_id"), rs.getString("nombre"), rs.getInt("permisos")));
        }

        return deptos;
    }

    @Override
    public int findPermissionById(int id) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" permisos");
        sql.append(" FROM DEPARTAMENTOS");
        sql.append(" WHERE dept_id = ").append(id).append(";");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return rs.getInt("permisos");
        }
        return 0;
    }

    @Override
    public int countDepartments() throws Exception {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM DEPARTAMENTOS;";

        try (ResultSet rs = query.executeQuery(sql)) {
            if (rs.next()) {
                count = rs.getInt("total");
            }
        }
        return count;
    }

    @Override
    public void insert(Department depto) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO DEPARTAMENTOS ");
        sql.append("(nombre, permisos) ");
        sql.append("VALUES ('")
                .append(depto.getName()).append("', ")
                .append(depto.getRight()).append(");");

        query.executeStatement(sql.toString());
    }

    @Override
    public void update(Department depto) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE DEPARTAMENTOS SET ");

        sql.append("nombre = '").append(depto.getName()).append("', ");
        sql.append("permisos = ").append(depto.getRight()).append(" ");
        sql.append("WHERE dept_id = ").append(depto.getId()).append(";");

        query.executeStatement(sql.toString());
    }

    @Override
    public void delete(int id) throws Exception {
        final StringBuilder sql = new StringBuilder("DELETE FROM DEPARTAMENTOS WHERE dept_id = ");
        sql.append(id).append(";");

        query.executeStatement(sql.toString());
    }

}
