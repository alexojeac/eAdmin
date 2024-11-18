package model.DAO;

import java.util.List;
import model.Holiday;

public interface HolidayDAO {

    public List<Holiday> findAll();
    public Holiday findById(String id);
    public List<Holiday> findAllByEmp(int emp_id);
    public List<Holiday> findByState();
    public void insert(Holiday holiday);
    public void update(Holiday holiday);
    public void delete(int id);
}
