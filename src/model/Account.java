package model;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Alejandro Ojea
 */
public final class Account {
     private int id;
    private String userName;
    private String passHash;
    private String user_id;
    private int newAccount;

    public Account() {
    }

    public Account(String pass) {
        this.setCryptPass(pass);
    }

    public Account(String userName, String pass) {
        this.userName = userName;
        this.setCryptPass(pass);
    }

    public Account(String userName, String pass, String user_id) {
        this.userName = userName;
        this.setCryptPass(pass);
        this.user_id = user_id;
    }

    public Account(int id, String userName, String pass, String user_id, int newAccount) {
        this.id = id;
        this.userName = userName;
        this.passHash = pass;
        this.user_id = user_id;
        this.newAccount = newAccount;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getNewAccount() {
        return newAccount;
    }

    public void setnewAccount(int isNew) {
        this.newAccount = isNew;
    }

    public Boolean checkPass(String password, String bdpass) {
        return BCrypt.checkpw(password, bdpass);
    }

    public void setCryptPass(String pass) {
        this.passHash = BCrypt.hashpw(pass, BCrypt.gensalt());
    }
}
