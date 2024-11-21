package eadmin;
import utils.Constants;

/**
 *
 * @author Alejandro Ojea
 */
import controller.LoginController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.LoginView;

public class EAdmin {

    public static void main(String[] args) throws SQLException, Exception {
        try {
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view);
            view.setVisible(true);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, Constants.ACCES_ERROR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

}
