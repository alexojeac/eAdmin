package model;

import org.mindrot.jbcrypt.BCrypt;

public class Account {
    private String userName;
    private String pass;
    private int user_id;

    public Account(String userName, String pass, int user_id) {
        this.userName = userName;
        this.setCryptPass(pass);
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
     public Boolean checkPass(String cryptPass) {
        return BCrypt.checkpw(cryptPass, pass);
    }

    public void setCryptPass(String pass) {
        this.pass = BCrypt.hashpw(pass, BCrypt.gensalt());
    }
}
