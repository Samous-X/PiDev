/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class EspaceparentController implements Initializable {

    @FXML
    private AnchorPane nomjardin;
    @FXML
    private ImageView back;
    @FXML
    private Button btnGererEnfant;
    @FXML
    private Button btnGererJardin;
    @FXML
    private Button btnGererStore;
    @FXML
    private Button btnGererTrans;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView design;
    @FXML
    private Button retour;
    @FXML
    private Button btnGererforum;
    @FXML
    private Button btnGererevent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuParent.fxml"));
        Parent root = loader.load();
        //LoginAdminController e = loader.getController();
        btnGererEnfant.getScene().setRoot(root);
    }

    @FXML
    private void jardin(ActionEvent event) throws IOException {
   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeJardin.fxml"));
        Parent root = loader.load();
        //LoginAdminController e = loader.getController();
        btnGererJardin.getScene().setRoot(root);
    }

    @FXML
    private void store(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        //LoginAdminController e = loader.getController();
        btnGererStore.getScene().setRoot(root);
    }

    @FXML
    private void directiEspaceBus(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageBus.fxml"));
        Parent root = loader.load();
        //LoginAdminController e = loader.getController();
        btnGererTrans.getScene().setRoot(root);
    }


    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void forum(ActionEvent event) {
    }

    @FXML
    private void evenements(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher1.fxml"));
        Parent root = loader.load();
        //LoginAdminController e = loader.getController();
        btnGererevent.getScene().setRoot(root);
    }
    
}
