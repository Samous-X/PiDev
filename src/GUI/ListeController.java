/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Bus;
import Entities.Reservation;
import Services.ServiceBus;
import Services.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class ListeController implements Initializable {

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

ObservableList<Reservation> dataReservation ;
@FXML
private Button retour;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       nom_p.setCellValueFactory(new PropertyValueFactory<>("nom_p"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        
        ServiceReservation srv =new ServiceReservation();
         
       
       
        dataReservation =FXCollections.observableArrayList(srv.afficherres());

     
        tab.setItems(dataReservation);
        
        tab.setEditable(true);
      type.setCellFactory(TextFieldTableCell.<Reservation> forTableColumn());
        type.setOnEditCommit((TableColumn.CellEditEvent<Reservation, String> event) -> {
            TablePosition<Reservation, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Reservation o = event.getTableView().getItems().get(row);
 
            o.setType(newType);
           
            
            
            srv.modifierres(o);
        });
        date_debut.setCellFactory(TextFieldTableCell.<Reservation> forTableColumn());
        date_debut.setOnEditCommit((TableColumn.CellEditEvent<Reservation, String> event) -> {
            TablePosition<Reservation, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Reservation o = event.getTableView().getItems().get(row);
 
            o.setDate_debut(newType);
           
            
            
            srv.modifierres(o);
        });
        date_fin.setCellFactory(TextFieldTableCell.<Reservation> forTableColumn());
        date_fin.setOnEditCommit((TableColumn.CellEditEvent<Reservation, String> event) -> {
            TablePosition<Reservation, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Reservation o = event.getTableView().getItems().get(row);
 
            o.setDate_fin(newType);
           
            
            
            srv.modifierres(o);
        });
        
        
        
        ContextMenu cm = new ContextMenu();
MenuItem mi1 = new MenuItem("supprimer");
cm.getItems().add(mi1);
tab.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent t) {
        if(t.getButton() == MouseButton.SECONDARY) {
            cm.show(tab, t.getScreenX(), t.getScreenY());
           
        }
    }
});
 mi1.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        System.out.println("Supprimer");
        ServiceReservation srv=new ServiceReservation();
        String k = (nom_p.getCellData(tab.getSelectionModel().getSelectedIndex()).toString());
            srv.supprimerres(k);
    afficher();
    }
});
    }  
     public void direct(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/Acceuil.fxml"));
            Parent root= loader.load();
            
            AcceuilController r= loader.getController();
           retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public void afficher()
   {    nom_p.setCellValueFactory(new PropertyValueFactory<>("nom_p"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        
        ServiceReservation srv =new ServiceReservation();
         
       
       
        dataReservation =FXCollections.observableArrayList(srv.afficherres());

     
        tab.setItems(dataReservation);
   }
     
    
    
}
