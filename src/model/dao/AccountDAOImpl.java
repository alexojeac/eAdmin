package model.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import utils.QueryProcessor;

public class AccountDAOImpl implements AccountDAO {

    private final String getAll = "SELECT * FROM cuentas",
            getById = "SELECT * FROM cuentas WHERE id = ";

    private final HashMap<Integer, Account> accounts;
    private Connection connection;
    private final QueryProcessor query;

    public AccountDAOImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.accounts = new HashMap<>();
        this.query = new QueryProcessor(connection);
    }

    @Override
    public final HashMap<Integer, Account> getAll() {
        try {
            ResultSet rs = query.executeQuery(getAll);

            while (rs.next()) {
                Account account = new Account(rs.getInt("id"), rs.getString("nombre_usuario"), rs.getString("clave"), rs.getInt("emp_id"));
                accounts.put(account.getId(), account);
            }

            return accounts;
        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return accounts;
        }
    }

    @Override
    public Account getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
