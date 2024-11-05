package model;

import java.time.LocalDate;

public class Holiday {
    
    private int id;
    private int emp_id;
    private LocalDate initDay;
    private LocalDate finishDate;
    private int accept;

    public Holiday(int id, int emp_id, LocalDate initDay, LocalDate finishDate, int accept) {
        this.id = id;
        this.emp_id = emp_id;
        this.initDay = initDay;
        this.finishDate = finishDate;
        this.accept = accept;
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

    public LocalDate getInitDay() {
        return initDay;
    }

    public void setInitDay(LocalDate initDay) {
        this.initDay = initDay;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }
    
}
