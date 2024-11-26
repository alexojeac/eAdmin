package model.DAO;

import model.Enterprise;

/**
 *
 * @author Alejandro Ojea
 */
public interface EnterpriseDAO {

    public Enterprise findById(String id) throws Exception;
    
    public Enterprise findAll() throws Exception;
    
    public Boolean enterpriseExists(String id) throws Exception;

    public void insert(Enterprise enterprise) throws Exception;

    public void update(Enterprise enterprise) throws Exception;

    public void delete(String id) throws Exception;
}
