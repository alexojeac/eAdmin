package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Account;
import model.DAO.Impl.AccountDAOImpl;
import model.DAO.Impl.EmployeeDAOImpl;
import model.Employee;
import utils.Constants;

public final class QueryProcessor {

    private final Connection connection;
    private static QueryProcessor instance;

    private QueryProcessor(Connection connection) throws SQLException {
        this.connection = connection;
        if (!this.databaseExists()) {
            this.executeSqlScriptFromFile("eadmin_init.sql");
            EmployeeDAOImpl empDAO = new EmployeeDAOImpl(connection);
            AccountDAOImpl accountDAO = new AccountDAOImpl(connection);
            switchDatabase("EADMINBD");
            empDAO.insert(new Employee("admin", "admin", "admin@admin.admin", LocalDate.now(), 3));
            accountDAO.insert(new Account("admin", "abc123.", 1));
            return;
        }
        switchDatabase("EADMINBD");
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

    public void executeSqlScriptFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("--")) {
                    continue;
                }
                sql.append(line).append(" ");

                if (line.endsWith(";")) {
                    String sqlStatement = sql.toString().trim();
                    sql.setLength(0);

                    if (sqlStatement.startsWith("USE ")) {
                        String dbName = sqlStatement.replace("USE", "").replace(";", "").trim();
                        switchDatabase(dbName);
                    } else {
                        executeStatement(sqlStatement);
                    }
                }
            }
            System.out.println("Script ejecutado exitosamente.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo SQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al ejecutar el script SQL: " + e.getMessage());
        }
    }

    private void switchDatabase(String dbName) throws SQLException {
        connection.setCatalog(dbName);
    }

    public boolean databaseExists() throws SQLException {
        String query = "SELECT SCHEMA_NAME FROM information_schema.SCHEMATA WHERE SCHEMA_NAME = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "EADMINBD");
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si hay algún resultado, la base de datos existe
            }
        }
    }

    public static QueryProcessor getInstance(Connection connection) throws SQLException {
        if (instance == null) {
            instance = new QueryProcessor(connection);
        }
        return instance;
    }

}
