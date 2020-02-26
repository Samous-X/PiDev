/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class MenuaccueilController implements Initializable {
    @FXML
    private TextField resnomjardin;
    @FXML
    private ImageView back;
    @FXML
    private Button btnmodifp;
    @FXML
    private Button btnGererAct;
    @FXML
    private Button btnGererStore;
    @FXML
    private Button btnGererEnfant;
    @FXML
    private Button btnGererEven;
    @FXML
    private Button btnGererTrans;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView design;
    @FXML
    private ImageView retour;

    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    public void setResomjardin(TextField resnomjardin) {
        this.resnomjardin.setText(resnomjardin.getText());
    }

    public TextField getResnomjardin() {
        return resnomjardin;
    }
     
    
     @FXML
    public void modifprofil(ActionEvent event) {
         try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("Profiljardin.fxml"));
            Parent root = loader.load();
            ProfiljardinController cjc=loader.getController();
            btnmodifp.getScene().setRoot(root);
             cjc.setaffNomjardin(resnomjardin);
             
        } catch (IOException ex) {
            Logger.getLogger(MenuaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    @FXML
    public void GererStaff(ActionEvent event) {
         try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("GérerStaff.fxml"));
            Parent root = loader.load();
            GérerStaffController cjc=loader.getController();
            btnGererAct.getScene().setRoot(root);
             
             
        } catch (IOException ex) {
            Logger.getLogger(MenuaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    public void Retour(MouseEvent event) {
         try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("Firstaccueil.fxml"));
            Parent root = loader.load();
            FirstaccueilController cjc=loader.getController();
            retour.getScene().setRoot(root);
          
        } catch (IOException ex) {
            Logger.getLogger(MenuaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}
