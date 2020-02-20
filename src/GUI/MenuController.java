/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Bus;
import Services.ServiceBus;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Services.Service_generer_Qr_code;
import Services.Service_mail;


/**
 * FXML Controller class
 *
 * @author chadi
 */
public class MenuController implements Initializable {

    @FXML
    private TextField imm;
    @FXML
    private ComboBox Ligne;
    @FXML
    private TextField hh;
    @FXML
    private TextField mm;
    @FXML
    private ComboBox chauffeur;
    @FXML
    private TextField nbrplace;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private Button vider;
    @FXML 
           private ImageView imgv;
   public String pathh;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      ServiceBus srv=new ServiceBus();
    ObservableList obList2 = FXCollections.observableList(srv.displaysm());
        chauffeur.getItems().clear();
        chauffeur.setItems(obList2);
        Ligne.getItems().addAll("Ligne A","Ligne B","Ligne C");
    } 
    
    @FXML
    public void insertdata (ActionEvent event)
            
    {
        Service_generer_Qr_code Q= new Service_generer_Qr_code();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Ajout Bus");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous vraiment Ajouter Cette Bus ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK){
        String imma = imm.getText();
        String heure=hh.getText()+""+mm.getText();
        String chauff =""+chauffeur.getValue();
        int nbrm=Integer.parseInt(nbrplace.getText());
        String Lignee =""+Ligne.getValue();
        Bus b = new Bus();
        b.setImmat(imma);
        b.setChauffeur(chauff);
        b.setHoraire(heure);
        b.setNbrplace(nbrm);
        b.setLigne(Lignee);
        b.setImage(pathh);
        ServiceBus srv =new ServiceBus();
        srv.ajouterbus(b);

        }
    }
    @FXML
      public void directAffi(ActionEvent event) {
       // get a handle to the stage
    Stage stage = (Stage) annuler.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
       public void vider ()
    {
        imm.clear();
        hh.clear();
        mm.clear();
        chauffeur.setValue(null);
        nbrplace.clear();
         Ligne.setValue(null);
        
    }
       public void importer(ActionEvent event) {
        
        final FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(//
               //
              new FileChooser.ExtensionFilter("JPG", "*.jpg"), //
              new FileChooser.ExtensionFilter("PNG", "*.png"));
           String path = fileChooser.showOpenDialog(null).getAbsolutePath();
        
        path = path.replace('\\','/');
        pathh=path;
        System.out.println(path);
        Image img = new Image("file:///"+path);
        
        imgv.setImage(img);
        
        //Image img = new Image(f.getAbsolutePath());
        //if (f != null){
        //   l.setText("selected file" + f.getAbsolutePath());
           //imgv.setImage(img);
        //}
        
        
   }
    
}
