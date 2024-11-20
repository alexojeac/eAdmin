package model.DAO;

/**
 *
 * @author Alejandro Ojea
 */
import java.time.LocalDate;
import java.util.List;
import model.TimeRecord;

public interface TimeRecordDAO {
    
    public List<TimeRecord> findByEmpId(String id) throws Exception;
    public List<TimeRecord> findByEmpIdAndDateFromUntil(String id, LocalDate from, LocalDate until) throws Exception;
    public void insert(TimeRecord tr) throws Exception;
    public void update() throws Exception;
    public void delete(int id) throws Exception;
}
