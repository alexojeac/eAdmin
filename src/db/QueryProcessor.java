package db;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.ANSI;
import utils.Constants;

public final class QueryProcessor {
    
    private final Connection connection;

    public QueryProcessor(Connection connection) throws SQLException {
        this.connection = connection;
        executeStatement("USE eadminbd");
    }

    public void executeStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public ResultSet executeQuery(String sql) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        return rs;
    }

    public boolean chekAdmin(String user, String pass) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT clave FROM CUENTAS WHERE nombre_usuario = '" + user + "'");
            rs.next();
            String viewPass = rs.getString("clave");

            return viewPass.equals(pass);
        } catch (SQLException ex) {
            Logger.getLogger(QueryProcessor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, Constants.LOGIN_ERROR, "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String getEmployee(String user) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT nombre FROM EMPLEADOS WHERE emp_id = (SELECT emp_id FROM CUENTAS WHERE nombre_usuario = '" + user + "')");
            rs.next();
            return rs.getString("nombre");

        } catch (SQLException ex) {
            Logger.getLogger(QueryProcessor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void queryFromFile(String pathStr) throws Exception {
        Path path = Paths.get(pathStr);
        String sql = Files.readString(path);
        executeQuery(sql);
    }

    private void print(ResultSet rs, String sql) throws Exception {
        System.out.printf("%s%s   %n%s%s%-25s%n", ANSI.YELLOW_BACKGROUND, ANSI.BLACK, ANSI.RESET, ANSI.PURPLE, sql, ANSI.RESET);
        ArrayList<String> columns = getColumnNames(rs);
        System.out.println(getHeaderRow(columns));

        while (rs.next()) {
            String row = "";
            for (int i = 1; i <= columns.size(); i++) {
                row += String.format("%-25s  ", rs.getObject(i));
            }
            System.out.println(row);
        }

        System.out.println("\n");
    }

    private ArrayList<String> getColumnNames(ResultSet resultSet) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        ResultSetMetaData metadata = resultSet.getMetaData();
        int columns = metadata.getColumnCount();

        for (int i = 1; i <= columns; i++) {
            String name = metadata.getColumnLabel(i);
            names.add(name);
        }

        return names;
    }

    private String getHeaderRow(ArrayList<String> columnNames) {
        String str = ANSI.YELLOW_BACKGROUND + ANSI.BLACK;
        for (String colName : columnNames) {
            str += String.format("%-14s  ", colName);
        }
        return str + ANSI.RESET;
    }
}
