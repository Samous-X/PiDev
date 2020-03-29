/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.FirstPdf;
import Service.ServiceEnfant;
import Service.ServiceParent;
import static com.itextpdf.text.Annotation.FILE;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entitie.Enfant;
import entitie.Paarent;
import static jardin.MenuParentController.idparent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class AfficherEnfantController implements Initializable {

    @FXML
    private Label loggedparent;
    @FXML
    private Button btnAjEnf;
    @FXML
    private Button btnAffEnf;
    @FXML
    private Button btnProfil;
    @FXML
    private Button btnEv;
    @FXML
    private Button btnPanier;
    @FXML
    private AnchorPane affEnfant;
    @FXML
    private ComboBox<String> com;
    @FXML
    private Label nbEnfants;
    private static ServiceParent myServices = new ServiceParent();
    private static ServiceEnfant Service = new ServiceEnfant();
    //List<String> listeEnfant = new ArrayList<String>();
    ObservableList<String> observableListEnfant;
    @FXML
    private Label nomE;
    @FXML
    private Label prenomE;
    @FXML
    private Label AgeE;
    @FXML
    private Label VaccinE;
    @FXML
    private Label AllergieE;

    /**
     * Initializes the controller class.
     */
    
    
    /*public void getEnfants() {
        Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
        idparent = loggedParent.getId_parent();
        List<Enfant> listeEnfant = new ArrayList<Enfant>();
        ServiceEnfant Service = ServiceEnfant.getInstance();
        listeEnfant = (List<Enfant>) Service.readById(idparent);
        for (Enfant e : listeEnfant) {
            com.getItems().add(e.getNom());
        }
    }*/
   
    Enfant enfant;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Paarent loggedParent = InscriptionController.getInstance().getLoggedParent();
        Paarent ParentConnecte = myServices.chercherParentByid(loggedParent.getId_utilisateur());
        idparent = loggedParent.getId_utilisateur();
        int nb=Service.nbEnfants(idparent);
        nbEnfants.setText("Vous avez  "  + String.valueOf(nb)+ " enfant(s)");
        
        List<Enfant> listeEnfant = new ArrayList<Enfant>();
        ServiceEnfant Service = ServiceEnfant.getInstance();
        try {
            listeEnfant = Service.readById(idparent);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEnfantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Enfant e : listeEnfant) {
            com.getItems().add(e.getNom());
        }
        
        /*ServiceEnfant services = new ServiceEnfant();
        String ee=com.getSelectionModel().getSelectedItem();
        
        Enfant EnfantSelected=services.findEnfant(ee);
        System.out.println(EnfantSelected);*/
        /*nomE.setText(EnfantSelected.getNom());
        prenomE.setText(EnfantSelected.getPrenom());
        AgeE.setText(String.valueOf(EnfantSelected.getAge()));
        VaccinE.setText(EnfantSelected.getVaccin());
        AllergieE.setText(EnfantSelected.getAlergie());*/
        /*String nom=com.getSelectedItem().toString();
        System.out.println(nom);
        Enfant EnfantSelected=Service.rechercherenfant(nom);*/
        /*enfant = new Enfant();
        com.setOnAction((ActionEvent event)->{
             Object selected = com.getSelectionModel().getSelectedItem();
            enfant.getNom();
        });*/
        
        /*nomE.setText(EnfantSelected.getNom());
        prenomE.setText(EnfantSelected.getPrenom());
        AgeE.setText(String.valueOf(EnfantSelected.getAge()));
        VaccinE.setText(EnfantSelected.getVaccin());
        AllergieE.setText(EnfantSelected.getAlergie());*/
        
        
        
       
        /*observableListEnfant = FXCollections.observableList();//convertir la liste des enfants
        com.setItems(observableListEnfant);*/
        
    }    


    @FXML
    private void ajouterEnfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEnfant.fxml"));
        Parent root = loader.load();
        AjouterEnfantController e = loader.getController();
        affEnfant.getChildren().setAll(root);
    }

    @FXML
    private void AfficherEnfant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEnfant.fxml"));
        Parent root = loader.load();
        AfficherEnfantController e = loader.getController();
        affEnfant.getChildren().setAll(root);
    }

    @FXML
    private void AfficherProfil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilParent.fxml"));
        Parent root = loader.load();
        ProfilParentController e = loader.getController();
        affEnfant.getChildren().setAll(root);
        
    }

    @FXML
    private void ConsulterEvent(ActionEvent event) {
    }

    @FXML
    private void Panier(ActionEvent event) {
    }

    @FXML
    private void select(ActionEvent event) {
        
        ServiceEnfant services = new ServiceEnfant();
        String ee=com.getSelectionModel().getSelectedItem();
        
        Enfant EnfantSelected=services.findEnfant(ee);
        System.out.println(EnfantSelected);
        nomE.setText(EnfantSelected.getNom());
        prenomE.setText(EnfantSelected.getPrenom());
        AgeE.setText(String.valueOf(EnfantSelected.getAge()));
        VaccinE.setText(EnfantSelected.getVaccin());
        AllergieE.setText(EnfantSelected.getAlergie());
    }


   
    
}
