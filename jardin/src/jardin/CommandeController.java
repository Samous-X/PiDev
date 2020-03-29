/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.commande;
import Service.ServicePanier;
import Service.serviceCommande;
import Service.serviceProduit;
import entitie.Mailing;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author ACER-PC
 */
public class CommandeController implements Initializable {

    
     @FXML
    private DatePicker date_livr;
    
     @FXML
    private Button confirmer;
    @FXML
    private Button annuler;
    @FXML
   private TextField num_compte;
  
    @FXML
    private AnchorPane comm_ande;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    @FXML
    public void annuler(ActionEvent event) throws SQLException {
       try {
            
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Panier.fxml"));
            Parent root = loader.load();
            PanierController e = loader.getController();
            annuler.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       ServicePanier srv = new ServicePanier();
            System.out.println(srv.readAll());
   }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        try {
                serviceCommande sp = new serviceCommande();

      System.out.println(date_livr.getValue());
      String numCompte = num_compte.getText();
        System.out.println(numCompte);
        String date_commande = java.time.LocalDate.now().toString();
        System.out.println(date_commande);
         commande cm = new commande(date_commande, java.sql.Date.valueOf(date_livr.getValue()),numCompte);
         
        
             sp.ajouterCom(cm);
         String to = "hejer.gharianii@gmail.com";
            String subject = "Validation Commande";
            String message = "Bienvenu  dans notre application ,votre commande est passé avec succés ";
            String usermail = "hejer.gharianii@gmail.com";
            String passmail = "jerjer2511";
            Mailing.send(to, subject, message, usermail, passmail);
             FXMLLoader loader = new FXMLLoader
                                (getClass()
                                        .getResource("Panier.fxml"));
        Parent root = loader.load();
        PanierController e = loader.getController();
        comm_ande.getChildren().setAll(root);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
      
    }
    
    
    
}
