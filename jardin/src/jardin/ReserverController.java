 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Bus;
import entitie.Reservation;
import Service.ControlleSaisie;
import Service.ServiceBus;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import Service.ServiceReservation;
import Service.Service_generer_Qr_code;
import Service.Service_mail;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ComboBox enfant;
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
   
nom.setEditable(true);
nom.getEditor().textProperty().addListener(new ChangeListener<String>() {

    @Override
    public void changed(ObservableValue<? extends String> observable, 
                                    String oldValue, String newValue) {
        int idp;
        //System.out.println(nom.getValue().toString());
      //  System.out.println(srv.getidparent(nom.getValue().toString()));
         idp= srv.getidparent(nom.getValue().toString());
      System.out.println(idp);
      ObservableList obList3 = FXCollections.observableList(srv.getenfant(idp)); 
      enfant.getItems().clear();
      enfant.setItems(obList3);
    }
});
      imm.setEditable(false);
       date_debut.setEditable(false);
       fin.setEditable(false);
        
    }    
    
    public void insertVol (ActionEvent event)
    {  
       if  ( !(ControlleSaisie.estVideCombo(nom, "Nom ")) 
            && !(ControlleSaisie.estVideCombo(enfant, "Nom D'enfant "))
            && !(ControlleSaisie.estVideCombo(type, "Type D'abonnement "))
            && !(ControlleSaisie.date(date_debut, "Date de Debut "))
            && !(ControlleSaisie.date(fin, "Date de Fin "))
            && !(ControlleSaisie.estVide(imm, "L'immatriculation "))
            && !(date_debut.getValue().isAfter(fin.getValue()))
            
           // && !(ControlleSaisie.date2(date_debut,fin))
            )
           { 
              
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
        String enfan=""+enfant.getValue();
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
        v.setEnfant(enfan);
        v.setEtat(1);
        
        
        //v.setimmatriculation(ev.getImmat());
        
        ServiceReservation srv = new ServiceReservation();
        
     
        srv.ajouterres(v,ev);
        } 
        
       
        } 
        
    }
     public void directAccueil(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AffichageBus.fxml"));
            Parent root= loader.load();
            
            AffichageBusController r= loader.getController();
           retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
