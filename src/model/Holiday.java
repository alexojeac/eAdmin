package model;

import java.time.LocalDate;

/**
 *
 * @author Alejandro Ojea
 */
public class Holiday {
    
    private int id;
    private String emp_id;
    private LocalDate initDay;
    private LocalDate finishDate;
    private int accept;

    public Holiday(int id, String emp_id, LocalDate initDay, LocalDate finishDate, int accept) {
        this.id = id;
        this.emp_id = emp_id;
        this.initDay = initDay;
        this.finishDate = finishDate;
        this.accept = accept;
    }
    
    public Holiday(String emp_id, LocalDate initDay, LocalDate finishDate, int accept) {
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

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
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
