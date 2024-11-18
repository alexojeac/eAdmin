package model.DAO;

import model.Account;

public interface AccountDAO {
    
    public Account findByName(String name);
    public Account findByEmpId(int id);
    public void insert(Account account);
    public void update(Account account);
    public void delete(int id);
}
