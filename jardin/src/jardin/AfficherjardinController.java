/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Jardin;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import Service.ServiceJardin;
import java.util.List;

/**
 * FXML Controller class
 *
 * @author ahmed
 */

public class AfficherjardinController implements Initializable {

  
static ObservableList<Jardin> obs;
    @FXML
    private FlowPane fo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Afficher();
        // TODO
    }    
    public void Afficher()  {
        
        
        
        
        /*
        
         eventService srv = new eventService();
        
       
        Event1Controller.i = 0;
        ArrayList<event> annonces = (ArrayList<event>) srv.listevent();
        System.out.println(srv.listevent());
        obs = FXCollections.observableArrayList(annonces);
        */
    
        
        ServiceJardin srv = new ServiceJardin();
        Jardin1Controller.i = 0;
        ArrayList<Jardin> j = (ArrayList<Jardin>) srv.listjardin();
        System.out.println(srv.listjardin());
        obs = FXCollections.observableArrayList(j);
        //obslsorted = FXCollections.observableArrayList((ArrayList) annonceService.trierParDate())
        //prixdesc = FXCollections.observableArrayList((ArrayList) annonceService.trierParPrixDESC());
        Node[] nodes = new Node[obs.size()];
        for (int i = 0; i < nodes.length; i++) {
            
            
            
            
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("jardin1.fxml"));
                //  e=FrontEventController.obsl.get(i);
                fo.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(AfficherjardinController.class.getName()).log(Level.SEVERE, null, ex);
            }
//
          
        }

   

    }



}
