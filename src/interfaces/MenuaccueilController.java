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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class MenuaccueilController implements Initializable {

    @FXML
    private AnchorPane nomjardin;
    @FXML
    private ImageView back;
    @FXML
    private Button btnmodifp;
    @FXML
    private Button btnGererEnfant;
    @FXML
    private Button btnGererAct;
    @FXML
    private Button btnGererEven;
    @FXML
    private Button btnGererStore;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView design;
    @FXML
    private TextField resnomjardin;
    @FXML
    private Button transport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifprofil(ActionEvent event) {
    }

    @FXML
    private void GererStaff(ActionEvent event) {
    }

    @FXML
    private void directiAcceuil(ActionEvent event) {
    }
    
}
