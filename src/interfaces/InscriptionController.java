/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class InscriptionController implements Initializable {
@FXML 
private ImageView img;
@FXML 
private ImageView logo;
@FXML
private TextField t1;
@FXML
private Label L1; 
@FXML 
private ImageView t2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   
         
     @FXML
    private void Retour(MouseEvent event) throws SQLException {   
         FXMLLoader loader=new FXMLLoader(getClass().getResource("Firstaccueil.fxml"));
        
         try {
           Parent  root = loader.load();
            FirstaccueilController cjc=loader.getController();
            
            t2.getScene().setRoot(root);
               
         } catch (IOException ex) {
             Logger.getLogger(ListeJardinController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
