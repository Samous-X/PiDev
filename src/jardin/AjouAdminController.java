/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceUtilisateur;
import entitie.Utilisateur;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class AjouAdminController implements Initializable {

    @FXML
    private AnchorPane inscriptionPane;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tftel;
    @FXML
    private Button btEnvoyer;
    @FXML
    private TextField tfPhoto;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws AWTException, IOException {
         //String cin = tfcin.getText();
           
            String TEL=tftel.getText();
            int tel=Integer.parseInt(TEL);
            //int CIN=Integer.parseInt(cin); 
            ServiceUtilisateur sp = new ServiceUtilisateur();
            Utilisateur u1=new Utilisateur();
            u1.setNom(tfnom.getText());
            u1.setEmail(tfemail.getText());
            u1.setLogin(tfPhoto.getText());
            u1.setPassword(tfpassword.getText());
            u1.setTel(tel);
          
            sp.ajouterUtilisateur(u1);
            
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajoutcomptejardin.fxml"));
            javafx.scene.Parent root = loader.load();
            label.getScene().setRoot(root);
    }
    
}
