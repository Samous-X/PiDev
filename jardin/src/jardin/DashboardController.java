/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceEnfant;
import Service.ServiceNotification;
import Service.ServiceParent;
import Service.ServiceUtilisateur;
import entitie.Directeur;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import test.menuPa;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class DashboardController implements Initializable {

    /*@FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPhoto;
    @FXML
    private TextField tfTelephone;
    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfPrenom;
   @FXML
    private Button modifier;*/
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Directeur, Integer> id;
    @FXML
    private TableColumn<Directeur, String> TcNom;
    
    @FXML
    private TableColumn<Directeur, String> TcEmail;
    
    @FXML
    private TableColumn<Directeur, Integer> TcTel;
    @FXML
    private TableColumn<Directeur,String> TcLogin;
    @FXML
    private TableColumn<Directeur, String> TcPassword;
    @FXML
    private TableView<Directeur> membres;
    
    private List<Directeur> listParent;//retourner liste de la select
    private ObservableList<Directeur> ObservablelisteParent;//pour la table view
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    private TextField tfPhoto;
    @FXML
    private TextField tfTelephone;
    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfPassword;
    private TextField tfPrenom;
    @FXML
    private Button modifier;
    
    //enfant
    @FXML
    private TableView<Enfant> membres1;
    private List<Enfant> listEnfant;//retourner liste de la select
    private ObservableList<Enfant> ObservablelisteEnfant;//p
    @FXML
    private TableColumn<Enfant, Integer> id1;
    @FXML
    private TableColumn<Enfant, String> TcNom1;
    @FXML
    private TableColumn<Enfant, String> TcPrenom1;
    @FXML
    private TableColumn<Enfant, Integer> TcAge;
    @FXML
    private TableColumn<Enfant, String> TcPhoto1;
    @FXML
    private TableColumn<Enfant, String> Tcvaccin;
    @FXML
    private TableColumn<Enfant, String> Tcalergie;
    @FXML
    private TableColumn<Enfant,Integer> idpaar;
    @FXML
    private Button btnsupp;
    @FXML
    private TextField tfId1;
    @FXML
    private TextField tfNom1;
    @FXML
    private TextField tfEmail1;
    @FXML
    private TextField tfPhoto1;
    @FXML
    private TextField tfTelephone1;
    @FXML
    private TextField tfLogin1;
    @FXML
    private TextField tfPassword1;
    @FXML
    private TextField tfPrenom1;
    @FXML
    private Button modifier1;
    private TextField tfCin;
    @FXML
    private Label nom;
    
    private static ServiceUtilisateur myServices = new ServiceUtilisateur();
    public static String username;
    public static int idutilisateur;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Directeur loggedUtilisateur = LoginAdminController.getInstance().getLoggedUtilisateur();
        Directeur UtilisateurConnecte = myServices.chercherUtilisateurByid(loggedUtilisateur.getId_utilisateur());
        idutilisateur = loggedUtilisateur.getId_utilisateur();
        
      ServiceUtilisateur myServices = new ServiceUtilisateur();
        
       menuPa.Id_directeur_connecte=loggedUtilisateur.getId_utilisateur();
       

        username=UtilisateurConnecte.getNom();
        nom.setText("" + String.valueOf(UtilisateurConnecte.getNom()));
        
        
        
        id.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));//nom reference pour la colonne
          TcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          
          TcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));//reference pour la colonne

          
          TcTel.setCellValueFactory(new PropertyValueFactory<>("tel"));//reference pour la colonne
          TcLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
          TcPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
                    ServiceParent services = new ServiceParent();

        try {
            listParent = myServices.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

          ObservablelisteParent = FXCollections.observableArrayList(listParent);//convertir la liste des client en observable liste
          membres.setItems(ObservablelisteParent);
          
          
          
          
          //enfant
          id1.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));//nom reference pour la colonne
          TcNom1.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          TcPrenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));//reference pour la colonne
          TcAge.setCellValueFactory(new PropertyValueFactory<>("age"));//reference pour la colonne

          TcPhoto1.setCellValueFactory(new PropertyValueFactory<>("photo"));//nom reference pour la colonne
        //reference pour la colonne
          Tcvaccin.setCellValueFactory(new PropertyValueFactory<>("vaccin"));//reference pour la colonne
          Tcalergie.setCellValueFactory(new PropertyValueFactory<>("alergie"));
          idpaar.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
                    ServiceEnfant service = new ServiceEnfant();

        try {
            listEnfant = service.AfficherEnfanys();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

          ObservablelisteEnfant = FXCollections.observableArrayList(listEnfant);//convertir la liste des client en observable liste
          membres1.setItems(ObservablelisteEnfant);
          
    }  
    
    
   /* private void modifierparent(ActionEvent event) throws IOException, SQLException {

        ServiceParent services = new ServiceParent();
        Paarent parent = membres.getSelectionModel().getSelectedItem();

        tfId.setText(Integer.toString(parent.getId_parent()));
        tfNom.setText(parent.getNom());
        tfPrenom.setText(parent.getPrenom());
        tfEmail.setText(parent.getEmail());
        tfPhoto.setText(parent.getPhoto());
        tfTelephone.setText(Integer.toString(parent.getTel()));
        tfLogin.setText(parent.getLogin());
        tfPassword.setText(parent.getPassword());
        String login=tfLogin.toString();
        String password=tfPassword.toString();
        
            if (parent != null) {

                services.modifierCoordonnésparent(parent, login,password);
                ServiceNotification.showNotif("Felicitaion ", "Vous Avez modifier ce membre" + "" + parent.getNom() + " avec sucées");
                createtableviewParent();
            }
         else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un personne");
            alert.show();
        }

    }*/

    /*@FXML
    private void modifierparent(ActionEvent event) {
        
    }*/

    @FXML
    private void supprimerparent(ActionEvent event) throws SQLException {
        ServiceUtilisateur services = new ServiceUtilisateur();
        Directeur utilisateur = membres.getSelectionModel().getSelectedItem();

        if (utilisateur != null) {
 
                    services.supprimerUtilisateur(utilisateur);
                 createtableviewParent();                
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un membre");
            alert.show();
        }
    }
    private void createtableviewParent() throws SQLException {
        
          ServiceUtilisateur services = new ServiceUtilisateur();
          
        
          id.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));//nom reference pour la colonne
          TcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));//nom reference pour la colonne
 
          
          TcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));//reference pour la colonne

         
          TcTel.setCellValueFactory(new PropertyValueFactory<>("tel"));//reference pour la colonne
          TcLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
          TcPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
          listParent = services.readAll();

          ObservablelisteParent = FXCollections.observableArrayList(listParent);//convertir la liste des client en observable liste
          membres.setItems(ObservablelisteParent);
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
                    
            listEnfant = services.AfficherEnfanys();
        

          ObservablelisteEnfant = FXCollections.observableArrayList(listEnfant);//convertir la liste des client en observable liste
          membres1.setItems(ObservablelisteEnfant);
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
      
        ServiceParent services = new ServiceParent();
        String login=tfLogin.getText();
        String password=tfPassword.getText();
        
        int ID=Integer.parseInt(tfId.getText());
        int TeL=Integer.parseInt(tfTelephone.getText());
        int CIN=Integer.parseInt(tfCin.getText());
        Paarent parent=new Paarent(ID,tfNom.getText(),tfPrenom.getText(),CIN,tfEmail.getText(),tfPhoto.getText(),TeL);
        services.modifierCoordonnésparent(parent, login,password);
        ServiceNotification.showNotif("Felicitaion ", "Vous Avez modifier ce membre " + "" + parent.getNom() + " avec sucées");
        createtableviewParent();
            
       
    }

    @FXML
    private void select(MouseEvent event) {
        ServiceUtilisateur services = new ServiceUtilisateur();
        Directeur utilisateur = membres.getSelectionModel().getSelectedItem();

        tfId.setText(Integer.toString(utilisateur.getId_utilisateur()));
        tfNom.setText(utilisateur.getNom());
        
        tfEmail.setText(utilisateur.getEmail());
        
        tfTelephone.setText(Integer.toString(utilisateur.getTel()));
        tfLogin.setText(utilisateur.getLogin());
        tfPassword.setText(utilisateur.getPassword());
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
        ServiceEnfant services = new ServiceEnfant();
        Enfant enfant = membres1.getSelectionModel().getSelectedItem();

        if (enfant != null) {
 
                    services.supprimerEnfant(enfant);
                 createtableviewEnfant();                
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un membre");
            alert.show();
        }
    }
    /*private void modifier1(ActionEvent event) throws SQLException {
      
        ServiceEnfant services = new ServiceEnfant();
        String login=tfLogin.getText();
        int ID=Integer.parseInt(tfId1.getText());
        int aage=Integer.parseInt(tfEmail1.getText());
        int idp=Integer.parseInt(tfPassword1.getText());
        Enfant enfant=new Enfant(ID,tfNom1.getText(),tfPrenom1.getText(),aage,tfPhoto1.getText(),idp,tfTelephone1.getText(),tfLogin1.getText());
        services.modifierEnfant(enfant, login);
        ServiceNotification.showNotif("Felicitaion ", "Vous Avez modifier ce membre " + "" + enfant.getNom() + " avec sucées");
        createtableviewParent();
            
       
    }*/

    @FXML
    private void select2(MouseEvent event) {
        ServiceEnfant services = new ServiceEnfant();
        Enfant enfant = membres1.getSelectionModel().getSelectedItem();

        tfId1.setText(Integer.toString(enfant.getId_enfant()));
        tfNom1.setText(enfant.getNom());
        tfPrenom1.setText(enfant.getPrenom());
        tfEmail1.setText(Integer.toString(enfant.getAge()));
        tfPhoto1.setText(enfant.getPhoto());
        tfTelephone1.setText(enfant.getVaccin());
        tfLogin1.setText(enfant.getAlergie());
        tfPassword1.setText(Integer.toString(enfant.getId_parent()));
    }

    @FXML
    private void modifierenfant(ActionEvent event) throws SQLException {
        ServiceEnfant services = new ServiceEnfant();
        String login=tfNom1.getText();
        int ID=Integer.parseInt(tfId1.getText());
        int aage=Integer.parseInt(tfEmail1.getText());
        int idp=Integer.parseInt(tfPassword1.getText());
        Enfant enfant=new Enfant(ID,tfNom1.getText(),tfPrenom1.getText(),aage,tfPhoto1.getText(),idp,tfTelephone1.getText(),tfLogin1.getText());
        services.modifierEnfant(enfant, login);
        ServiceNotification.showNotif("Felicitaion ", "Vous Avez modifier ce membre " + "" + enfant.getNom() + " avec sucées");
        createtableviewEnfant();
        
    }
    
    
    
    
}
