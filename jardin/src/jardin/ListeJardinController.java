/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Jardin;
import entitie.Staff;
import Service.ServiceJardin;
import Service.ServiceStaff;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class ListeJardinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Jardin> Jardins;
    
    private List<Jardin> listjardin;//retourner liste de la select
    private ObservableList<Jardin> ObservablelisteJardin;//pour la table view
    @FXML
    private TableColumn<Jardin, String> tbnom;
    @FXML
    private TableColumn <Jardin, String>tbAdresse;
    @FXML
    private TableColumn<Jardin, Integer> tbprix_mois;
    @FXML
    private ImageView back;
    @FXML
    private ImageView logo;
    @FXML
    private Button ins;
    
    

    @FXML
    private ImageView retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         
          tbnom.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
          tbAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));//reference pour la colonne
          tbprix_mois.setCellValueFactory(new PropertyValueFactory<>("Prix_mois"));//reference pour la colonne

        
        //reference pour la colonne
          
                    ServiceJardin services = new ServiceJardin();

        try {
            listjardin = services.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListeJardinController.class.getName()).log(Level.SEVERE, null, ex);
        }

          ObservablelisteJardin = FXCollections.observableArrayList(listjardin);//convertir la liste des client en observable liste
          Jardins.setItems(ObservablelisteJardin);
        
    }

   private void createtableviewJardin() throws SQLException {
       ServiceJardin services = new ServiceJardin();
        
          tbnom.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          tbAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));//reference pour la colonne
          tbprix_mois.setCellValueFactory(new PropertyValueFactory<>("Prix_mois"));//reference pour la colonne

          
          listjardin= services.readAll();
          ObservablelisteJardin = FXCollections.observableArrayList(listjardin);//convertir la liste des client en observable liste
          Jardins.setItems(ObservablelisteJardin);
          
          
          
          
      }
      
    @FXML  
    private void Sinscrire(ActionEvent event) throws SQLException {
    /*ServiceStaff services = new ServiceStaff();
     int ID=Integer.parseInt(tbiden.getText());
     String nom=tfNom.getText();
     String adresse=tbAdresse.getText();
     String poste=tbprix_mois.getText();
     Staff staff =new Staff(ID,tbnom.getText(),tbprenom.getText(),tbposte.getText());
     services.Update(staff, nom, prenom, poste);
     createtableviewJardin();
       */
     FXMLLoader loader=new FXMLLoader(getClass().getResource("Inscription.fxml"));
         
                 
         try {
           Parent  root = loader.load();
            InscriptionController cjc=loader.getController();
            
            ins.getScene().setRoot(root);
               
         } catch (IOException ex) {
             Logger.getLogger(ListeJardinController.class.getName()).log(Level.SEVERE, null, ex);
         }
  
               
       
        

    } 
    @FXML
    private void select(MouseEvent event) {
        ServiceJardin se = new ServiceJardin();
        Jardin st = Jardins.getSelectionModel().getSelectedItem();


        
       
    }    

   

    @FXML
    private void retour(MouseEvent event) {
         try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("Firstaccueil.fxml"));
            Parent root = loader.load();
            //FirstaccueilController cjc=loader.getController();
            retour.getScene().setRoot(root);
          
        } catch (IOException ex) {
            Logger.getLogger(ListeJardinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      
    
}
