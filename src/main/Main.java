package main;

import controller.FrontController;
import view.login.LoginView;

public class Main {

    public static void main(String[] args) {
        LoginView view = new LoginView();
        FrontController controller = new FrontController(view);

        view.setVisible(true);
    }
}
