package model.dao;

import java.util.HashMap;
import model.Account;

public interface AccountDAO {
    
    public HashMap<Integer, Account> getAll();
    
    public Account getById(int id);
    
}
