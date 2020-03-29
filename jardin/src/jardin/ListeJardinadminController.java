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
import javafx.scene.control.Alert;
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
public class ListeJardinadminController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private TableView<Jardin> Jardins;
    
    private List<Jardin> listjardin;//retourner liste de la select
    private ObservableList<Jardin> ObservablelisteJardin;//pour la table view
    @FXML
    private TableColumn<Jardin, Integer> tbiden;
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
    private TextField tfNom;
    @FXML
    private TextField tfIdl;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfprix;
    @FXML
    private Button modif;
    @FXML
    private Button supp;
    @FXML
    private Button ajout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tbiden.setCellValueFactory(new PropertyValueFactory<>("idjardin"));//nom reference pour la colonne
          tbnom.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          tbAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));//reference pour la colonne
          tbprix_mois.setCellValueFactory(new PropertyValueFactory<>("Prix_mois"));//reference pour la colonne

        
        //reference pour la colonne
          
                    ServiceJardin services = new ServiceJardin();

        try {
            listjardin = services.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListeJardinadminController.class.getName()).log(Level.SEVERE, null, ex);
        }

          ObservablelisteJardin = FXCollections.observableArrayList(listjardin);//convertir la liste des client en observable liste
          Jardins.setItems(ObservablelisteJardin);
        
    }

   private void createtableviewJardin() throws SQLException {
       ServiceJardin services = new ServiceJardin();
         tbiden.setCellValueFactory(new PropertyValueFactory<>("idjardin"));//nom reference pour la colonne
          tbnom.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          tbAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));//reference pour la colonne
          tbprix_mois.setCellValueFactory(new PropertyValueFactory<>("Prix_mois"));//reference pour la colonne

          
          listjardin= services.readAll();
          ObservablelisteJardin = FXCollections.observableArrayList(listjardin);//convertir la liste des client en observable liste
          Jardins.setItems(ObservablelisteJardin);
          
          
          
          
      }
      
      
    @FXML
    private void ajoutadminjardin(ActionEvent event) throws SQLException {
     try {
            

            FXMLLoader loader=new FXMLLoader(getClass().getResource("Ajoutadminjardin.fxml"));
            Parent root = loader.load();
            //AjoutadminjardinController cjc=loader.getController();
            ajout.getScene().setRoot(root);
           
             
        } catch (IOException ex) {
            Logger.getLogger(ListeJardinController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       
        

    } 
    @FXML
    private void select(MouseEvent event) {
        ServiceJardin se = new ServiceJardin();
        Jardin st = Jardins.getSelectionModel().getSelectedItem();

        tfIdl.setText(Integer.toString(st.getIdjardin()));
        tfNom.setText(st.getNom());
        tfadresse.setText(st.getAdresse());
        tfprix.setText(Integer.toString(st.getPrix_mois()));
        
       
    } 
     @FXML
    private void supprimerJardin(ActionEvent event) throws SQLException {
         ServiceJardin services = new ServiceJardin();
        Jardin st = Jardins.getSelectionModel().getSelectedItem();

        if (st != null) {
 
                    services.delete(st);
                 createtableviewJardin();                
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un jardin");
            alert.show();
        }
    }
    @FXML
    private void modifier(ActionEvent event) throws SQLException {
         ServiceJardin services = new ServiceJardin();
    /*Staff s=new Staff();
    s.setId_staff(Integer.parseInt(tfIdl.getText()));
    s.setNom_staff(tfNom.getText());
    s.setPrenom_staff(tfPrenom.getText());
    s.setPoste(tfPoste.getText());*/
    
     int ID=Integer.parseInt(tfIdl.getText());
  
     String nom=tfNom.getText();
     String adresse=tfadresse.getText();
     int prix=Integer.parseInt(tfprix.getText());
     /*if ((String.valueOf(status.getValue())).equals("Actif")) {
                       s.setStatus("Actif");
                } else {
                    s.setStatus("Inactif");
                }*/
     
     Jardin j =new Jardin(ID,tfNom.getText(),tfadresse.getText(),prix);
     //Staff staff =new Staff();
     services.Update2(j,nom,adresse,prix);
     createtableviewJardin();
        
       
    }  
    
      
    
}
