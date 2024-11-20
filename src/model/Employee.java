package model;

import java.time.LocalDate;

/**
 *
 * @author Alejandro Ojea
 */
public class Employee {

    private String id;
    private String name;
    private String lastname1;
    private String lastname2;
    private LocalDate contractDate;
    private double salary;
    private String mail;
    private String telephone;
    private String address;
    private int dept_id;
    private String notes;

    public Employee() {
    }

    public Employee(String id, String name, String lastname1, String mail, LocalDate contractDate, int dept_id) {
        this.id = id;
        this.name = name;
        this.lastname1 = lastname1;
        this.mail = mail;
        this.dept_id = dept_id;
        this.contractDate = contractDate;
    }

    public Employee(String id, String name, String lastname1, String lastname2, String mail, LocalDate contractDate, int dept_id, double salary, String telephone, String address) {
        this.id = id;
        this.name = name;
        this.lastname1 = lastname1;
        this.lastname2 = lastname2;
        this.mail = mail;
        this.dept_id = dept_id;
        this.contractDate = contractDate;
        this.salary = salary;
        this.telephone = telephone;
        this.address = address;
    }

    public Employee(String id, String name, String lastname1, LocalDate contractDate, String mail, String telephone) {
        this.id = id;
        this.name = name;
        this.lastname1 = lastname1;
        this.contractDate = contractDate;
        this.mail = mail;
        this.telephone = telephone;
    }

    public Employee(String id, String name, String lastname1, String lastname2, LocalDate contractDate, double salary, String mail, String telephone, String address, int dept_id, String notes) {
        this.id = id;
        this.name = name;
        this.lastname1 = lastname1;
        this.lastname2 = lastname2;
        this.contractDate = contractDate;
        this.salary = salary;
        this.mail = mail;
        this.telephone = telephone;
        this.address = address;
        this.dept_id = dept_id;
        this.notes = notes;
    }

    public Employee(String id, String name, String lastname1, String lastname2, LocalDate contractDate, String mail, String telephone) {
        this.id = id;
        this.name = name;
        this.lastname1 = lastname1;
        this.lastname2 = lastname2;
        this.contractDate = contractDate;
        this.mail = mail;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
