package model.DAO.Impl;

import db.QueryProcessor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.TimeRecordDAO;
import model.TimeRecord;

public class TimeRecordDAOImpl implements TimeRecordDAO {

    private Connection connection;
    private QueryProcessor query;

    public TimeRecordDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.query = new QueryProcessor(connection);
    }

    @Override
    public List<TimeRecord> findByEmpId(int id) {
        List<TimeRecord> trs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha, entrada, salida");
        sql.append(" FROM FICHADAS");
        sql.append(" WHERE emp_id = ").append(id).append(";");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                trs.add(new TimeRecord(rs.getInt("id"), rs.getInt("emp_id"), rs.getDate("fecha").toLocalDate(),
                        rs.getTime("entrada").toLocalTime(),
                        rs.getTime("salida") != null ? rs.getTime("salida").toLocalTime() : null));
            }
            for (TimeRecord tr : trs) {
                System.out.println(tr.getId()+ tr.getEmp_id()+ tr.getDate().toString()+ tr.getIn().toString()+tr.getOut().toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trs;
    }

    @Override
    public List<TimeRecord> findByEmpIdAndDateFromUntil(int id, LocalDate from, LocalDate until) {
        List<TimeRecord> trs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha, entrada, salida");
        sql.append(" FROM FICHADAS");
        sql.append(" WHERE emp_id = ").append(id);
        sql.append(" AND fecha >= '").append(from).append("'"); // Asegúrate de que el formato sea correcto
        sql.append(" AND fecha <= '").append(until).append("';");

        try {
            ResultSet rs = query.executeQuery(sql.toString());

            while (rs.next()) {
                trs.add(new TimeRecord(rs.getInt("id"), rs.getInt("emp_id"), rs.getDate("fecha").toLocalDate(),
                        rs.getTime("entrada").toLocalTime(),
                        rs.getTime("salida") != null ? rs.getTime("salida").toLocalTime() : null));
            }

        } catch (Exception ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trs;
    }

    @Override
    public void insert(TimeRecord tr) {
        StringBuilder sql = new StringBuilder("INSERT INTO FICHADAS ");
        sql.append("(emp_id, fecha, entrada) ");
        sql.append("VALUES ('")
                .append(tr.getEmp_id()).append("', '")
                .append(tr.getDate()).append("', '")
                .append(tr.getIn().format(DateTimeFormatter.ofPattern("HH:mm:ss"))).append("');");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(TimeRecordDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        final StringBuilder sql = new StringBuilder("UPDATE FICHADAS");
        sql.append(" SET salida = '").append(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))).append("'");
        sql.append(" WHERE fecha = '").append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).append("';");

        try {
            query.executeStatement(sql.toString());
        } catch (Exception ex) {
            Logger.getLogger(TimeRecordDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        final StringBuilder sql = new StringBuilder("DELETE FROM FICHADAS WHERE id = ");
        sql.append(id).append(";");

        try {
            query.executeStatement(sql.toString());
        } catch (SQLException ex) {
            Logger.getLogger(TimeRecordDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
