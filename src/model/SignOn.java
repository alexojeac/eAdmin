package model;

import java.time.LocalTime;

public class SignOn {

    private int id;
    private String date;
    private LocalTime  in;
    private LocalTime  out;
    private int empId;

    public SignOn() {
    }

    public SignOn(String date, LocalTime in, LocalTime out) {
        this.date = date;
        this.in = in;
        this.out = out;
    }
    
    public SignOn(String date, LocalTime in) {
        this.date = date;
        this.in = in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    

}
