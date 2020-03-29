/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceNotification;
import Service.ServiceParent;
import entitie.Paarent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class ProfilParentController implements Initializable {

    @FXML
    private Label loggedparent;
    @FXML
    private Button btnAjEnf;
    @FXML
    private Button btnAffEnf;
    @FXML
    private Button btnProfil;
    @FXML
    private Button btnEv;
    @FXML
    private Button btnPanier;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tftel;
    @FXML
    private TextField tfcin;
    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfpassword;
    @FXML
    private AnchorPane ProfilParent;

    /**
     * Initializes the controller class.
     */
    private  static ServiceParent myServices=new ServiceParent();
    @FXML
    private Button modif;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
           
       Paarent ParentConneter=myServices.chercherParentByid(loggedParent.getId_utilisateur());
        
  
        
        tfnom.setText(ParentConneter.getNom());
        tfprenom.setText(ParentConneter.getPrenom());
        tfemail.setText(ParentConneter.getEmail());
        tfcin.setText(String.valueOf(ParentConneter.getCin()));
        tftel.setText(String.valueOf(ParentConneter.getTel()));
        tflogin.setText(ParentConneter.getLogin());
        tfpassword.setText(ParentConneter.getPassword());
        
    }    

    @FXML
    private void ajouterEnfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEnfant.fxml"));
        Parent root = loader.load();
        AjouterEnfantController e = loader.getController();
        ProfilParent.getChildren().setAll(root);
    }

    @FXML
    private void AfficherEnfant(ActionEvent event) {
    }

    @FXML
    private void AfficherProfil(ActionEvent event) {
    }

    @FXML
    private void ConsulterEvent(ActionEvent event) {
    }

    @FXML
    private void Panier(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
        Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
        Paarent ParentConneter=myServices.chercherParentByid(loggedParent.getId_utilisateur());
        ServiceParent services = new ServiceParent();
        String login=tflogin.getText();
        String password=tfpassword.getText();
        
        int id=loggedParent.getId_utilisateur();
        int TeL=Integer.parseInt(tftel.getText());
        int CIN=Integer.parseInt(tfcin.getText());
        Paarent parent=new Paarent(id,tfnom.getText(),tfprenom.getText(),CIN,tfemail.getText(),TeL);
        services.modifierCoordonnésparent(parent, login,password);
        ServiceNotification.showNotif("Felicitaion ", "Vous Avez modifier votre login et mot de passe avec sucées");
        
    }
    
}
