package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.DAO.AccountDAO;

/**
 *
 * @author Alejandro Ojea
 */
public class AccountDAOImpl implements AccountDAO {

    private Connection connection;
    private QueryProcessor query;

    public AccountDAOImpl(Connection connection) throws SQLException, Exception {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Account findByName(String name) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, nombre_usuario, clave, emp_id, nuevo");
        sql.append(" FROM CUENTAS");
        sql.append(" WHERE nombre_usuario = '").append(name).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Account(rs.getInt("id"), rs.getString("nombre_usuario"), rs.getString("clave"),
                    rs.getString("emp_id"), rs.getInt("nuevo")));
        }

        return new Account();
    }

    @Override
    public Account findByEmpId(String empId) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, nombre_usuario, clave, emp_id, nuevo");
        sql.append(" FROM CUENTAS");
        sql.append(" WHERE emp_id = '").append(empId).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Account(rs.getInt("id"), rs.getString("nombre_usuario"), rs.getString("clave"),
                    rs.getString("emp_id"), rs.getInt("nuevo")));
        }
        return new Account();
    }

    @Override
    public void insert(Account account) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO CUENTAS ");
        sql.append("(nombre_usuario, clave, emp_id, nuevo) ");
        sql.append("VALUES ('")
                .append(account.getUserName()).append("', '")
                .append(account.getPass()).append("', '")
                .append(account.getUser_id()).append("', ")
                .append("0);");

        query.executeStatement(sql.toString());
    }

    @Override
    public void update(Account account) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE CUENTAS");
        sql.append(" SET clave = '").append(account.getPass());
        sql.append("' , nuevo = 1");
        sql.append(" WHERE id = ").append(account.getId()).append(";");

        query.executeStatement(sql.toString());
    }

    @Override
    public void delete(int id) throws Exception {
        final StringBuilder sql = new StringBuilder("DELETE FROM CUENTAS WHERE id = ");
        sql.append(id).append(";");

        query.executeStatement(sql.toString());
    }

}
