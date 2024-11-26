package model.DAO.Impl;

import model.DAO.EnterpriseDAO;
import model.Enterprise;
import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alejandro Ojea
 */
public class EnterpriseDAOImpl implements EnterpriseDAO {

    private Connection connection;
    private QueryProcessor query;

    public EnterpriseDAOImpl(Connection connection) throws SQLException, Exception {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public Enterprise findById(String id) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, nombre, direccion, correo");
        sql.append(" FROM EMPRESAS");
        sql.append(" WHERE id = '").append(id).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Enterprise(rs.getString("id"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("correo")));
        }
        return new Enterprise();
    }

    @Override
    public Enterprise findAll() throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, nombre, direccion, correo");
        sql.append(" FROM EMPRESAS;");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return (new Enterprise(rs.getString("id"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("correo")));
        }
        return new Enterprise();
    }

    @Override
    public Boolean enterpriseExists(String id) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id");
        sql.append(" FROM EMPRESAS");
        sql.append(" WHERE id = '").append(id).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return true;
        }
        return false;
    }

    @Override
    public void insert(Enterprise enterprise) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO EMPRESAS ");
        sql.append("(id, nombre, direccion, correo) ");
        sql.append("VALUES ('")
                .append(enterprise.getId()).append("', '")
                .append(enterprise.getName()).append("', '")
                .append(enterprise.getAddress()).append("', '")
                .append(enterprise.getMail()).append("');");

        query.executeStatement(sql.toString());
    }

    @Override
    public void update(Enterprise enterprise) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE EMPRESAS SET ");

        sql.append("nombre = '").append(enterprise.getName()).append("', ");
        sql.append("direccion = '").append(enterprise.getAddress()).append("', ");
        sql.append("correo = '").append(enterprise.getMail()).append("' ");
        sql.append("WHERE id = '").append(enterprise.getId()).append("';");

        query.executeStatement(sql.toString());
    }

    @Override
    public void delete(String id) throws Exception {
        final StringBuilder sql = new StringBuilder("DELETE FROM EMPRESAS WHERE id = ");
        sql.append(id).append(";");

        query.executeStatement(sql.toString());
    }

}
