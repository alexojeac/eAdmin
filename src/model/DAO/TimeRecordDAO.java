package model.DAO;

import java.time.LocalDate;
import java.util.List;
import model.TimeRecord;

public interface TimeRecordDAO {
    
    public List<TimeRecord> findByEmpId(int id);
    public List<TimeRecord> findByEmpIdAndDateFromUntil(int id, LocalDate from, LocalDate until);
    public void insert(TimeRecord tr);
    public void update();
    public void delete(int id);
}
