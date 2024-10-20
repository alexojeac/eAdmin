package eadmin;


import controller.FrontController;
import views.LoginView;

public class EAdmin {

    public static void main(String[] args) {
        LoginView login = new LoginView();
        FrontController fc = new FrontController(login);
        login.setVisible(true);
    }
    
}
