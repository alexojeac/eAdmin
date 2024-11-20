package model.DAO;

/**
 *
 * @author Alejandro Ojea
 */
import java.util.List;
import model.Holiday;

public interface HolidayDAO {

    public List<Holiday> findAll() throws Exception;
    public Holiday findById(String id) throws Exception;
    public List<Holiday> findAllByEmp(String emp_id) throws Exception;
    public List<Holiday> findByState() throws Exception;
    public void insert(Holiday holiday) throws Exception;
    public void update(Holiday holiday) throws Exception;
    public void delete(int id) throws Exception;
}
