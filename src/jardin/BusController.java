/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Bus;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import Service.ServiceBus;
import Service.ServiceReservation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class BusController implements Initializable {

    @FXML
    private ImageView img_annoce;
    @FXML
    private Label lbl_Nom;
    @FXML
    private Label id_annonce;
    @FXML

    private Button consulter;
    @FXML
    private Label lbl_Adresse;
    @FXML
    private Button likes;
    @FXML
    private Button signaler;
    @FXML
    private Button panier;
    @FXML
    private VBox vbox;
    private ServiceBus service;
    static int i;
    public int t;
    public int iduser;
    public double xx;
    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    @FXML
    private Label lbl_nbr;
    @FXML 
    public  Button participer;
    @FXML 
    public  Button annuler;
    
    static int x = 5;
  
    public  static Bus b;
     public   Bus b1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_annonce.setVisible(false);
        // TODO
      //  lignecommandeService = new LigneCommandeService();
     
                
                lbl_Nom.setText(AffichageBusController.obsl.get(i).getImmat());
                //lbl_Adresse.setText(AffichageBusController.obsl.get(i).getLigne());
                lbl_Adresse.setText(Integer.toString(AffichageBusController.obsl.get(i).getNbrplace()));
               
                b=AffichageBusController.obsl.get(i); 
                b1=AffichageBusController.obsl.get(i);
                
                System.out.println(AffichageBusController.obsl.get(i).getImage());
                Image image = new Image("file:/"+AffichageBusController.obsl.get(i).getImage());
                img_annoce.setImage(image);
                ServiceReservation sr= new ServiceReservation();
                 if(sr.Rechercherahmed(b1.getImmat()))
                 {
                    participer.setVisible(false);
                   
                    annuler.setVisible(true);
                 }
                 else{
                     participer.setVisible(true);     
                  annuler.setVisible(false);
                  
                     }
                 participer.setOnAction((event) -> {
                    try {

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("reserver.fxml"));
                                Parent root = loader.load();
                                ReserverController rc = loader.getController();
                                participer.getScene().setRoot(root);
                                
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());

                            }
                });
                 annuler.setOnAction((event) -> {
                     ServiceReservation sra= new ServiceReservation();
                   sra.supprimer2(b1.getImmat());
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("");
             alert.setHeaderText("PARTICIPATION");
             alert.setContentText("Vous avez annulé votre Reservation !!");
             
             alert.showAndWait();
 participer.setVisible(true);
                   
                    annuler.setVisible(false);
                });

                    i++;
                                   

                    
            }   
    
    
}
