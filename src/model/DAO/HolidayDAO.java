package model.DAO;

import java.util.List;
import model.Holiday;

public interface HolidayDAO {

    public List<Holiday> findAll(int emp_id);
    public void insert(Holiday holiday);
    public void update();
    public void delete(int id);
}
