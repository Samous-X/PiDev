/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Image;
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
public class FirstaccueilController implements Initializable {


 @FXML
 private ImageView imgAcceuil;
 @FXML
 private ImageView logo;
 @FXML
 private Button btnrecherche;
 @FXML
 private Button Espacedirecteur;
 @FXML
 private Button Admin;
 @FXML 
  private Label  bienvenu;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       
    }  
    @FXML
    public void ajoutcomptejardin(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Ajoutcomptejardin.fxml"));
            Parent root = loader.load();
            AjoutcomptejardinController cjc=loader.getController();
            Espacedirecteur.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FirstaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void Recherchejardin(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ListeJardin.fxml"));
            Parent root = loader.load();
            ListeJardinController cjl=loader.getController();
            btnrecherche.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FirstaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void Adminacc(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AcceuilAdmin.fxml"));
            Parent root = loader.load();
            AcceuilAdminController cjc=loader.getController();
            Admin.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FirstaccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
