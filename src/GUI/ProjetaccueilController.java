/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import GUI.AcceuilController;
import GUI.AjoutBusController;
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

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class ProjetaccueilController implements Initializable {
    
   
    
   
   
    
    
    @FXML
    private Button btnGererTrans;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView design;

    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
     public void directiEspaceBus(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/Acceuil.fxml"));
            Parent root= loader.load();
            
            AcceuilController r= loader.getController();
           btnGererTrans.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
     
    
     
    
    
}
