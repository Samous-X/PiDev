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
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class AcceuilAdminController implements Initializable {

    @FXML
    private ImageView back;
    @FXML
    private ImageView logo;
    @FXML
    private Button gererjardin;
    @FXML
    private Button Gérerstaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Gérerjardin(ActionEvent event) {
        
        try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("ListeJardinadmin.fxml"));
            Parent root = loader.load();
            ListeJardinadminController cjc=loader.getController();
            gererjardin.getScene().setRoot(root);
           
             
        } catch (IOException ex) {
            Logger.getLogger(MenuaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GérerStaff(ActionEvent event) {
        
        
         try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("StaffAdmin.fxml"));
            Parent root = loader.load();
            StaffAdminController cjc=loader.getController();
            Gérerstaff.getScene().setRoot(root);
           
             
        } catch (IOException ex) {
            Logger.getLogger(MenuaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
