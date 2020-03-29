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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class AcceuilController implements Initializable {

    @FXML
    private AnchorPane acceuil;
    @FXML
    private Button directeur;
    @FXML
    private Button chercher;
    @FXML
    private Label laabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void espaceDirecteur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAdmin.fxml"));
        Parent root = loader.load();
        //LoginAdminController e = loader.getController();
        laabel.getScene().setRoot(root);
    }

    @FXML
    private void chercher(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("inscription.fxml"));
        Parent root = loader.load();
        InscriptionController e = loader.getController();
        acceuil.getChildren().setAll(root);
    }
    
}
