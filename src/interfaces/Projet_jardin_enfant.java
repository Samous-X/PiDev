/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entities.Jardin;
import Service.ServiceJardin;
import Service.ServiceStaff;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Dora
 */
public class Projet_jardin_enfant extends Application {
     @Override
    public void start(Stage primaryStage) throws Exception{
      try {
            Parent root = FXMLLoader.load(getClass().getResource("Firstaccueil.fxml"));
            
          // scene.getStylesheets().add(getClass().getResource("../Ressources/Style.css").toExternalForm());
          
          Image img=new Image("/Ressources/logo1.png");
          primaryStage.setTitle("BLOOM");
          Scene scene = new Scene(root);
             
            scene.getStylesheets().add("/Ressources/Style.css");

            primaryStage.getIcons().add(img);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
            
         } catch (IOException ex) {
            Logger.getLogger(Projet_jardin_enfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
         launch(args);
        ServiceStaff services = new ServiceStaff();
         /*try {
             services.FacturePdf();
             // TODO code application logic here
             /*      ServiceJardin ser = new ServiceJardin();
             Jardin j1 = new Jardin(33,"Jardin kantaoui", "40 cite narjes2 sousse", 3.145284 , 2.30254, "Bus",90);
             try {
             //
             ser.ajouter1(j1);
             
             List<Jardin> list = ser.readAll();
             System.out.println(list);
             } catch (SQLException ex) {
             System.out.println(ex);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Projet_jardin_enfant.class.getName()).log(Level.SEVERE, null, ex);
         } catch (DocumentException ex) {
             Logger.getLogger(Projet_jardin_enfant.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Projet_jardin_enfant.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }


  
}
