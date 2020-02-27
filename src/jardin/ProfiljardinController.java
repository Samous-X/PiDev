/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Jardin;
import Service.ServiceJardin;
import java.awt.AWTException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class ProfiljardinController implements Initializable {

    @FXML
    private Button btnmodif;
    @FXML
    private Label Profil;
    @FXML
    private ImageView Iback;
    @FXML 
    private ImageView logo;
    @FXML
    private TextField affNomjardin;
    @FXML
    private TextField adressejardin;
    @FXML 
    private TextField Prixjardin;
    @FXML
    private ImageView w;
    @FXML
    private ImageView x;
    @FXML
    private ImageView y;
    @FXML
    private ImageView z;
 
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     //    String n ="jardin salem";
         
         
         ServiceJardin sp = new ServiceJardin();
         Jardin j1 = new Jardin(); 
         
        j1=sp.rechercherJardinParnom2(affNomjardin.getText());
        affNomjardin.setText(j1.getNom());
        adressejardin.setText(j1.getAdresse());
        
       Prixjardin.setText(j1.getIdStr());
      
        
       
        
    } 
    public void setaffNomjardin(TextField affNomjardin) {
         this.affNomjardin.setText(affNomjardin.getText());
    }
    
     @FXML
    private void Modifier(ActionEvent event) {
        
        
       /* String nom=affNomjardin.getText();
        String adr=adressejardin.getText();
        String PRICE=Prixjardin.getText();
        int prix=Integer.parseInt(PRICE);
        ServiceJardin sp = new ServiceJardin();
        Jardin j1 = new Jardin(affNomjardin.getText(),adressejardin.getText(),Prixjardin.getText());
        sp.Update2(j1);
        */
        
        /*
        
        Parent root = loader.load();
        ModifierjardinController cjc=loader.getController();
        btnmodif.getScene().setRoot(root);
        cjc.setNomjardinmodif(affNomjardin);
        cjc.setAdressejardinmodif(adressejardin);
        cjc.setPrixmodif(Prixjardin);
        */
    }

    public TextField getAffNomjardin() {
        return affNomjardin;
    }
 @FXML
     private void gohome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menudirecteur.fxml"));
            Parent root = loader.load();
            
            z.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ProfiljardinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

    

   
}
