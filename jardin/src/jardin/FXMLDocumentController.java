/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;
import entitie.panier;

import entitie.Produit;
import Service.ServicePanier;
import Service.serviceProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author ACER-PC
 */
public class FXMLDocumentController implements Initializable {
    
    
     @FXML
    private Button pann;
   
    private List<Produit> listProduit;//retourner liste de la select
       public static ObservableList<Produit> ObservablelisteProduit;
    @FXML
    private Button panier;
    @FXML
    private FlowPane flow;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
         


serviceProduit services = new serviceProduit();

 try {
              Afficher();
              // TODO
          } catch (SQLException ex) {
              Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
          }
 
     
        
    
    }  
    
    
  
   
    @FXML
   public void consulterpanier(ActionEvent event) {
       try {
            
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Panier.fxml"));
            Parent root = loader.load();
            PanierController e = loader.getController();
            pann.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
  
   
    @FXML
    private void ajoutpanier(ActionEvent event) throws SQLException {

          ServicePanier services = new ServicePanier();
          serviceProduit serv = new serviceProduit();
     /*   Produit st = pds.getSelectionModel().getSelectedItem();
        

        if (st != null) {
            int newType = st.getIdproduit();
                        panier p =new panier(st.getIdproduit(),1);
                        
                        

            services.ajouterPanier(p);
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un produit");
            alert.show();
        }*/
    }
   
   
    public void Afficher() throws SQLException {

        serviceProduit srv = new serviceProduit();
        
       
        ProduitController.i = 0;
        ArrayList<Produit> ok = new ArrayList<>();
        ok = (ArrayList) srv.readAll();
        ObservablelisteProduit = FXCollections.observableArrayList(ok);
        //obslsorted = FXCollections.observableArrayList((ArrayList) annonceService.trierParDate())
        //prixdesc = FXCollections.observableArrayList((ArrayList) annonceService.trierParPrixDESC());
//        indice = 0;
        Node[] nodes = new Node[ObservablelisteProduit.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
                

//                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Produit.fxml"));
               //e=FrontEventController.obsl.get(i);
                flow.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     /* panierService = new PanierService();
        int nbr=panierService.LonguerPanier();
        nombre_article.setText("("+nbr+")");*/
        
    }
  
}
    
