/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.publication;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import Service.ServicePublication;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutController implements Initializable {
     
@FXML
private  TextArea  texte;
@FXML
private ComboBox combo;
@FXML
private Button ajout;
@FXML
private Button rtn;
   @FXML 
           private ImageView imgv;
   public String pathh;
    @FXML
private Button importer;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().addAll("suggestion","probeme");
   
    }    
     @FXML  
     private void ajouter(ActionEvent event) {
     
     String text = texte.getText(); 
     
     String categorie = combo.getValue().toString();
     String date = java.time.LocalDate.now().toString();
   
     int score=0;
         publication p=new publication();
          
           p.setTexte(text);
           p.setCategorie(categorie);
           p.setDate(date);
           p.setImage(pathh);
         
    
           
        
    ServicePublication sp = new ServicePublication();
    //publication p = new publication(text,date,score,categorie);
     
      
    sp.ajouterPublication(p);

    }
     
     
      @FXML
    public void importer(ActionEvent event) {
        //file = fileChooser.showOpenDialog();
        //FileChooser fc = new FileChooser();
        
        //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
        //File f =fc.showOpenDialog(null);
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
    @FXML
     public void directievent(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("afficher.fxml"));
            Parent root= loader.load();
            
            AfficherController r= loader.getController();
            rtn.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     
}

