/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class AjoutadminjardinController implements Initializable {

    @FXML
    private ImageView back;
    @FXML
    private ImageView logo;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfprix;
    @FXML
    private Button ajout;
    @FXML
    private TextField tfIdl;
    @FXML
    private ImageView retour;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void retour(MouseEvent event) {
    }

   
    
}
