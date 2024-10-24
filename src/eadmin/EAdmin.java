package eadmin;

import controller.FrontController;
import java.sql.SQLException;
import views.LoginView;

public class EAdmin {

    public static void main(String[] args) throws SQLException {
        LoginView view = new LoginView();
        FrontController controller = new FrontController(view);
        view.setVisible(true);
    }
    
}
