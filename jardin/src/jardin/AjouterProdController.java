/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import entitie.Produit;
import Service.serviceProduit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;




 
public class AjouterProdController implements Initializable {
    @FXML
   private TextField nom_prod;
   @FXML
   private TextField prixprod;
    @FXML
   private TextField qtep;
   
    @FXML
    private AnchorPane adash;
    @FXML
    private Button button1;
    @FXML
    private Button imp_img;
    @FXML 
    private ImageView imgv;
    public String pathh;

    /**
     * Initializes the controller class.
     */
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
    private void handleButtonAction(ActionEvent event) throws IOException {
        try {
            String nomProduit = nom_prod.getText();
            String prixProd = prixprod.getText();
            String qte = qtep.getText();
            String imgprod = imp_img.getText();
            int qt=Integer.parseInt(qte);
            int px=Integer.parseInt(prixProd);

            serviceProduit sp = new serviceProduit();
            Produit p = new Produit(nomProduit, px, pathh,qt);
            
            sp.ajouterproduit(p);
            
            FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("dashboard_1.fxml"));
            Parent root = loader.load();
            
            adash.getChildren().setAll(root);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    
        //System.out.println("You clicked me!");
        //label.setText("Produit Ajouté!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
