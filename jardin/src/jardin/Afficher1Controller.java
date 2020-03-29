/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.event;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import Service.eventService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class Afficher1Controller implements Initializable {

  
static ObservableList<event> obs;
    @FXML
    private FlowPane fo;
    @FXML
    private Button retourner;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Afficher();
        // TODO
    }    
    public void Afficher()  {
    
        
    try {
        eventService srv = new eventService();
        
       
        Event1Controller.i = 0;
        ArrayList<event> annonces = (ArrayList<event>) srv.listevent();
        System.out.println(srv.listevent());
        obs = FXCollections.observableArrayList(annonces);
        //obslsorted = FXCollections.observableArrayList((ArrayList) annonceService.trierParDate())
        //prixdesc = FXCollections.observableArrayList((ArrayList) annonceService.trierParPrixDESC());
        
        Node[] nodes = new Node[obs.size()];
        
        for (int i = 0; i < nodes.length; i++) {
            
            
            
            
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("event1.fxml"));
                //  e=FrontEventController.obsl.get(i);
                fo.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(Afficher1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
//
          
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Afficher1Controller.class.getName()).log(Level.SEVERE, null, ex);
    }


    }

    @FXML
    private void retour(ActionEvent event) {
        
    }




}
