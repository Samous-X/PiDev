/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.publication;
import Service.ServicePublication;
import entitie.comment;
import Utils.DataBase;
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
 * @author LENOVO-PC
 */
public class serviceComment {
    Connection c = DataBase.getInstance().getConnection();
   
    
    public void ajoutercomment(comment co) {
        if (count(co)==0)
        try {
            Statement st = c.createStatement();
            String req = "insert into comment values(NULL,'" + co.getTextec() + "','" + co.getDatec() + "','" + co.getId() + "')";

            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void supprimerComment(String ca) {
        try {
            PreparedStatement pt = c.prepareStatement("delete from comment where textec=?");
            pt.setString(1,ca);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void modifierComment(String textec, String text) {
        try {
            PreparedStatement pt = c.prepareStatement("update comment set textec=? where textec=?");
            pt.setString(1, textec);
            pt.setString(2, text);

            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      public int count(comment co)
    {
        try {
            PreparedStatement pt= c.prepareStatement("select COUNT(*) AS total from comment where textec= ? ");
            pt.setString(1, co.getTextec());
            //pt.setString(2, co.getTextec());
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
    }
    public void afficherComment(int id) {
        try {
            PreparedStatement pt = c.prepareStatement("select * from comment where id=?");
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                System.out.println("publication {commentaire:" + rs.getString(2) + " ,date:" + rs.getString(3) + ", publication  "+rs.getInt(4)+"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void affichage(int a)
    {
        ServicePublication srvp=new ServicePublication();
        serviceComment srvc=new serviceComment();
           for (int i = 0; i <a ; i++) 
           {
               srvp.recherchePublication(i);
               srvc.afficherComment(i);
              } 
    }
    public List<comment> showpls(String pub) throws SQLException {
    List<comment> arr=new ArrayList<>();
   PreparedStatement pt = c.prepareStatement("select textec,datec from comment where id=?");
    pt.setString(1, pub);
    ResultSet rs = pt.executeQuery();
     while (rs.next()) {                
               
               String texte=rs.getString(1);
               String date=rs.getString(2);
             
               comment co=new comment(texte,date);
     arr.add(co);
     }
    return arr;
    }
}
