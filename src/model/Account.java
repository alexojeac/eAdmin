package model;

import org.mindrot.jbcrypt.BCrypt;

public final class Account {
     private int id;
    private String userName;
    private String passHash;
    private int user_id;

    public Account(String pass) {
        this.setCryptPass(pass);
    }

    public Account(String userName, String passHash) {
        this.userName = userName;
        this.passHash = passHash;
    }

    public Account(String userName, String pass, int user_id) {
        this.userName = userName;
        this.setCryptPass(pass);
        this.user_id = user_id;
    }

    public Account(int id, String userName, String pass, int user_id) {
        this.id = id;
        this.userName = userName;
        this.setCryptPass(pass);
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return passHash;
    }

    public void setPass(String passHash) {
        this.passHash = passHash;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Boolean checkPass(String password, String bdpass) {
        return BCrypt.checkpw(password, bdpass);
    }

    public void setCryptPass(String pass) {
        this.passHash = BCrypt.hashpw(pass, BCrypt.gensalt());
    }
}
