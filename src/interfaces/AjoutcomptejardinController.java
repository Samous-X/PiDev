/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entities.Jardin;
import Service.ServiceJardin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class AjoutcomptejardinController implements Initializable {
   @FXML
    private Button btnajouter;
    @FXML
    private Label Profil;
    @FXML
    private ImageView Iback;
    @FXML
    private TextField nomjardin;
    @FXML
    private TextField adressejardin;
    @FXML 
    private TextField Prixjardin;
    @FXML 
    private ImageView nomi;
    @FXML 
    private ImageView adressei;
    @FXML 
    private ImageView prixi;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void btn(ActionEvent event) throws SQLException {
       try{ 
          
        String n=nomjardin.getText();
        String d=adressejardin.getText();
        String hd=Prixjardin.getText();
        int hdi = Integer.parseInt(hd);
        Jardin J=new Jardin(n,d,hdi);
        ServiceJardin SJ=new ServiceJardin();
        SJ.ajouter(J);
          FXMLLoader loader=new FXMLLoader(getClass().getResource("Menuaccueil.fxml"));
            try {
                Parent root = loader.load();
            MenuaccueilController cjc=loader.getController();
            
            cjc.setResomjardin(nomjardin);
            btnajouter.getScene().setRoot(root);
               
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
}
}
