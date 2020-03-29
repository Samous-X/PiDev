/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Utils.DataBase;
import entitie.Directeur;
import java.awt.AWTException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hejer Ghariani
 */
public class ServiceUtilisateur {
    private Statement ste;
    Connection con = DataBase.getInstance().getConnection();
    
    
    public void ajouterUtilisateur(Directeur u) throws AWTException  {
        
        try 
        {
            Statement st=con.createStatement();
            String req="INSERT INTO `utilisateur` (`id_utilisateur`, `nom`,`email`,`tel`,`login`, `password`,  `role`) "
                    + "VALUES (NULL, '" + u.getNom() + "',  '" +u.getEmail() + "', '" + u.getTel() + "', '" + u.getLogin() + "', '" + u.getPassword() + "', 'directeur');";
            
            st.executeUpdate(req);
            
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void modifierutilisateur (Directeur u,String nom)
    {
        try {
            PreparedStatement pt= con.prepareStatement("UPDATE `utilisateur` SET `nom` = ? WHERE `utilisateur`.`id_utilisateur` = ? ;");
            pt.setString(1,nom);
            pt.setInt(2,u.getId_utilisateur());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public void supprimerUtilisateur(Directeur u)
    {
        try {
            PreparedStatement pt =con.prepareStatement("DELETE FROM `utilisateur` WHERE `utilisateur`.`id_utilisateur` = ? ;" );
            pt.setInt(1,u.getId_utilisateur());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public List<Directeur> readAll() throws SQLException {
    List<Directeur> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT id_utilisateur, nom, email, tel, login, password FROM `utilisateur` where role='directeur'");
     while (rs.next()) {                
               int id_utilisateur=rs.getInt("id_utilisateur");
               String nom=rs.getString("nom");
               String password=rs.getString("password");
               String email=rs.getString("email");
               int tel=rs.getInt("tel");
               String Login=rs.getString("login");
               Directeur u=new Directeur(id_utilisateur, nom,email,password, tel,Login);
     arr.add(u);
     }
    return arr;
    }
    public String Gettype(String s) throws SQLException {
        
        String s1 = "";
        String req = "select role from utilisateur where login =?";
        PreparedStatement preparedStatement;
        try {
          preparedStatement = DataBase.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("role");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }
    
    
     public Boolean verifierpassword(String pword, String uname) {
        String s1 = "";
        String req = "Select id_utilisateur from utilisateur where login= ? and password= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DataBase.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString(1);
               
                  //System.out.println(uname);
                  System.out.println(s1);  
                  
                    return true;
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
     public boolean chercherUtilisateurBylogin(String s) {
        Directeur directeur = null;
        String req = "select * from utilisateur where login =?";
        PreparedStatement preparedStatement;
        try {
         preparedStatement = DataBase.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  directeur = new Directeur(
                        resultSet.getInt("id_utilisateur"),
                        resultSet.getString("nom"),
                          resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                          resultSet.getString("role"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (directeur == null) {
            return false;
        }
        return true;
    }
     public Directeur chercherUtilisateurByUsername(String s) {
        Directeur directeur = null;
     
        PreparedStatement preparedStatement;
        try {
         preparedStatement = DataBase.getInstance().getConnection().prepareStatement("select * from utilisateur where login =?");
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  directeur = new Directeur(
                        resultSet.getInt("id_utilisateur"),
                        resultSet.getString("nom"),
                          resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                          resultSet.getString("role"));
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (directeur == null) {
            return null;
        }
        return directeur;
    }
     public Directeur chercherUtilisateurByid(Integer r) {
        Directeur directeur = null;
        String req = "select * from utilisateur where id_utilisateur =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DataBase.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                directeur = new Directeur(
                        resultSet.getInt("id_utilisateur"),
                        resultSet.getString("nom"),
                          resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                          resultSet.getString("role"));
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return directeur;
    }
     
}

