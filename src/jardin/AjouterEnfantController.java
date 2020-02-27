/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;
import Service.ServiceJardin;
import Service.ServiceBus;
import Service.ServiceEnfant;
import Service.ServiceParent;
import entitie.Enfant;
import entitie.Paarent;
import static jardin.MenuParentController.idparent;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class AjouterEnfantController implements Initializable {

    @FXML
    private TextField tfPhoto;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNom;
    @FXML
    private Button btnajouter;
    @FXML
    private TextField tfv;
    @FXML
    private TextField tha;
    @FXML
    private AnchorPane Ajoutenfant;
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
    private ComboBox listejardin;
    private static ServiceParent myServices = new ServiceParent();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEnfant srv=new ServiceEnfant();
    ObservableList obList2 = FXCollections.observableList(srv.displaysm());
        listejardin.getItems().clear();
        listejardin.setItems(obList2);
      
    }   
    

    @FXML
    private void ajouterEnfant(ActionEvent event) throws IOException {
        
        
        
    }

    @FXML
    private void ajout(ActionEvent event) throws IOException {
        int x;
          ServiceJardin sra = new ServiceJardin();
        x = sra.getidjardin(listejardin.getValue().toString());
        System.out.println(x);
        String nomP = tfNom.getText();
        String prenomP = tfPrenom.getText();
        String age = tfAge.getText();
        String photoP = tfPhoto.getText();
        String vaccin=tfv.getText();
        String alergie=tha.getText();
         int Age=Integer.parseInt(age);
         Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
        Paarent ParentConnecte = myServices.chercherParentByid(loggedParent.getId_parent());
        idparent = loggedParent.getId_parent();
        
        
        ServiceEnfant sp = new ServiceEnfant();
        Enfant en = new Enfant(nomP,prenomP,Age,photoP,idparent,vaccin,alergie,x);
        
        sp.ajouterEnfant(en);
        
       
        
    }

    @FXML
    private void AfficherEnfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEnfant.fxml"));
        Parent root = loader.load();
        AfficherEnfantController e = loader.getController();
        Ajoutenfant.getChildren().setAll(root);
    }

    @FXML
    private void AfficherProfil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilParent.fxml"));
        Parent root = loader.load();
        ProfilParentController e = loader.getController();
        Ajoutenfant.getChildren().setAll(root);
    }

    @FXML
    private void ConsulterEvent(ActionEvent event) {
    }

    @FXML
    private void Panier(ActionEvent event) {
    }

    
    

    
}

    

    
