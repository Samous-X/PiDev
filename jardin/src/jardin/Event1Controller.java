/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.event;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
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
public class Event1Controller implements Initializable {
static int i;

    @FXML
    private Label titre;
    private Label discription;
    @FXML
    private Label date;
    @FXML
    private Button participer;
    @FXML
    private Text text;
    @FXML
    private Label idt;
    @FXML
    private Label temp1;
    @FXML
    private Label prix;
    @FXML
    private Label temp3;

            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int a ;
         SimpleDateFormat format = new SimpleDateFormat("dd MMM");
         DateFormat timeFormat = new SimpleDateFormat( "HH:mm" );
         DateFormat timeFormat2 = new SimpleDateFormat( "HH:mm" );
         titre.setText(Afficher1Controller.obs.get(i).getNom_event());
         
         text.setText(Afficher1Controller.obs.get(i).getDesc());    
         date.setText(format.format(Afficher1Controller.obs.get(i).getDate_event()));
         
         
         //temp3.setText(timeFormat2.format(AfficherController.obs.get(i).getHeureF()));
         //temp1.setText(timeFormat.format(Afficher1Controller.obs.get(i).getHeureD()));
         prix.setText(Float.toString(Afficher1Controller.obs.get(i).getPrix_event()));
          
       PopupController.rec = Afficher1Controller.obs.get(i);
       
                i++;
        // TODO
        
    }    

    @FXML
    private void participer(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("popup.fxml"));
       Scene scene = new Scene(root);
      //FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
       Stage stage = new Stage();
       stage.setTitle("Popup");
       stage.setScene(scene);
       stage.show();
       //rec.setId_event(Integer.parseInt(idt.getText()));
       //System.out.println(rec.getId_event());
       
           
       
         
        
       
    }
    
}
