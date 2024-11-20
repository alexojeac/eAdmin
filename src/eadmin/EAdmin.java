package eadmin;

/**
 *
 * @author Alejandro Ojea
 */
import controller.LoginController;
import java.sql.SQLException;
import views.LoginView;

public class EAdmin {

    public static void main(String[] args) throws SQLException, Exception {
        LoginView view = new LoginView();
        LoginController controller = new LoginController(view);
        view.setVisible(true);
    }
    
}
