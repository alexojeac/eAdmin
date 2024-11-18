package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.DAO.AccountDAO;

public class AccountDAOImpl implements AccountDAO {

    private Connection connection;
    private QueryProcessor query;

    public AccountDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Account findByName(String name) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, nombre_usuario, clave, emp_id, nuevo");
        sql.append(" FROM CUENTAS");
        sql.append(" WHERE nombre_usuario = '").append(name).append("';");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return (new Account(rs.getInt("id"), rs.getString("nombre_usuario"), rs.getString("clave"),
                        rs.getInt("emp_id"), rs.getInt("nuevo")));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Account();
    }
    
    @Override
    public Account findByEmpId(int empId) {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, nombre_usuario, clave, emp_id, nuevo");
        sql.append(" FROM CUENTAS");
        sql.append(" WHERE emp_id = '").append(empId).append("';");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                return (new Account(rs.getInt("id"), rs.getString("nombre_usuario"), rs.getString("clave"),
                        rs.getInt("emp_id"), rs.getInt("nuevo")));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Account();
    }

    @Override
    public void insert(Account account) {
        StringBuilder sql = new StringBuilder("INSERT INTO CUENTAS ");
        sql.append("(nombre_usuario, clave, emp_id, nuevo) ");
        sql.append("VALUES ('")
                .append(account.getUserName()).append("', '")
                .append(account.getPass()).append("', ")
                .append(account.getUser_id()).append(", ")
                .append("0);");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Account account) {
        final StringBuilder sql = new StringBuilder("UPDATE CUENTAS");
        sql.append(" SET clave = '").append(account.getPass());
        sql.append("' , nuevo = 1");
        sql.append(" WHERE id = ").append(account.getId()).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        final StringBuilder sql = new StringBuilder("DELETE FROM CUENTAS WHERE id = ");
        sql.append(id).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
