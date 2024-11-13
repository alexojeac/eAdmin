package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.HolidayDAO;
import model.Holiday;

public class HolidayDAOImpl implements HolidayDAO {

    private Connection connection;
    private QueryProcessor query;

    public HolidayDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public List<Holiday> findAll() {
        List<Holiday> holidays = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha_inicio, fecha_fin, aceptada");
        sql.append(" FROM VACACIONES;");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                holidays.add(new Holiday(rs.getInt("id"), rs.getInt("emp_id"), rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(), rs.getInt("aceptada")));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return holidays;
    }
    
    @Override
    public List<Holiday> findAllByEmp(int emp_id) {
        List<Holiday> holidays = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha_inicio, fecha_fin, aceptada");
        sql.append(" FROM VACACIONES");
        sql.append(" WHERE emp_id =  ").append(emp_id).append("");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                holidays.add(new Holiday(rs.getInt("id"), rs.getInt("emp_id"), rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(), rs.getInt("aceptada")));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return holidays;
    }

    @Override
    public void insert(Holiday holiday) {
        StringBuilder sql = new StringBuilder("INSERT INTO VACACIONES ");
        sql.append("(emp_id, fecha_inicio, fecha_fin, aceptada) ");
        sql.append("VALUES ('")
                .append(holiday.getEmp_id()).append("', '")
                .append(holiday.getInitDay()).append("', '")
                .append(holiday.getFinishDate()).append("', '")
                .append(holiday.getAccept()).append("');");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(HolidayDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Holiday holiday) {
        final StringBuilder sql = new StringBuilder("UPDATE VACACIONES");
        sql.append(" SET aceptada = '").append(holiday.getAccept()).append("'");
        sql.append(" WHERE id = '").append(holiday.getId()).append("';");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(HolidayDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
