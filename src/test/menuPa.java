/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Service.ServiceParent;
import Service.ServiceUtilisateur;
import entitie.Paarent;
import entitie.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hejer Ghariani
 */
public class menuPa extends Application{
    
    public static int Id_user_connecte;
    public static int Id_directeur_connecte;
    
    private Parent gotoLogin() {
        try {
           Parent root = FXMLLoader.load(getClass().getResource("/jardin/Acceuil.fxml"));
           return root;
        } catch (Exception ex) {
            Logger.getLogger(menuPa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         Parent root =  gotoLogin();

        Scene scene = new Scene(root);

        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml")); 
        //FXMLController controller = fxmlLoader.<FXMLController>getController();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
          ServiceParent myServices=new ServiceParent();
           List<Paarent> list=new ArrayList<>();
           ServiceUtilisateur Service=new ServiceUtilisateur();
           List<Utilisateur> list2=new ArrayList<>();
           launch(args);

    }

    
}
