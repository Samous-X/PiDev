/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import static jardin.AfficherController.recupPublication;
import entitie.publication;
import entitie.comment;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Clock;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import Service.ServicePublication;
import Service.serviceComment;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CommentsController implements Initializable {

   static comment recupComment;
    @FXML
private TableView <comment> tab;
    @FXML
private TextArea zone;
@FXML
private TextField zonec;
@FXML
private TextField zonec2;
@FXML
private TableColumn <comment,String> datec;

@FXML
 private TableColumn<comment,String> textec;
Button btn;
@FXML
Button modif;
@FXML
Button edit;
@FXML
Button ajout;
@FXML
Button rtn;
private List<comment> listcom;
private ObservableList<comment> dataComment ;
@FXML
 
    private ImageView  imagex;

   


 
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        zonec2.setVisible(false);
        setCellValue ();
        textec.setCellValueFactory(new PropertyValueFactory<>("textec"));
        datec.setCellValueFactory(new PropertyValueFactory<>("datec"));
         //id_parent.setCellValueFactory(new PropertyValueFactory<>("id_parent"));
serviceComment srv =new serviceComment();
publication PUB=AfficherController.recupPublication;
 
zone.setText(PUB.getTexte());
String idd=PUB.getTexte();
 Image image = new Image("file:/"+AfficherController.recupPublication.getImage());
                imagex.setImage(image);
      System.out.println(AfficherController.recupPublication.getImage());

          try {
    listcom = srv.showpls(idd);

    } catch (SQLException ex) {
        Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
      dataComment =FXCollections.observableArrayList(listcom);
    tab.setItems(dataComment);
     addButtonListeToTable();
    } 
    public void reload(){
        setCellValue ();
        textec.setCellValueFactory(new PropertyValueFactory<>("textec"));
        datec.setCellValueFactory(new PropertyValueFactory<>("datec"));
        
serviceComment srv =new serviceComment();
publication PUB=AfficherController.recupPublication;
 
zone.setText(PUB.getTexte());
String idd=PUB.getTexte();
 Image image = new Image("file:/"+AfficherController.recupPublication.getImage());
                imagex.setImage(image);
      System.out.println(AfficherController.recupPublication.getImage());

          try {
    listcom = srv.showpls(idd);

    } catch (SQLException ex) {
        Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
      dataComment =FXCollections.observableArrayList(listcom);
    tab.setItems(dataComment);
     addButtonListeToTable();
    } 
    @FXML  
     private void modifier(ActionEvent event) {
     
     String text = zone.getText();
     publication PUB=AfficherController.recupPublication;
        zone.setText(PUB.getTexte());
        String idd=PUB.getTexte();
       
    ServicePublication sp = new ServicePublication();
   sp.modifierPublication(text, idd); 
    recupPublication.setTexte(text);
       reload();
  
    }
     @FXML
      public void ajout(ActionEvent event) {
        
     
     String text = zonec.getText();
     String date = java.time.LocalDate.now().toString();
     String texte = recupPublication.getTexte();
 
    
    serviceComment sc = new serviceComment();
    comment co = new comment(text,date,texte);
    sc.ajoutercomment(co);
    reload();
          
          
    }
     public void setCellValue ()
  {
        
      tab.setOnMouseClicked(new EventHandler<MouseEvent>(){
          @Override
          public void handle(MouseEvent event) {
              comment e= tab.getItems().get(tab.getSelectionModel().getSelectedIndex());
              zonec.setText(e.getTextec());
              zonec2.setText(e.getTextec()); 
              
          }
          
          
      });
  
  }
     @FXML
     private void modifierC(ActionEvent event)
     {
     
     String text2 = zonec.getText();
     String text3 = zonec2.getText();

        serviceComment srv=new serviceComment();
        srv.modifierComment(text2, text3);
        reload();
        
     }
    private void addButtonListeToTable() {
        TableColumn<comment, Void> colBtn = new TableColumn("supprimer");

        Callback<TableColumn<comment, Void>, TableCell<comment, Void>> cellFactory = new Callback<TableColumn<comment, Void>, TableCell<comment, Void>>() {
            @Override
            public TableCell<comment, Void> call(final TableColumn<comment, Void> param) {
                final TableCell<comment, Void> cell = new TableCell<comment, Void>() {

                    private final Button btn = new Button("delete");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            recupComment=getTableView().getItems().get(getIndex());
                             String idd=recupComment.getTextec();
                             System.err.println(idd);
                             serviceComment srv=new serviceComment();
                            
                            srv.supprimerComment(idd);
                            reload();
                    
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

        tab.getColumns().add(colBtn);

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
    
