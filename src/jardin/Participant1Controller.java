/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import com.itextpdf.text.DocumentException;
import entitie.event;
import entitie.participant;
import entitie.partlist;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Service.eventService;
import Service.participantService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class Participant1Controller implements Initializable {

    @FXML
    private TableView<partlist> tableparticipant;
    @FXML
    private TableColumn<participant, String> nom;
    @FXML
    private TableColumn<participant,String > prenom;
    @FXML
    private TableColumn<participant, Integer> npart;
    @FXML
    private TableColumn<participant, Integer> tel;
    @FXML
    private TableColumn<participant, String> mail;
    @FXML
    private Label yarab;
    @FXML
    private Button refresh;
    @FXML
    private Button retour;
    @FXML
    private AnchorPane rootpane2;
    @FXML
    private Button supprimer_participant;
    @FXML
    private TableColumn<participant, Integer> id;
    @FXML
    private Button imprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      /* Integer.parseInt(id);
        participantService ent;
        try {
            ent = new participantService();
       Enta =  ent.listparticipant(Integer.parseInt(yarab.getText()));
       ObservableList<partlist> obs = FXCollections.observableArrayList();
       while (Enta.next())
       {
           
         obs.add(new partlist(Enta.getString("nom"),Enta.getString("prenom"),Enta.getInt("tel"),Enta.getInt("nombre_enfant"),Enta.getString("mail")));
           
       }
*/
       id.setCellValueFactory(new PropertyValueFactory<participant, Integer>("id_participant"));
       nom.setCellValueFactory(new PropertyValueFactory<participant, String>("nom"));
       prenom.setCellValueFactory(new PropertyValueFactory<participant, String>("prenom"));
       npart.setCellValueFactory(new PropertyValueFactory<participant, Integer>("nombre_enfant"));
       tel.setCellValueFactory(new PropertyValueFactory<participant, Integer>("tel"));
       mail.setCellValueFactory(new PropertyValueFactory<participant, String>("mail"));
       
    /*   
       
       tableparticipant.setItems(obs);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Participant1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Participant1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
  
           
       */     
       
    }    

    public Label getYarab() {
        return yarab;
    }

    public void setYarab(int yarab) {
        this.yarab.setText(Integer.toString(yarab));
    }

    @FXML
    private void refresh(ActionEvent event) {
        try {
            participantService ent;
            
            ent = new participantService();
            
            ObservableList<partlist> obs = FXCollections.observableArrayList();
            obs.addAll(ent.listparticipant(Integer.parseInt(yarab.getText())));
            tableparticipant.setItems(obs);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Participant1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
           
        FXMLLoader loader = new FXMLLoader(getClass().getResource("evenement.fxml"));
        Parent root = loader.load();
        
        rootpane2.getChildren().setAll(root);
    }

    @FXML
    private void supprimer_participant(ActionEvent event) throws ClassNotFoundException {
        partlist Aem = tableparticipant.getSelectionModel().getSelectedItem();
        participantService SEnt = new participantService();
        int id = Aem.getId_participant();
     
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation Dialog");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Vous voulez vraiment supprimer participant");
                                    Optional<ButtonType> action = alert.showAndWait();
                                    if (action.get() == ButtonType.OK) {
                                        
                                                if (id != 0) {
                                           SEnt.supprimerparticipant(id);
                                                }
                                    }
    }

    @FXML
    private void imprimer(ActionEvent event) throws SQLException, DocumentException, IOException {
        try {
   
            participantService SEnt = new participantService();
            SEnt.FacturePdf(Integer.parseInt(yarab.getText()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Participant1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
    }
 
    
   
    
}
