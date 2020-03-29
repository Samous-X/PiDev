/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import com.jfoenix.controls.JFXTimePicker;
import static com.jfoenix.svg.SVGGlyphLoader.clear;
import entitie.event;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.type;
import Service.TrayIconDemo;
import Service.eventService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class EvenementController implements Initializable {
ObservableList<event> obs;
    @FXML
    private Button ajouter_event;
    @FXML
    private Button modifier_event;
    @FXML
    private Button supprimer_event;
    @FXML
    private TableView<event> tablevent;
    @FXML
    private TableColumn<event,String> titre;
    @FXML
    private TableColumn<event,String> description;
    @FXML
    private TableColumn<event,Date> date;
    @FXML
    private TableColumn<event, Time> heured;
    @FXML
    private TableColumn<event, Time> heuref;
    @FXML
    private TableColumn<event, Float> prixevent;
    @FXML
    private TextField ctitre;
    
    @FXML
    private JFXTimePicker cheured;
    @FXML
    private TextArea cdesc;
    @FXML
    private DatePicker cdate;
    @FXML
    private  JFXTimePicker cheuref;
    @FXML
    private TextField cprixevent;
    @FXML
    private TextField search;
    @FXML
    private Button btn_clear;
    @FXML
    private Button afficher_participant;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private TableColumn<event,Integer> id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
       
  eventService ent;
  modifier_event.setDisable(true);
  btn_clear.setDisable(true);
            supprimer_event.setDisable(true);
            
        try {
            ent = new eventService();
      ResultSet Enta =  ent.afficherevent(22);
      ObservableList<event> obs = FXCollections.observableArrayList();
       while (Enta.next())
       {
           
         obs.add(new event(Enta.getInt("id_event"),Enta.getString("titre"),Enta.getString("description"),Enta.getDate("date"),Enta.getTime("heured"),Enta.getTime("heuref"),Enta.getFloat("prix_event")));
           
       }
       
           titre.setCellValueFactory(new PropertyValueFactory<event, String>("nom_event"));
            description.setCellValueFactory(new PropertyValueFactory<event, String>("desc"));
            date.setCellValueFactory(new PropertyValueFactory<event, Date>("date_event"));
            
            heured.setCellValueFactory(new PropertyValueFactory<event, Time>("heureD"));
            heuref.setCellValueFactory(new PropertyValueFactory<event, Time>("heureF"));
            prixevent.setCellValueFactory(new PropertyValueFactory<event, Float>("prix_event"));
                   id.setCellValueFactory(new PropertyValueFactory<event, Integer>("id_event"));
            
       
       tablevent.setItems(obs);
        FilteredList<event> filteredData = new FilteredList<>(obs, b -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(aff -> {
                    // If filter text is empty, display all persons.

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (aff.getNom_event().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches first name.
                    } else {
                        return false; // Does not match.
                    }
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<event> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            // 	  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(tablevent.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tablevent.setItems(sortedData);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
       
    }    
   
    @FXML
    private void ajouter_event(ActionEvent event) throws AWTException, ClassNotFoundException {
        eventService P = new eventService();
              
    java.sql.Date javaSqlDate = java.sql.Date.valueOf(cdate.getValue());
    java.sql.Time javaSqlTime = java.sql.Time.valueOf(cheured.getValue());
    java.sql.Time javaSqlTime2 = java.sql.Time.valueOf(cheuref.getValue());
    Float prix=Float.parseFloat(cprixevent.getText());
     
        event a = new event (ctitre.getText(),cdesc.getText(),javaSqlDate,javaSqlTime,javaSqlTime2, (float) prix,22);
        P.ajouterevent(a);
         if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
        
        
        load();
                    chercher();

        
    }

public void load()
{
   eventService ent;
        try {
            ent = new eventService();
      ResultSet Enta =  ent.afficherevent(22);
       ObservableList<event> obs = FXCollections.observableArrayList();
       while (Enta.next())
       {
           
         obs.add(new event(Enta.getInt("id_event"),Enta.getString("titre"),Enta.getString("description"),Enta.getDate("date"),Enta.getTime("heured"),Enta.getTime("heuref"),Enta.getFloat("prix_event")));
           
       }
       
           titre.setCellValueFactory(new PropertyValueFactory<event, String>("nom_event"));
            description.setCellValueFactory(new PropertyValueFactory<event, String>("desc"));
            date.setCellValueFactory(new PropertyValueFactory<event, Date>("date_event"));
            
            heured.setCellValueFactory(new PropertyValueFactory<event, Time>("heureD"));
            heuref.setCellValueFactory(new PropertyValueFactory<event, Time>("heureF"));
            prixevent.setCellValueFactory(new PropertyValueFactory<event, Float>("prix_event"));
             id.setCellValueFactory(new PropertyValueFactory<event, Integer>("id_event"));
            
       
       tablevent.setItems(obs);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        ctitre.clear();
                    
                    cprixevent.clear();
                    cdesc.clear();
                    cdate.getEditor().clear();
                    cheuref.getEditor().clear();
                    cheured.getEditor().clear();
                    
                     chercher();
}

    @FXML
    private void supprimer_event(ActionEvent event) throws ClassNotFoundException {
    event Aem = tablevent.getSelectionModel().getSelectedItem();
        eventService SEnt = new eventService();
        int id = Aem.getId_event();
     
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation Dialog");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Vous voulez vraiment supprimer Cette evenement");
                                    Optional<ButtonType> action = alert.showAndWait();
                                    if (action.get() == ButtonType.OK) {
                                        
                                                if (id != 0) {
                                           SEnt.supprimerevent(id);
                                                }
                                    }
        load();
                    chercher();

       
        
    }

    @FXML
    private void modifier_evenement(ActionEvent event) throws ClassNotFoundException {
    event Aem = tablevent.getSelectionModel().getSelectedItem();
        eventService SEnt = new eventService();
        int id = Aem.getId_event();
        java.sql.Date javaSqlDate = java.sql.Date.valueOf(cdate.getValue());
    java.sql.Time javaSqlTime = java.sql.Time.valueOf(cheured.getValue());
    java.sql.Time javaSqlTime2 = java.sql.Time.valueOf(cheuref.getValue());
     float prix=Float.parseFloat(cprixevent.getText());
        event a = new event(id, ctitre.getText(),cdesc.getText(),javaSqlDate,javaSqlTime,javaSqlTime2, (float) prix);
        SEnt.modifierevent(a);

        
                     load();
                    chercher();
                    ctitre.clear();
                    
                    cprixevent.clear();
                    cdesc.clear();
                    cdate.getEditor().clear();
                    cheuref.getEditor().clear();
                    cheured.getEditor().clear();
                    
                    

    }

    @FXML
    private void get_selected(MouseEvent event) {
    event Aem = tablevent.getSelectionModel().getSelectedItem();
   
        if (Aem == null) {
            JOptionPane.showMessageDialog(null, "Nothing selected");
            btn_clear.setDisable(true);
            supprimer_event.setDisable(true);
            modifier_event.setDisable(true);
        } else {
            btn_clear.setDisable(false);
            modifier_event.setDisable(false);
            supprimer_event.setDisable(false);
             cprixevent.setText(Float.toString(Aem.getPrix_event()));   
            ctitre.setText(Aem.getNom_event());
            
            cdesc.setText(Aem.getDesc());
            cdate.setValue(Aem.getDate_event().toLocalDate());
            
            cheured.setValue(Aem.getHeureD().toLocalTime());
            cheuref.setValue(Aem.getHeureF().toLocalTime());
            
            chercher();
                        

        }

    }
  
    public void chercher() {
        FilteredList<event> filteredData = new FilteredList<>(obs, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(aff -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (aff.getNom_event().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<event> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tablevent.comparatorProperty());
        tablevent.setItems(sortedData);

        // 5. Add sorted (and filtered) data to the table.
    }

    @FXML
    private void clear_field(ActionEvent event) {
        ctitre.clear();
                    cprixevent.clear();
                    cdesc.clear();
                    cdate.getEditor().clear();
                    cheuref.getEditor().clear();
                    cheured.getEditor().clear();
    }

    @FXML
    private void afficher_participant(ActionEvent event)  {
    try {
     event Aem = tablevent.getSelectionModel().getSelectedItem();
        int id = Aem.getId_event();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("participant1.fxml"));
        Parent root = loader.load();
        Participant1Controller p = loader.getController();
        p.setYarab(id);
        rootpane.getChildren().setAll(root);
        chercher();
    } catch (IOException ex) {
        Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
