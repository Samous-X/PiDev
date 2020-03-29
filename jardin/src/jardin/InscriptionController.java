/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceParent;
import entitie.Paarent;
import Service.ServiceUtilisateur;
import entitie.Utilisateur;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    /*@FXML 
    private TextField tfNomU;*/
    @FXML
    private AnchorPane rootpane;
    @FXML 
    private Button btnSinscrire;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfNomU;
    @FXML
    private Button btnConnecter;
    @FXML
    private Button retour;
    
    private Paarent loggedParent;
    private static InscriptionController instance;
    public static final Map<Integer, Paarent> PARENTS = new HashMap<>(); 
    @FXML
    private Label label;
    
    
    
    
    public InscriptionController() {
        instance = this;
    }

    public static InscriptionController getInstance() {
        return instance;
    }
    
    public Paarent getLoggedParent() {
        return loggedParent;
    }
    
    
    
     public TextField getLabelusername() {
        return tfNomU;
    }

    public void setLabelusername(String labelusername) {
        this.tfNomU.setText(labelusername);
    }

    public PasswordField getLabelpassword() {
        return tfPassword;
    }

    public void setLabelpassword(String labelpassword) {
        this.tfPassword.setText(labelpassword);
    }
    
    
    @FXML
    private void inscrire(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterParent.fxml"));
        Parent root = loader.load();
        AjouterParentController e = loader.getController();
        label.getScene().setRoot(root);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public static void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
             Scene scene = new Scene(parent);
        
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }      

    @FXML
    private boolean connecter(ActionEvent event) throws IOException {
        
        
        
        ServiceParent myServices=new ServiceParent();
        String mdp=tfPassword.getText();
        String username=tfNomU.getText();
        
 
         String errorMessage = "";

        if (username == null || username.length() == 0) 
        {
            errorMessage += "Login invalide \n";
        }

        if (mdp  == null || mdp.length() == 0) 
        {
            errorMessage += "Mot de passe invalide \n";
        }

        if (errorMessage.length() != 0) 
        {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error valeur");
            alert.setHeaderText("Invalide input");
            alert.setContentText(errorMessage);
            alert.show();
        } 
        else 
        {
            Boolean pas=myServices.verifierpassword(mdp, username); 
            System.out.println("heyy");
            if (myServices.chercherParentBylogin(username) && pas==true) 
                //if (myServices.Gettype(username).equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")) 
                {
                //imgProgress.setVisible(true);
                
                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> 
                    {
                        System.out.println("hello Parent");
                        /*************Pour Recupere ili connecter********************/
                        Paarent parentConnecter=myServices.chercherParentByUsername(username);
                        loggedParent = Paarent.of(parentConnecter.getId_utilisateur());
                        loadWindow(getClass().getResource("espaceparent.fxml"), "Dashboard", null);
                        //labelusername.getScene().getWindow().hide();
                        Notifications n = Notifications.create()
                                    .title("Bienvenue")
                                    .text("Vous étes connecté en tant que Parent!")
                                    .graphic(null)
                                    .position(Pos.TOP_CENTER)
                                    .hideAfter(Duration.seconds(5));
                    });
                   pauseTransition.play();
                   return true;
                }
            else{
       
              Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Username ou mot de passe invalide!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                n.showInformation();
           
               return false;
                }
       
        }
         return true;
        
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuParent.fxml"));
        javafx.scene.Paarent root = loader.load();
        MenuParentController e = loader.getController();
        rootpane.getChildren().setAll(root);*/
        
    }


    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("acceuil.fxml"));
        Parent root = loader.load();
        AcceuilController e = loader.getController();
        //e.setYarab(id);
        
        rootpane.getChildren().setAll(root);
    }
    
}
