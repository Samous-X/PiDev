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
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import Service.ServicePublication;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherController implements Initializable {

    
 static publication recupPublication;
@FXML
private TextField supp;
@FXML
//private TableColumn <publication,String> id;
//@FXML
private TableColumn <publication,String> texte;
@FXML
private TableColumn <publication,String> date;
@FXML
private TableColumn <publication,Integer> score;
@FXML
private TableColumn <publication,String> categorie;
@FXML
private TableColumn <publication,String> image;
@FXML
private TableColumn <publication,String> nom;
@FXML
private Button ajouti;
@FXML
private TableView <publication> pubb;
private List<publication> listpub;
private ObservableList<publication> dataPublication ;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        supp.setVisible(false);
         setCellValue();
        //id.setCellValueFactory(new PropertyValueFactory<>("id"));
        texte.setCellValueFactory(new PropertyValueFactory<>("texte"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ServicePublication srv1Publication =new ServicePublication();
               srv1Publication.deletebad();

      
    try {
listpub = srv1Publication.showpls();

    } catch (SQLException ex) {
        Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
      dataPublication =FXCollections.observableArrayList(listpub);
      pubb.setItems(dataPublication);
        addButtonListeToTable();
    }    
    public void load(){
      setCellValue();
        //id.setCellValueFactory(new PropertyValueFactory<>("id"));
        texte.setCellValueFactory(new PropertyValueFactory<>("texte"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ServicePublication srv1Publication =new ServicePublication();
               srv1Publication.deletebad();

      
    try {
listpub = srv1Publication.showpls();

    } catch (SQLException ex) {
        Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
      dataPublication =FXCollections.observableArrayList(listpub);
      pubb.setItems(dataPublication);
        addButtonListeToTable();
    }
    
    @FXML
     public void directievent(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ajout.fxml"));
            Parent root= loader.load();
            
            AjoutController r= loader.getController();
            ajouti.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
public void setCellValue ()
  {
        
      pubb.setOnMouseClicked(new EventHandler<MouseEvent>(){
          @Override
          public void handle(MouseEvent event) {
              publication e= pubb.getItems().get(pubb.getSelectionModel().getSelectedIndex());
              supp.setText(e.getTexte());
           
          }
          
          
      });
  
  }
    @FXML
     public void validersupp(ActionEvent event) 
  {
       
       
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Suppresion");
                            alert.setHeaderText(null);
                            alert.setContentText("voulez vous vraiment supprimer cette publication ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            
                            if (action.get() == ButtonType.OK)
                            {ServicePublication srv=new ServicePublication();
                            
                            
                             srv.supprimerPublication(supp.getText());
                              load();
                               
                  
          }
                           
          
                    }

    @FXML
       public void like(ActionEvent event) 
  {
       
       
      
                            ServicePublication srv=new ServicePublication();
                            
                            
                                srv.upvote(supp.getText());
                                load();
                           
                                
                                        
                             
                                
          }//testAff(event
    @FXML
            public void dislike(ActionEvent event) 
  {
       
       
      
                            ServicePublication srv=new ServicePublication();
                            
                            
                                srv.downvote(supp.getText());
                                load();
                     
          }
            
            
   private void addButtonListeToTable() {
        TableColumn<publication, Void> colBtn = new TableColumn("view comments");

        Callback<TableColumn<publication, Void>, TableCell<publication, Void>> cellFactory = new Callback<TableColumn<publication, Void>, TableCell<publication, Void>>() {
            @Override
            public TableCell<publication, Void> call(final TableColumn<publication, Void> param) {
                final TableCell<publication, Void> cell = new TableCell<publication, Void>() {

                    private final Button btn = new Button("voir commentaires");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            recupPublication=getTableView().getItems().get(getIndex());
                            
                            try {

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("comments.fxml"));
                                Parent root = loader.load();
                                CommentsController rc = loader.getController();
                               btn.getScene().setRoot(root);

                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());

                            }

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        pubb.getColumns().add(colBtn);

    }         
                    }

