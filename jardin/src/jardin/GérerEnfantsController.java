/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceEnfant;
import entitie.Enfant;
import entitie.Paarent;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class GérerEnfantsController implements Initializable {

    @FXML
    private TableView<Enfant> membres1;
    @FXML
    private TableColumn<Enfant, Integer> id1;
    @FXML
    private TableColumn<Enfant, String> TcNom1;
    @FXML
    private TableColumn<Enfant, String> TcPrenom1;
    @FXML
    private TableColumn<Enfant, String> TcAge;
    @FXML
    private TableColumn<Enfant, String> TcPhoto1;
    @FXML
    private TableColumn<Enfant, String> Tcvaccin;
    @FXML
    private TableColumn<Enfant, String> Tcalergie;
    @FXML
    private TableColumn<Enfant, Integer> idpaar;

    private List<Enfant> listEnfant;//retourner liste de la select
    private ObservableList<Enfant> ObservablelisteEnfant;//p
    @FXML
    private Label label;
    @FXML
    private Button retour;
    @FXML
    private TableColumn<Enfant, String> email;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id1.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));//nom reference pour la colonne
          TcNom1.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          TcPrenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));//reference pour la colonne
          TcAge.setCellValueFactory(new PropertyValueFactory<>("age"));//reference pour la colonne

          TcPhoto1.setCellValueFactory(new PropertyValueFactory<>("photo"));//nom reference pour la colonne
        //reference pour la colonne
          Tcvaccin.setCellValueFactory(new PropertyValueFactory<>("vaccin"));//reference pour la colonne
          Tcalergie.setCellValueFactory(new PropertyValueFactory<>("alergie"));
          idpaar.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
          email.setCellValueFactory(new PropertyValueFactory<>("email"));
                    ServiceEnfant service = new ServiceEnfant();

        try {
            listEnfant = service.AfficherEnfanys();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

          ObservablelisteEnfant = FXCollections.observableArrayList(listEnfant);//convertir la liste des client en observable liste
          membres1.setItems(ObservablelisteEnfant);
          
    }  
    private void createtableviewEnfant() throws SQLException {
        
          ServiceEnfant services = new ServiceEnfant();
          
        
          id1.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));//nom reference pour la colonne
          TcNom1.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          TcPrenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));//reference pour la colonne
          TcAge.setCellValueFactory(new PropertyValueFactory<>("age"));//reference pour la colonne

          TcPhoto1.setCellValueFactory(new PropertyValueFactory<>("photo"));//nom reference pour la colonne
        //reference pour la colonne
          Tcvaccin.setCellValueFactory(new PropertyValueFactory<>("vaccin"));//reference pour la colonne
          Tcalergie.setCellValueFactory(new PropertyValueFactory<>("alergie"));
          idpaar.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
          email.setCellValueFactory(new PropertyValueFactory<>("email"));
                    
            listEnfant = services.AfficherEnfanys();
        

          ObservablelisteEnfant = FXCollections.observableArrayList(listEnfant);//convertir la liste des client en observable liste
          membres1.setItems(ObservablelisteEnfant);
    }

    @FXML
    private void select2(MouseEvent event) {
        /*ServiceEnfant services = new ServiceEnfant();
        Enfant enfant = membres1.getSelectionModel().getSelectedItem();

        tfId1.setText(Integer.toString(enfant.getId_enfant()));
        tfNom1.setText(enfant.getNom());
        tfPrenom1.setText(enfant.getPrenom());
        tfEmail1.setText(Integer.toString(enfant.getAge()));
        tfPhoto1.setText(enfant.getPhoto());
        tfTelephone1.setText(enfant.getVaccin());
        tfLogin1.setText(enfant.getAlergie());
        tfPassword1.setText(Integer.toString(enfant.getId_parent()));*/
        
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("menudirecteur.fxml"));
            Parent root= loader.load();
           retour.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
