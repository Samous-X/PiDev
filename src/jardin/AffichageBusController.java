/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Bus;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import Service.ServiceBus;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class AffichageBusController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private FlowPane flow;
    @FXML
    private BorderPane container;
    @FXML 
    private Button Menu;


    public static ObservableList<Bus> obsl;

   
    public static int indice;
    public static int x=0;
    
    public static Bus e ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Afficher();
      
    }  
    public void Afficher() {

        ServiceBus srv = new ServiceBus();
        
       
        BusController.i = 0;
        ArrayList<Bus> annonces = new ArrayList<>();
        annonces = (ArrayList) srv.afficherBus2();
        obsl = FXCollections.observableArrayList(annonces);
        //obslsorted = FXCollections.observableArrayList((ArrayList) annonceService.trierParDate())
        //prixdesc = FXCollections.observableArrayList((ArrayList) annonceService.trierParPrixDESC());
        indice = 0;
        Node[] nodes = new Node[obsl.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
                

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Bus.fxml"));
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
    public void directAccueil(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/Acceuil.fxml"));
            Parent root= loader.load();
            
            AcceuilController r= loader.getController();
           Menu.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}