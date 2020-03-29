/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.publication;
import Utils.DataBase;
import entitie.comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author LENOVO-PC
 */
public class ServicePublication {

    Connection c = DataBase.getInstance().getConnection();

     public void ajouterPublication(publication p) {
                 
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Ajout publication!");
             alert.setHeaderText("Information");
             alert.setContentText("publication bien ajouté "); 
             alert.showAndWait();
        try {
            Statement st = c.createStatement();
            String req = "insert into publication values("+p.getId()+",'" + p.getTexte() + "','" + p.getDate() + "','" + p.getScore() + "','" + p.getCategorie() + "','" + p.getImage()+ "')";

            st.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
     }
     
    public void afficherpublication() {
        try {
            PreparedStatement pt = c.prepareStatement("select * from publication");
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                System.out.println("publication {publication:" + rs.getString(2) + " ,date:" + rs.getString(3) + ", score  "+rs.getInt(4)+"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recherchePublication(int id) {
        try {
            PreparedStatement pt = c.prepareStatement("select * from publication where id=?");
             pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                System.out.println("publication {publication:" + rs.getString(2) + " ,date:" + rs.getString(3) + ", score  "+rs.getInt(4)+"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /*public int count(publication p)
    {
        try {
            PreparedStatement pt= c.prepareStatement("select COUNT(*) AS total from publication where texte= ?");
            pt.setString(1, p.getTexte());
            ResultSet rs= pt.executeQuery();
            while(rs.next())
            {
                rs.getInt("total");
                
               return rs.getInt("total");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }*/
    public void afficherpublicationDate() {
        try {
            PreparedStatement pt = c.prepareStatement("select * from publication order by date");
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                System.out.println("publication {publication:" + rs.getString(2) + " ,date:" + rs.getString(3) + ", score  "+rs.getInt(4)+"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      /*  public List<publication> afficherpublicationScore() {
        try {
            PreparedStatement pt = c.prepareStatement("select * from publication order by score");
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                System.out.println("publication {publication:" + rs.getString(2) + " ,date:" + rs.getString(3) + ", score  "+rs.getInt(4)+"}");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void upvote(String texte)
    {
        try {
            PreparedStatement pt =c.prepareStatement("update publication SET score=score+1 where texte=?" );
            pt.setString(1,texte);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void downvote(String texte)
    {
        try {
            PreparedStatement pt =c.prepareStatement("update publication SET score=score-1 where texte=?" );
            pt.setString(1,texte);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void deletebad()
       {
           try {
           PreparedStatement pt =c.prepareStatement("delete  from publication where score<-50");
           pt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
       }
    public void supprimerPublication(String texte) {
        try {
            PreparedStatement pt = c.prepareStatement("delete from publication where texte=?");
            pt.setString(1, texte);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierPublication(String texte, String id) {
        try {
            PreparedStatement pt = c.prepareStatement("update publication set texte=? where texte=?");
            pt.setString(1, texte);
            pt.setString(2, id);

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 public List<publication> showpls() throws SQLException {
    List<publication> arr=new ArrayList<>();
   PreparedStatement pt = c.prepareStatement("select * from publication order by date");
    ResultSet rs = pt.executeQuery();
     while (rs.next()) {                
               
               String texte=rs.getString(2);
               
               String date=rs.getString(3);
               int score =rs.getInt(4);
               String categorie=rs.getString(5);
               String image=rs.getString(6);

               publication p=new publication(texte,date,score,categorie,image);
     arr.add(p);
     }
    return arr;
    }










}
