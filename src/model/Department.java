package model;

public class Department {

    private int id;
    private String name;
    private int right;

    public Department() {
    }

    public Department(int id, String name, int right) {
        this.id = id;
        this.name = name;
        this.right = right;
    }

    public Department(String name, int right) {
        this.name = name;
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

}
