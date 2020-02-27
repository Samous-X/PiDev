/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import entitie.Bus;
import Service.ServiceBus;
import Utils.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.sun.prism.impl.Disposer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author chadi
 */
public class AjoutBusController implements Initializable {
   @FXML
    TableView<Bus> tab = new TableView<Bus>();
   @FXML
      TableColumn<Bus,String> id_bus //
         = new TableColumn<Bus, String>("id_bus");
   @FXML
      TableColumn<Bus,String> Immat //
         = new TableColumn<Bus, String>("Immat");
   @FXML
      TableColumn<Bus,String> Ligne  //
         = new TableColumn<Bus, String>("Ligne ");
   @FXML
      TableColumn<Bus,String> Horaire  //
         = new TableColumn<Bus, String>("Horaire ");
    @FXML
      TableColumn<Bus,String> Chauffeur  //
         = new TableColumn<Bus, String>("Chauffeur ");
    @FXML
      TableColumn<Bus,Integer> nbrplace  //
         = new TableColumn<Bus, Integer>("nbrplace ");
    @FXML
   private  TextField recherche ;
   @FXML
     private       Button ajouter = new Button();
   @FXML 
           private ImageView imgv;
    @FXML
     private  Button retour;
    @FXML
     private  Button refresh;
    @FXML
     private  Button pdf;
     
   public String pathh;
   static Bus recupBus;
  
           
        
    
    ObservableList<Bus> list;
    
   
    
    
    @Override
    
   public void initialize(URL url, ResourceBundle rb) {
        id_bus.setCellValueFactory(new PropertyValueFactory<>("id_bus"));
        Immat.setCellValueFactory(new PropertyValueFactory<>("Immat"));
        Ligne.setCellValueFactory(new PropertyValueFactory<>("Ligne"));
        Horaire.setCellValueFactory(new PropertyValueFactory<>("Horaire"));
        Chauffeur.setCellValueFactory(new PropertyValueFactory<>("Chauffeur"));
        nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
        
 
        ServiceBus srv  = new ServiceBus();
      
         
  
       
       // data = FXCollections.observableArrayList(srv.afficherBus()); 
        //tab.setItems(data);
        Immat.setMinWidth(100);
        Ligne.setMinWidth(70);
        Horaire.setMinWidth(100);
        Chauffeur.setMinWidth(100);
        nbrplace.setMinWidth(100);
    
        list=FXCollections.observableArrayList(srv.afficherBus());
        tab.setItems(list);
      
        
        
        tab.getColumns().addAll(Immat,Ligne,Horaire,Chauffeur,nbrplace);
        
       tab.setEditable(true);
       Immat.setCellFactory(TextFieldTableCell.<Bus> forTableColumn());
        Immat.setOnEditCommit((TableColumn.CellEditEvent<Bus, String> event) -> {
            TablePosition<Bus, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Bus o = event.getTableView().getItems().get(row);
 
            o.setImmat(newType);
           
            
            
            srv.modifierbus(o);
        });
        Ligne.setCellFactory(TextFieldTableCell.<Bus> forTableColumn());
        Ligne.setOnEditCommit((TableColumn.CellEditEvent<Bus, String> event) -> {
            TablePosition<Bus, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Bus o = event.getTableView().getItems().get(row);
 
            o.setLigne(newType);
            
            
            
            srv.modifierbus(o);
        });
        Horaire.setCellFactory(TextFieldTableCell.<Bus> forTableColumn());
        Horaire.setOnEditCommit((TableColumn.CellEditEvent<Bus, String> event) -> {
            TablePosition<Bus, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Bus o = event.getTableView().getItems().get(row);
 
            o.setHoraire(newType);
            
            
            
            srv.modifierbus(o);
        });
        Chauffeur.setCellFactory(TextFieldTableCell.<Bus> forTableColumn());
        Chauffeur.setOnEditCommit((TableColumn.CellEditEvent<Bus, String> event) -> {
            TablePosition<Bus, String> pos = event.getTablePosition();
 
            String newType = event.getNewValue();
 
            int row = pos.getRow();
            Bus o = event.getTableView().getItems().get(row);
 
            o.setChauffeur(newType);
            
            
            
            srv.modifierbus(o);
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
        ServiceBus srv=new ServiceBus();
        String k = (Immat.getCellData(tab.getSelectionModel().getSelectedIndex()).toString());
            srv.supprimerBus(k);
            afficher();
    }
});
 ajouter.setOnMouseClicked((event) -> {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("menu.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        Stage stage = new Stage();
        stage.setTitle("Ajout Bus");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
});
  retour.setOnAction((event) -> {
                    try {

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menudirecteur.fxml"));
                                Parent root = loader.load();
                                AcceuilController rc = loader.getController();
                                retour.getScene().setRoot(root);
                                
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());

                            }
                });
  

addButtonListeToTable();
    } 
   public void afficher()
   {
        id_bus.setCellValueFactory(new PropertyValueFactory<>("id_bus"));
        Immat.setCellValueFactory(new PropertyValueFactory<>("Immat"));
        Ligne.setCellValueFactory(new PropertyValueFactory<>("Ligne"));
        Horaire.setCellValueFactory(new PropertyValueFactory<>("Horaire"));
        Chauffeur.setCellValueFactory(new PropertyValueFactory<>("Chauffeur"));
        nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
        ServiceBus srv  = new ServiceBus();
       
       // data = FXCollections.observableArrayList(srv.afficherBus()); 
        //tab.setItems(data);
        Immat.setMinWidth(100);
        Ligne.setMinWidth(70);
        Horaire.setMinWidth(100);
        Chauffeur.setMinWidth(100);
        nbrplace.setMinWidth(100);
    
        list=FXCollections.observableArrayList(srv.afficherBus());
        tab.setItems(list);
   }
   public void recher(ActionEvent event) {
         
        Immat.setCellValueFactory(new PropertyValueFactory<>("Immat"));
        Ligne.setCellValueFactory(new PropertyValueFactory<>("Ligne"));
        Horaire.setCellValueFactory(new PropertyValueFactory<>("Horaire"));
        Chauffeur.setCellValueFactory(new PropertyValueFactory<>("Chauffeur"));
        nbrplace.setCellValueFactory(new PropertyValueFactory<>("nbrplace"));
          ServiceBus srv  = new ServiceBus(); 
        list=FXCollections.observableArrayList(srv.rechercherBus(recherche.getText()));
        tab.setItems(list);
  

   
}
    private void addButtonListeToTable() {
        TableColumn<Bus, Void> colBtn = new TableColumn("Liste Reservation");

        Callback<TableColumn<Bus, Void>, TableCell<Bus, Void>> cellFactory = new Callback<TableColumn<Bus, Void>, TableCell<Bus, Void>>() {
            @Override
            public TableCell<Bus, Void> call(final TableColumn<Bus, Void> param) {
                final TableCell<Bus, Void> cell = new TableCell<Bus, Void>() {

                    private final Button btn = new Button("Details");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            recupBus=getTableView().getItems().get(getIndex());
                            try {

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("reservationBus.fxml"));
                                Parent root = loader.load();
                                ReservationBusController rc = loader.getController();
                               btn.getScene().setRoot(root);

                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());

                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tab.getColumns().add(colBtn);

    }
    public void pdf(ActionEvent event)
    
   {
       ServiceBus S = new ServiceBus();
       try {
           S.FacturePdf();
       } catch (SQLException ex) {
           Logger.getLogger(AjoutBusController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (DocumentException ex) {
           Logger.getLogger(AjoutBusController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(AjoutBusController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    

}
