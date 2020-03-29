/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.panier;
import Service.ServicePanier;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static jardin.ProduitController.i;

/**
 * FXML Controller class
 *
 * @author ACER-PC
 */
public class PanierController implements Initializable {
    
    
    @FXML
    private Button commande;
    @FXML
    private Button ann;
    @FXML 
    private Button supppanier;
    @FXML
    private Label lab0;
     @FXML
    private TableView<panier> monpan;
     @FXML
    private TableColumn<panier, Integer> idpanier;
     @FXML
    private TableColumn<panier, Integer> idproduit;
    @FXML
    private TableColumn<panier, Integer> idparent;
    @FXML
    private TableColumn<panier, Integer> prix_prod;
 private List<panier> listpanier;//retourner liste de la select
    private ObservableList<panier> Observablelistepanier;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idpanier.setCellValueFactory(new PropertyValueFactory<>("idpanier"));//nom reference pour la colonne
               
        idproduit.setCellValueFactory(new PropertyValueFactory<>("idproduit"));//nom reference pour la colonne
 
        idparent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));//nom reference pour la colonne
      
        prix_prod.setCellValueFactory(new PropertyValueFactory<>("prix_prod"));

        ServicePanier services = new ServicePanier();

     try {
            listpanier = services.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
     Observablelistepanier = FXCollections.observableArrayList(listpanier);//convertir la liste en observable liste
          monpan.setItems(Observablelistepanier);
        try {
            //int prix = prix_prod.getCellValueFactory(new PropertyValueFactory<>("prix_prod"));
            //prix_prod.getCellFactory(new PropertyValueFactory<panier,Integer>("prix_prod"));
            // montant_total.setText(Integer.toString(services.montanttotal(prix)));
            lab0.setText(""+services.somme());
        } catch (SQLException ex) {
            Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @FXML
    public void annuler(ActionEvent event) throws SQLException {
       try {
            
             FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
            FXMLDocumentController e = loader.getController();
            ann.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
     //  ServicePanier srv = new ServicePanier();
          //  System.out.println(srv.readAll());
   }
    
    @FXML
     public void commande(ActionEvent event) {
       try {
            
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("commande.fxml"));
            Parent root = loader.load();
            CommandeController e = loader.getController();
            ann.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
     @FXML
     public void supppanier(ActionEvent event){
      ServicePanier services = new ServicePanier();
        panier st = monpan.getSelectionModel().getSelectedItem();

        if (st != null) {
            
 
                    services.suppanier(st.getIdpanier());                
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un produit");
            alert.show();
        }
     }
}
