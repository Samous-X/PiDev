/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServicePanier;
import Service.serviceProduit;
import entitie.Produit;
import entitie.panier;
import static jardin.FXMLDocumentController.ObservablelisteProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class Dashboard_1Controller implements Initializable {

   @FXML
    private TableColumn<Produit, String> nom_p;
    @FXML
    private TableColumn<Produit, Integer> prix_p;
    @FXML
    private TableColumn<Produit, Integer> qte_p;
    @FXML
    private TableColumn<Produit, String> idprod;
    @FXML
    private TableView<Produit> pds;
    private List<Produit> listProduit;//retourner liste de la select
       public static ObservableList<Produit> ObservablelisteProduit;
    @FXML
    private Button intajout;
    @FXML
    private Button supp;
    @FXML
    private Button help;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
     nom_p.setCellValueFactory(new PropertyValueFactory<>("nomproduit"));//nom reference pour la colonne
      prix_p.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));//nom reference pour la colonne
       qte_p.setCellValueFactory(new PropertyValueFactory<>("qte"));//reference pour la colonne
     idprod.setCellValueFactory(new PropertyValueFactory<>("idproduit"));//reference pour la colonne
         


serviceProduit services = new serviceProduit();

     try {
            listProduit = services.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
     ObservablelisteProduit = FXCollections.observableArrayList(listProduit);//convertir la liste en observable liste
          pds.setItems(ObservablelisteProduit);
        
     pds.setEditable(true);
      pds.getColumns().addAll();
    nom_p.setCellFactory(TextFieldTableCell.<Produit> forTableColumn());
        nom_p.setOnEditCommit((TableColumn.CellEditEvent<Produit, String> event) -> {
         try {
             TablePosition<Produit, String> pos = event.getTablePosition();
             
             String newType = event.getNewValue();
             int row = pos.getRow();
             Produit p = event.getTableView().getItems().get(row);
             p.setNomproduit(newType);
             
             services.modifierprodint(p);
             pds.setItems(ObservablelisteProduit);
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        });
        // TODO
    }    
    @FXML
   public void ajouter(ActionEvent event) {
       try {
            
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AjouterProd.fxml"));
            Parent root = loader.load();
            AjouterProdController e = loader.getController();
            intajout.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
   
  
  
    @FXML
    private void supprimer(ActionEvent event) {

          serviceProduit services = new serviceProduit();
        Produit st = pds.getSelectionModel().getSelectedItem();

        if (st != null) {
            
 
                    services.supproduit(st.getIdproduit());                
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un produit");
            alert.show();
        }
    }

  
}
