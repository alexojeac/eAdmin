package model.DAO;

import model.Account;

/**
 *
 * @author Alejandro Ojea
 */
public interface AccountDAO {
    
    public Account findByName(String name) throws Exception;
    public Account findByEmpId(String id) throws Exception;
    public void insert(Account account) throws Exception;
    public void update(Account account) throws Exception;
    public void delete(int id)throws Exception;
}
