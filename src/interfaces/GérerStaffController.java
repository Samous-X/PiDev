/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entities.Jardin;
import Entities.Staff;
import Service.ServiceJardin;
import Service.ServiceStaff;
import com.itextpdf.text.DocumentException;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dora
 */
public class GérerStaffController implements Initializable {
    @FXML
    private ImageView logo;
   
    @FXML
    private TableView<Staff> membres;
    
    private List<Staff> liststaff;//retourner liste de la select
    private ObservableList<Staff> ObservablelisteJardin;//pour la table view
   @FXML
   private Button pdf;
    @FXML
    private ImageView back;
   
    @FXML
    private TableColumn<Staff, String> tbnom;
    @FXML
    private TableColumn <Staff, String>tbprenom;
    @FXML
    private TableColumn<Staff, String> tbposte;
       @FXML
    private TableColumn<Staff, String> tbstatus;
    @FXML
  
    private Button modif;
    @FXML
    private Button supp;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfIdl;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfPoste;
    
    @FXML
    private ComboBox<String> status;
    List<String> listestatus = new ArrayList<String>();
    ObservableList<String> observableListstatus;
    
    //AJout 
    @FXML
    private TextField tanom;
     @FXML
    private TextField taprenom;
      @FXML
    private TextField taPoste;
     
      @FXML
    private ComboBox<String> statusa;
    List<String> listestatusa = new ArrayList<String>();
    ObservableList<String> observableListstatusa;
    @FXML
    private Button btnAjout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         listestatusa.add("Actif ");
        listestatusa.add("Inactif");
        
        observableListstatusa= FXCollections.observableList(listestatus);//convertir la liste des genre
        statusa.setItems(observableListstatusa);
          
        
        listestatus.add("Actif ");
        listestatus.add("Inactif");
        
        observableListstatus = FXCollections.observableList(listestatus);//convertir la liste des genre
        status.setItems(observableListstatus);
    
        // TODO
      
          tbnom.setCellValueFactory(new PropertyValueFactory<>("Nom_staff"));//nom reference pour la colonne
 
          tbprenom.setCellValueFactory(new PropertyValueFactory<>("Prenom_staff"));//reference pour la colonne
          tbposte.setCellValueFactory(new PropertyValueFactory<>("Poste"));//reference pour la colonne

           tbstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        //reference pour la colonne
          
                    ServiceStaff services = new ServiceStaff();

        try {
            liststaff = services.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(GérerStaffController.class.getName()).log(Level.SEVERE, null, ex);
        }

          ObservablelisteJardin = FXCollections.observableArrayList(liststaff);//convertir la liste des client en observable liste
          membres.setItems(ObservablelisteJardin);
    } 
     @FXML
    private void supprimerStaff(ActionEvent event) throws SQLException {
        ServiceStaff services = new ServiceStaff();
        Staff st = membres.getSelectionModel().getSelectedItem();

        if (st != null) {
 
                    services.supprimerparent(st);
                 createtableviewParent();                
           
        } else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("S'il vous plait selectionner un staff");
            alert.show();
        }
    }
      private void createtableviewParent() throws SQLException {
       ServiceStaff services = new ServiceStaff();
      
          tbnom.setCellValueFactory(new PropertyValueFactory<>("Nom_staff"));//nom reference pour la colonne
 
          tbprenom.setCellValueFactory(new PropertyValueFactory<>("Prenom_staff"));//reference pour la colonne
          tbposte.setCellValueFactory(new PropertyValueFactory<>("Poste"));//reference pour la colonne
 tbstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

          liststaff= services.readAll();
          ObservablelisteJardin = FXCollections.observableArrayList(liststaff);//convertir la liste des client en observable liste
          membres.setItems(ObservablelisteJardin);
          
          
          
          
      }
      
    @FXML
    private void modifier(ActionEvent event) throws SQLException {
    ServiceStaff services = new ServiceStaff();
    /*Staff s=new Staff();
    s.setId_staff(Integer.parseInt(tfIdl.getText()));
    s.setNom_staff(tfNom.getText());
    s.setPrenom_staff(tfPrenom.getText());
    s.setPoste(tfPoste.getText());*/
    
     int ID=Integer.parseInt(tfIdl.getText());
     String nom=tfNom.getText();
     String prenom=tfPrenom.getText();
     String poste=tfPoste.getText();
     String stat=status.getValue();
     /*if ((String.valueOf(status.getValue())).equals("Actif")) {
                       s.setStatus("Actif");
                } else {
                    s.setStatus("Inactif");
                }*/
     
     Staff staff =new Staff(ID,tbnom.getText(),tbprenom.getText(),tbposte.getText(),status.getValue());
     //Staff staff =new Staff();
     services.Update(staff,nom,prenom,poste,stat);
     createtableviewParent();
        
       
        

    } 
    @FXML
    private void select(MouseEvent event) {
        ServiceStaff services = new ServiceStaff();
        Staff st = membres.getSelectionModel().getSelectedItem();
        ComboBox cb = new ComboBox();
        tfIdl.setText(Integer.toString(st.getId_staff()));
        tfNom.setText(st.getNom_staff());
        tfPrenom.setText(st.getPrenom_staff());
        tfPoste.setText(st.getPoste());
        
        
       
    }
   /* @FXML
      private void Btnpdf(ActionEvent event) throws SQLException {
         Scene scene = new Scene(event);
        WritableImage writableImage = 
            new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
        scene.snapshot(writableImage);
         
        File file = new File("snapshot.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("snapshot saved: " + file.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(JavaFXSnapshot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        WritableImage writableImage = 
            new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
        scene.snapshot(writableImage);
         
        File file = new File("snapshot.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("snapshot saved: " + file.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(JavaFXSnapshot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      }*/

@FXML
    private void Telecharger(ActionEvent event) throws SQLException, DocumentException, IOException {
        ServiceStaff services = new ServiceStaff();
        services.FacturePdf();
    }
    @FXML
    private void Ajouter(ActionEvent event) throws SQLException {
       try{ 
       
        String n=tanom.getText();
        String d=taprenom.getText();
        String hd=taPoste.getText();
        String s=statusa.getValue();
        Staff J=new Staff(n,d,hd,s);
        ServiceStaff SJ=new ServiceStaff();
        SJ.ajouter(J);
          
               
           
                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
} 
    
        
}
    

