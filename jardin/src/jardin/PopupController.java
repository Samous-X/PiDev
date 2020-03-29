/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceParent;
import static jardin.Event1Controller.i;

import entitie.event;
import entitie.participant;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Service.TrayIconDemo;
import Service.participantService;
import entitie.Paarent;
import static jardin.MenuParentController.idparent;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class PopupController implements Initializable {

    @FXML
    private TextField enfant;
    @FXML
    private Label titre;
    @FXML
    private Button participer;
    @FXML
    private Label yarab2;
static event rec;
private static ServiceParent myServices = new ServiceParent();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void participer(ActionEvent event) throws ClassNotFoundException, AWTException {
       Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
        Paarent ParentConnecte = myServices.chercherParentByid(loggedParent.getId_utilisateur());
        idparent = loggedParent.getId_utilisateur();
        
        yarab2.setText(Integer.toString(rec.getId_event()));
        System.out.println(rec.getId_event());
            int enf = Integer.parseInt(enfant.getText());
            participantService P = new participantService();
            
            participant a = new participant(3,idparent,enf);
            P.ajoutparticipant(a);
        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
          
          
          
    }

    
}
