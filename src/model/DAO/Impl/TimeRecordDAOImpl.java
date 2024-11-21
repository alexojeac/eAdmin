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
import model.DAO.TimeRecordDAO;
import model.TimeRecord;

/**
 *
 * @author Alejandro Ojea
 */
public class TimeRecordDAOImpl implements TimeRecordDAO {

    private Connection connection;
    private QueryProcessor query;

    public TimeRecordDAOImpl(Connection connection) throws SQLException, Exception {
        this.connection = connection;
        this.query = QueryProcessor.getInstance(connection);
    }

    @Override
    public List<TimeRecord> findByEmpId(String id) throws Exception {
        List<TimeRecord> trs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha, entrada, salida");
        sql.append(" FROM FICHADAS");
        sql.append(" WHERE emp_id = '").append(id).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            trs.add(new TimeRecord(rs.getInt("id"), rs.getString("emp_id"), rs.getDate("fecha").toLocalDate(),
                    rs.getTime("entrada").toLocalTime(),
                    rs.getTime("salida") != null ? rs.getTime("salida").toLocalTime() : null));
        }
        return trs;
    }

    @Override
    public List<TimeRecord> findByEmpIdAndDateFromUntil(String id, LocalDate from, LocalDate until) throws Exception {
        List<TimeRecord> trs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha, entrada, salida");
        sql.append(" FROM FICHADAS");
        sql.append(" WHERE emp_id = '").append(id);
        sql.append("' AND fecha >= '").append(from).append("'"); // Asegúrate de que el formato sea correcto
        sql.append(" AND fecha <= '").append(until).append("';");

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            trs.add(new TimeRecord(rs.getInt("id"), rs.getString("emp_id"), rs.getDate("fecha").toLocalDate(),
                    rs.getTime("entrada").toLocalTime(),
                    rs.getTime("salida") != null ? rs.getTime("salida").toLocalTime() : null));
        }
        return trs;
    }

    @Override
    public List<TimeRecord> findByEmpIdAndDate(String empId, LocalDate date) throws Exception {
        List<TimeRecord> trs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT");
        sql.append(" id, emp_id, fecha, entrada, salida");
        sql.append(" FROM FICHADAS");
        sql.append(" WHERE emp_id = '").append(empId).append("'");
        sql.append(" AND fecha = '").append(date).append("';"); // Asegúrate de usar el formato correcto para la fecha

        ResultSet rs = query.executeQuery(sql.toString());

        while (rs.next()) {
            trs.add(new TimeRecord(
                    rs.getInt("id"),
                    rs.getString("emp_id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getTime("entrada") != null ? rs.getTime("entrada").toLocalTime() : null,
                    rs.getTime("salida") != null ? rs.getTime("salida").toLocalTime() : null
            ));
        }
        return trs;
    }

    @Override
    public void insert(TimeRecord tr) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO FICHADAS ");
        sql.append("(emp_id, fecha, entrada) ");
        sql.append("VALUES ('")
                .append(tr.getEmp_id()).append("', '")
                .append(tr.getDate()).append("', '")
                .append(tr.getIn().format(DateTimeFormatter.ofPattern("HH:mm:ss"))).append("');");
        query.executeStatement(sql.toString());
    }

    @Override
    public void update() throws Exception {
        final StringBuilder sql = new StringBuilder("UPDATE FICHADAS");
        sql.append(" SET salida = '").append(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))).append("'");
        sql.append(" WHERE fecha = '").append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).append("';");

        query.executeStatement(sql.toString());
    }

    @Override
    public void delete(int id) throws Exception {
        final StringBuilder sql = new StringBuilder("DELETE FROM FICHADAS WHERE id = ");
        sql.append(id).append(";");
        query.executeStatement(sql.toString());
    }

}
