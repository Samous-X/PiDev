/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author chadi
 */
public class AcceuilController implements Initializable {
@FXML 
    private Button Bus;
@FXML 
    private Button Vol;
@FXML 
    private Button Front;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void directiEspaceBus(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/AjoutBus.fxml"));
            Parent root= loader.load();
            
            AjoutBusController r= loader.getController();
           Bus.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void directiEspaceRes(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/liste.FXML"));
            Parent root= loader.load();
            
            ListeController r= loader.getController();
           Vol.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void directiFront(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/GUI/AffichageBus.fxml"));
            Parent root= loader.load();
            
            AffichageBusController r= loader.getController();
           Front.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
