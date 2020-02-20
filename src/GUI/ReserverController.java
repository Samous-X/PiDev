 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Bus;
import Entities.Reservation;
import Services.ServiceBus;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import Services.ServiceReservation;
import Services.Service_generer_Qr_code;
import Services.Service_mail;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class ReserverController implements Initializable {
@FXML
    private ComboBox nom;
@FXML
    private TextField imm;
@FXML
    private ComboBox type;
@FXML
    private DatePicker date_debut;
@FXML
    private DatePicker fin;
@FXML
    private Button ajouter;
@FXML
    private Button retour;
        
        
      
    
       ServiceReservation srv=new ServiceReservation();
        ObservableList obList2 = FXCollections.observableList(srv.displaysm()); 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
         nom.getItems().clear();
       nom.setItems(obList2);
        type.getItems().addAll("Aller Simple","Retour Simple","Aller et Retour ");
       
      Bus ev =BusController.b;
    imm.setText(ev.getImmat());
       
       
        
    }    
    
    public void insertVol (ActionEvent event)
    {   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confimartion Reservation");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous Reserver une Place Dans cette Bus ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK){
                                Service_generer_Qr_code Q= new Service_generer_Qr_code();
                                Q.create(nom.getValue().toString(),imm.getText());
                                    Service_mail M = new Service_mail();
                                 M.send_mail("chadiznina20@gmail.com",nom.getValue().toString());
Bus ev =BusController.b;
        String nomm=""+nom.getValue();
        String typee=""+type.getValue();
        String datee=date_debut.getValue().toString();
         String datef=fin.getValue().toString();
         String imma=imm.getText();
         
        Reservation v= new Reservation();
        v.setimmatriculation(ev.getImmat());
        v.setNom_p(nomm);
        v.setType(typee);
        v.setDate_debut(datee);
        v.setDate_fin(datef);
        
        
        //v.setimmatriculation(ev.getImmat());
        
        ServiceReservation srv = new ServiceReservation();
        
     
        srv.ajouterres(v,ev);
        } 
        
       
        
        
    }
     public void directAccueil(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/AffichageBus.fxml"));
            Parent root= loader.load();
            
            AffichageBusController r= loader.getController();
           retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
