/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardin;

import Service.ServiceUtilisateur;
import entitie.Utilisateur;
import static jardin.InscriptionController.loadWindow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Hejer Ghariani
 */
public class LoginAdminController implements Initializable {

    @FXML
    private TextField tfNomU;
    @FXML
    private Button btnSinscrire;
    @FXML
    private Button btnConnecter;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    private Utilisateur loggedUtilisateur;
    private static LoginAdminController instance;
    public static final Map<Integer, Utilisateur> UTILISATEUR = new HashMap<>(); 
    
    public LoginAdminController() {
        instance = this;
    }

    public static LoginAdminController getInstance() {
        return instance;
    }
    
    public Utilisateur getLoggedUtilisateur() {
        return loggedUtilisateur;
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
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscrire(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouAdmin.fxml"));
        Parent root = loader.load();
        label.getScene().setRoot(root);
    }

    @FXML
    private boolean connecter(ActionEvent event) throws SQLException {
        ServiceUtilisateur myServices=new ServiceUtilisateur();
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
        else{
            Boolean pas=myServices.verifierpassword(mdp, username); 
            System.out.println("heyy");
            if (myServices.chercherUtilisateurBylogin(username) && pas==true)
            {
                if (myServices.Gettype(username).equals("admin"))
                {

                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> 
                    {
                        System.out.println("hello Admin");
                        /*************Pour Recupere ili connecter********************/
                        Utilisateur userConnecter=myServices.chercherUtilisateurByUsername(username);
                        loggedUtilisateur = Utilisateur.of(userConnecter.getId_utilisateur());
                        loadWindow(getClass().getResource("menudirecteur.fxml"), "Dashboard", null);
                        //labelusername.getScene().getWindow().hide();
                        Notifications n = Notifications.create()
                                    .title("Bienvenue")
                                    .text("Vous étes connecté en tant que Administrateur!")
                                    .graphic(null)
                                    .position(Pos.TOP_CENTER)
                                    .hideAfter(Duration.seconds(5));
                    });
                       pauseTransition.play();

                }
                if (myServices.Gettype(username).equals("directeur"))
                {

                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> 
                    {
                        System.out.println("hello Directeur");
                        /*************Pour Recupere ili connecter********************/
                        Utilisateur userConnecter=myServices.chercherUtilisateurByUsername(username);
                        loggedUtilisateur = Utilisateur.of(userConnecter.getId_utilisateur());
                        loadWindow(getClass().getResource("Acceuil.fxml"), "Dashboard", null);
                        //labelusername.getScene().getWindow().hide();
                        Notifications n = Notifications.create()
                                    .title("Bienvenue")
                                    .text("Vous étes connecté en tant que Directeur!")
                                    .graphic(null)
                                    .position(Pos.TOP_CENTER)
                                    .hideAfter(Duration.seconds(5));
                    });
                       pauseTransition.play();

                }
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
    }
    
}
