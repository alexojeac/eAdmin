package db;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.Constants;

public final class QueryProcessor {
    
    private final Connection connection;

    public QueryProcessor(Connection connection) throws SQLException {
        this.connection = connection;
        executeStatement("USE EADMINBD");
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

    public void queryFromFile(String pathStr) throws Exception {
        Path path = Paths.get(pathStr);
        String sql = Files.readString(path);
        executeQuery(sql);
    }
    
}
