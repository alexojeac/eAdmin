package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeRecord {

    private int id;
    private int emp_id;
    private LocalDate date;
    private LocalTime in;
    private LocalTime out;

    public TimeRecord(int emp_id, LocalDate date, LocalTime in, LocalTime out) {
        this.emp_id = emp_id;
        this.date = date;
        this.in = in;
        this.out = out;
    }

    public TimeRecord(int id, int emp_id, LocalDate date, LocalTime in, LocalTime out) {
        this.id = id;
        this.emp_id = emp_id;
        this.date = date;
        this.in = in;
        this.out = out;
    }

    public TimeRecord(int emp_id, LocalDate date, LocalTime in) {
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

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
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
