/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.event;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class Jardin1Controller implements Initializable {
static int i;
   
    @FXML
    private Label nomj;
    @FXML
    private Label adressej;
    @FXML
    private Label prixj;

            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         
        nomj.setText(AfficherjardinController.obs.get(i).getNom());
         
         adressej.setText(AfficherjardinController.obs.get(i).getAdresse());
         
        // prixj.setText(Integer.toString(AfficherjardinController.obs.get(i).getPrix_mois()));
                i++;
        // TODO
    }    

    
    
}
