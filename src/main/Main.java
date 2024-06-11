package main;

import controller.FrontController;
import java.sql.SQLException;
import view.login.LoginView;

public class Main {

    public static void main(String[] args) throws SQLException {
        LoginView view = new LoginView();
        FrontController controller = new FrontController(view);

        view.setVisible(true);
    }
}
