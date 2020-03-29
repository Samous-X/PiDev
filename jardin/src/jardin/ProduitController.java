/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Produit;
import entitie.panier;
import Service.ServicePanier;
import Service.serviceProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ACER-PC
 */
public class ProduitController implements Initializable {
    
    
     @FXML
    private Button panier;
      @FXML
    private ImageView img_prod;
      @FXML
 private Label lbl_prix;
      @FXML     
private Label lbl_qte;
      static int i;
 public  static Produit p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        p =FXMLDocumentController.ObservablelisteProduit.get(i);             
        System.out.println(FXMLDocumentController.ObservablelisteProduit.get(i).getImg_prod());
        Image image = new Image("file:/"+FXMLDocumentController.ObservablelisteProduit.get(i).getImg_prod());
        img_prod.setImage(image);
         
        lbl_prix.setText(Integer.toString(FXMLDocumentController.ObservablelisteProduit.get(i).getPrix_prod()));
        lbl_qte.setText(Integer.toString(FXMLDocumentController.ObservablelisteProduit.get(i).getQte()));
        panier.setOnAction((event) -> {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
            Parent root = loader.load();
            PanierController rc = loader.getController();
            panier.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
            });

            i++;
                                   

                    
            }   
     @FXML
    private void ajoutpanier(ActionEvent event) throws SQLException {

          ServicePanier services = new ServicePanier();
          serviceProduit serv = new serviceProduit();
          /*Produit st = pds.getSelectionModel().getSelectedItem();
          panier p =new panier(st.getIdproduit(),1);
          services.ajouterPanier(p);*/
           
       
    }
        
    
}
