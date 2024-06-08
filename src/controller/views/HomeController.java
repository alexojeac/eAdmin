package controller.views;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import view.panelViews.HomeView;
import java.awt.event.ActionListener;

public class HomeController {
    
    private final HomeView view;
    private final Connection connection;
    
    public HomeController(HomeView view, Connection connection) {
        this.view = view;
        this.connection = connection;
        this.view.addOnTimeButtonListenner(this.getOnTimeButtonActionListener());
    }
    
    private void setUserName() {
        //TODO
    }
    
    private void setLastName1() {
        //TODO
    }
    
    private void setLastName2() {
        //TODO
    }
    
    private ActionListener getOnTimeButtonActionListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        };
        return listener;
    }
    
}
