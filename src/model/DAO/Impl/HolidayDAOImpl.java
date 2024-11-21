package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.HolidayDAO;
import model.Holiday;

/**
 *
 * @author Alejandro Ojea
 */
public class HolidayDAOImpl implements HolidayDAO {

    private Connection connection;
    private QueryProcessor query;

    public HolidayDAOImpl(Connection connection) throws SQLException, Exception {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public List<Holiday> findAll() throws Exception {
        List<Holiday> holidays = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha_inicio, fecha_fin, estado");
        sql.append(" FROM VACACIONES;");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            holidays.add(new Holiday(rs.getInt("id"), rs.getString("emp_id"), rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getDate("fecha_fin").toLocalDate(), rs.getInt("estado")));
        }
        return holidays;
    }

    @Override
    public Holiday findById(String id) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha_inicio, fecha_fin, estado");
        sql.append(" FROM VACACIONES");
        sql.append(" WHERE id =  ").append(id).append(";");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            return new Holiday(rs.getInt("id"), rs.getString("emp_id"), rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getDate("fecha_fin").toLocalDate(), rs.getInt("estado"));
        }
        return new Holiday(null, null, null, 0);
    }

    @Override
    public List<Holiday> findAllByEmp(String emp_id) throws Exception {
        List<Holiday> holidays = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha_inicio, fecha_fin, estado");
        sql.append(" FROM VACACIONES");
        sql.append(" WHERE emp_id =  ").append(emp_id).append(";");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            holidays.add(new Holiday(rs.getInt("id"), rs.getString("emp_id"), rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getDate("fecha_fin").toLocalDate(), rs.getInt("estado")));
        }
        return holidays;
    }

    @Override
    public List<Holiday> findByState() throws Exception {
        List<Holiday> holidays = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha_inicio, fecha_fin, estado");
        sql.append(" FROM VACACIONES");
        sql.append(" WHERE estado = 0;");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            holidays.add(new Holiday(rs.getInt("id"), rs.getString("emp_id"), rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getDate("fecha_fin").toLocalDate(), rs.getInt("estado")));
        }
        return holidays;
    }

    @Override
    public void insert(Holiday holiday) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO VACACIONES ");
        sql.append("(emp_id, fecha_inicio, fecha_fin, estado) ");
        sql.append("VALUES ('")
                .append(holiday.getEmp_id()).append("', '")
                .append(holiday.getInitDay()).append("', '")
                .append(holiday.getFinishDate()).append("', '")
                .append(holiday.getAccept()).append("');");

        query.executeStatement(sql.toString());
    }

    @Override
    public void update(Holiday holiday) throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE VACACIONES");
        sql.append(" SET estado = '").append(holiday.getAccept()).append("'");
        sql.append(" WHERE id = '").append(holiday.getId()).append("';");

        query.executeStatement(sql.toString());
    }

    @Override
    public void delete(int id) throws Exception {

    }

}
