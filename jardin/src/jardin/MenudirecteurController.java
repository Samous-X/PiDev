/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class MenudirecteurController implements Initializable {

    @FXML
    private AnchorPane nomjardin;
    @FXML
    private ImageView back;
    @FXML
    private Button btnGererEnfant;
    @FXML
    private Button btnGererStore;
    @FXML
    private Button btnGererTrans;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView design;
    @FXML
    private Button btnGererEven;
    @FXML
    private Button btnGererstaff;
    @FXML
    private Button btnGererforum;
    @FXML
    private Button btnGerercmd;
    @FXML
    private Button retour;
    @FXML
    private Button btnGererJardin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enfant(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("GérerEnfants.fxml"));
            Parent root= loader.load();
           btnGererEnfant.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }


    @FXML
    private void store(ActionEvent event) {
    }

    @FXML
    private void directiEspaceBus(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AjoutBus.fxml"));
            Parent root= loader.load();
            
            AjoutBusController r= loader.getController();
           btnGererEven.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void evenement(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("evenement.fxml"));
            Parent root= loader.load();
           btnGererTrans.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void staff(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("GérerStaff.fxml"));
            Parent root= loader.load();
           btnGererstaff.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void forum(ActionEvent event) {
        
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("afficher.fxml"));
            Parent root= loader.load();
           btnGererforum.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @FXML
    private void commande(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("dashboard_1.fxml"));
            Parent root= loader.load();
           btnGerercmd.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void jardin(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Profiljardin.fxml"));
            Parent root= loader.load();
           btnGererJardin.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
