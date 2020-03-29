/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceParent;

import entitie.Paarent;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static sun.security.krb5.Confounder.bytes;
import test.menuPa;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class MenuParentController implements Initializable {

    @FXML
    private AnchorPane MenuPArent;
    @FXML
    private Button btnAjEnf;
    @FXML
    private Button btnAffEnf;
    @FXML
    private Button btnProfil;
    private static ServiceParent myServices = new ServiceParent();
    public static String parentname;
    public static int idparent;
    @FXML
    private Label loggedparent;
    @FXML
    private Button btnEv;
    @FXML
    private Button btnPanier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
        Paarent ParentConnecte = myServices.chercherParentByid(loggedParent.getId_utilisateur());
        idparent = loggedParent.getId_utilisateur();
        
        
        
       menuPa.Id_user_connecte=loggedParent.getId_utilisateur();
       

        parentname=ParentConnecte.getNom();
        //imgParent.setImage(new Image(loggedParent.getPhoto()));
        System.out.println("deeerfr");
        /*String IMG = ParentConnecte.getPhoto();
        Image image = new Image(IMG.toURI().toString());
        imgParent.setImage(image) ;*/
        //imgParent.setImage(new Image(loggedParent.getPhoto()));

        loggedparent.setText("" + String.valueOf(ParentConnecte.getNom()));
    }    

    @FXML
    private void ajouterEnfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEnfant.fxml"));
        Parent root = loader.load();
        //AjouterEnfantController e = loader.getController();
        MenuPArent.getChildren().setAll(root);
    }

    @FXML
    private void AfficherEnfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEnfant.fxml"));
        Parent root = loader.load();
        AfficherEnfantController e = loader.getController();
        MenuPArent.getChildren().setAll(root);
    }

    @FXML
    private void AfficherProfil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilParent.fxml"));
        Parent root = loader.load();
        ProfilParentController e = loader.getController();
        MenuPArent.getChildren().setAll(root);
        
    }

    @FXML
    private void ConsulterEvent(ActionEvent event) {
    }

    @FXML
    private void Panier(ActionEvent event) {
    }
    
}
