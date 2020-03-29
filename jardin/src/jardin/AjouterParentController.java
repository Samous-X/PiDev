/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceParent;
import entitie.Mailing;
import entitie.Paarent;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */



public class AjouterParentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane inscriptionPane;
    @FXML 
    private TextField tfnom;
    @FXML 
    private TextField tfprenom;
    @FXML 
    private TextField tfemail;
    @FXML 
    private TextField tftel;
    @FXML
    private Button btEnvoyer;
    @FXML
    private TextField tfcin;
    @FXML
    private Button btnAttach;
    String path;
    File selectedFile;
    private boolean verificationImage;
    @FXML
    private ImageView ImporterImage;
    @FXML
    private TextField tfPhoto;
    @FXML
    private void ajouter(ActionEvent event) throws IOException, AWTException {
         String cin = tfcin.getText();
            String EmailP = tfemail.getText();
            String TEL=tftel.getText();
            int tel=Integer.parseInt(TEL);
            int CIN=Integer.parseInt(cin); 
            ServiceParent sp = new ServiceParent();
            Paarent p1=new Paarent();
            p1.setNom(tfnom.getText());
            p1.setPrenom(tfprenom.getText());
            p1.setCin(CIN);
            p1.setEmail(EmailP);
            p1.setPhoto(path);
            p1.setLogin(tfemail.getText());
            p1.setPassword(tfcin.getText());
          
            sp.ajouter(p1);
            String to = "hejer.gharianii@gmail.com";
            String subject = "Confirmation d'inscription";
            String message = "Bienvenu " + tfprenom.getText() + " " + tfnom.getText() + " dans notre application voici votre mot de passe  " + tfcin.getText() + " et votre Username "+tfemail.getText();
            String usermail = "hejer.gharianii@gmail.com";
            String passmail = "jerjer2511";
            //Mailing.send(to, subject, message, usermail, passmail);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inscription.fxml"));
            javafx.scene.Parent root = loader.load();
            InscriptionController e = loader.getController();
            inscriptionPane.getChildren().setAll(root);
            }
    
        

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Attach(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));//importation de l'image ou
        fc.setTitle("Veuillez choisir l'image"); //titre de la
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            path = selectedFile.getName();
//                path = selectedFile.toURI().toURL().toExternalForm();
          Image image = new Image(selectedFile.toURI().toString());
           ImporterImage.setImage(image) ;
            tfPhoto.setText(path);
            //labelImage.setText("Cliquez sur le button pour la changer!");
              if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}
    }
    
}
}
