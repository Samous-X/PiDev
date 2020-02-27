/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import entitie.Paarent;
import java.awt.AWTException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Notification;

/**
 *
 * @author Hejer Ghariani
 */
public class ServiceParent {
    
    private Statement ste;
        Connection con = DataBase.getInstance().getConnection();
    
    
    public void ajouter(Paarent p) throws AWTException  {
        
        try 
        {
            Statement st=con.createStatement();
            String req="INSERT INTO `jardin`.`parent` (`id_parent`, `nom`, `prenom`,`cin`, `email`, `photo`, `tel`, `login`, `password`, `etat`,`created_on`) "
                    + "VALUES (NULL, '" + p.getNom() + "', '" + p.getPrenom() + "','" + p.getCin() + "', '" +p.getEmail() + "', '" + p.getPhoto() + "', '" + p.getTel() + "', '" +p.getEmail() + "', '" + p.getCin() + "','1',CURRENT_TIMESTAMP);";
            
            st.executeUpdate(req);
            IconNotif td = new IconNotif();
            td.displayTray();
            
            
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceParent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void modifierparent (Paarent p,String nom)
    {
        try {;
            PreparedStatement pt= con.prepareStatement("UPDATE `parent` SET `nom` = ? WHERE `parent`.`id_parent` = ? ;");
            pt.setString(1,nom);
            pt.setInt(2,p.getId_parent());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void modifierCoordonnésparent (Paarent p,String login,String password)
    {
        try {
            PreparedStatement pt= con.prepareStatement("UPDATE `parent` SET `login` = ? ,`password` = ? WHERE `id_parent` = ? ;");
            pt.setString(1,login);
            pt.setString(2,password);
            pt.setInt(3,p.getId_parent());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public void supprimerparent(Paarent p)
    {
        try {
            PreparedStatement pt =con.prepareStatement("DELETE FROM `parent` WHERE `parent`.`id_parent` = ? ;" );
            pt.setInt(1,p.getId_parent());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public List<Paarent> readAll() throws SQLException {
    List<Paarent> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select id_parent, nom, prenom,cin, email, photo, tel, login, password FROM parent WHERE etat=1 AND YEAR(created_on)=YEAR(CURRENT_DATE) ORDER BY nom , prenom ASC");
     while (rs.next()) {                
               int id_parent=rs.getInt("id_parent");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               int cin=rs.getInt("cin");
               String email=rs.getString("email");
               String photo=rs.getString("photo");
               int tel=rs.getInt("tel");
               String login=rs.getString("login");
               String password=rs.getString("password");
               
               
               Paarent p=new Paarent(id_parent,nom,prenom,cin,email,photo,tel,login,password);
     arr.add(p);
     }
    return arr;
    }
    
    public boolean chercherParentBylogin(String s) {
        Paarent parent = null;
        String req = "select * from parent where login =?";
        PreparedStatement preparedStatement;
        try {
         preparedStatement = DataBase.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  parent = new Paarent(
                        resultSet.getInt("id_parent"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("cin"),
                        resultSet.getString("email"),
                        resultSet.getString("photo"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("etat"),
                        resultSet.getDate("created_on"));
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }
    public Paarent chercherParentByUsername(String s) {
        Paarent parent = null;
     
        PreparedStatement preparedStatement;
        try {
         preparedStatement = DataBase.getInstance().getConnection().prepareStatement("select * from parent where login =?");
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  parent = new Paarent(
                        resultSet.getInt("id_parent"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("cin"),
                        resultSet.getString("email"),
                        resultSet.getString("photo"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("etat"),
                        resultSet.getDate("created_on"));
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (parent == null) {
            return null;
        }
        return parent;
    }
    
    
    
    public Boolean verifierpassword(String pword, String uname) {
        String s1 = "";
        String req = "Select id_parent from parent where login= ? and password= ?";
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
    public Paarent chercherParentByid(Paarent p) {
        String sql = "SELECT * FROM parent WHERE id_parent=?";
           Paarent parent = null;
        try {
            PreparedStatement stmt = DataBase.getInstance().getConnection().prepareStatement(sql);
            stmt.setInt(1, p.getId_parent());
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                 
                 parent = new Paarent(
                        resultSet.getInt("id_parent"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("cin"),
                        resultSet.getString("email"),
                        resultSet.getString("photo"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("etat"),
                        resultSet.getDate("created_on"));
             
            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return parent;
    }
    
    public Paarent chercherParentByid(Integer r) {
        Paarent parent = null;
        String req = "select * from parent where id_parent =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DataBase.getInstance().getConnection().prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
        
            while (resultSet.next()) {
                parent = new Paarent(
                        resultSet.getInt("id_parent"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("cin"),
                        resultSet.getString("email"),
                        resultSet.getString("photo"),
                        resultSet.getInt("tel"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("etat"),
                        resultSet.getDate("created_on"));
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return parent;
    }
    
}
