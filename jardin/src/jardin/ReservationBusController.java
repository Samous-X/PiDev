/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Reservation;
import Service.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class ReservationBusController implements Initializable {

  @FXML 
private TableView tab;

@FXML
private TableColumn <Reservation,String> nom_p;
@FXML
private TableColumn <Reservation,String> type;

@FXML
private TableColumn <Reservation,String> date_debut;
@FXML
private TableColumn <Reservation,String> date_fin;
@FXML
private TableColumn <Reservation,String> enfant;
@FXML
private Button retour;


ObservableList<Reservation> dataReservation ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom_p.setCellValueFactory(new PropertyValueFactory<>("nom_p"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
         enfant.setCellValueFactory(new PropertyValueFactory<>("enfant"));
        
        ServiceReservation srv =new ServiceReservation();
         String eya=AjoutBusController.recupBus.getImmat();
       
       
        dataReservation =FXCollections.observableArrayList(srv.afficherBus(eya));
        

     
        tab.setItems(dataReservation);
    }   
     public void direct(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AjoutBus.fxml"));
            Parent root= loader.load();
            
            AjoutBusController r= loader.getController();
           retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
