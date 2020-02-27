/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Jardin;
import Service.ServiceJardin;
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
public class ModifierjardinController implements Initializable {
    @FXML 
    private Label x;
    @FXML
    private TextField nomjardinmodif;
    @FXML
    private TextField adressejardinmodif;
    @FXML
    private TextField prixmodif;
    @FXML
    private ImageView back;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView retour;
    @FXML
    private ImageView a1;
    @FXML
    private ImageView a2;
    @FXML
    private ImageView a3;
    @FXML
    private Button btnmod;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        // TODO
    }    
  
    public void setNomjardinmodif(TextField nomjardinmodif) {
        this.nomjardinmodif.setText(nomjardinmodif.getText());
    }

    public void setAdressejardinmodif(TextField adressejardinmodif) {
        this.adressejardinmodif.setText(adressejardinmodif.getText());
    }

    public void setPrixmodif(TextField prixmodif) {
        this.prixmodif.setText(prixmodif.getText());
    }
    @FXML
     private void gohome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menuaccueil.fxml"));
            Parent root = loader.load();
            //MenuaccueilController dc = loader.getController();
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierjardinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
         String n1 =nomjardinmodif.getText();
         String nom=nomjardinmodif.getText();
         String adr=adressejardinmodif.getText();
         String PRICE=prixmodif.getText();
          int prix=Integer.parseInt(PRICE);
         
         ServiceJardin sp = new ServiceJardin();
         Jardin j1 = new Jardin(nom,adr,prix); 
         
           sp.Update2(j1,nom,adr,prix);
        nomjardinmodif.setText(j1.getNom());

    }
     
}
