package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Alejandro Ojea
 */
public class TimeRecord {

    private int id;
    private String emp_id;
    private LocalDate date;
    private LocalTime in;
    private LocalTime out;

    public TimeRecord(String emp_id, LocalDate date, LocalTime in, LocalTime out) {
        this.emp_id = emp_id;
        this.date = date;
        this.in = in;
        this.out = out;
    }

    public TimeRecord(int id, String emp_id, LocalDate date, LocalTime in, LocalTime out) {
        this.id = id;
        this.emp_id = emp_id;
        this.date = date;
        this.in = in;
        this.out = out;
    }

    public TimeRecord(String emp_id, LocalDate date, LocalTime in) {
        this.emp_id = emp_id;
        this.date = date;
        this.in = in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getIn() {
        return in;
    }

    public void setIn(LocalTime in) {
        this.in = in;
    }

    public LocalTime getOut() {
        return out;
    }

    public void setOut(LocalTime out) {
        this.out = out;
    }

}
