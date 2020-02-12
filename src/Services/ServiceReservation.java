/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Bus;
import Services.ServiceBus;
import java.sql.Statement;
import Entities.Reservation;

/**
 *
 * @author chadi
 */
public class ServiceReservation {
   Connection c=ConnexionBD.getinstance().getcnx();
   public int count(Bus  b)
    {
        try {
            PreparedStatement pt= c.prepareStatement("select COUNT(*) AS total from reservation where ligne_r= ?");
            pt.setString(1, b.getLigne());
            ResultSet rs= pt.executeQuery();
            while(rs.next())
            {
                rs.getInt("total");
                 
               return rs.getInt("total");
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    public void ajouterres(Reservation r , Bus  b)
    { 
       if (count(b)<b.getNbrplace())
           { 
        try 
        {   
            Statement st=c.createStatement();
            
        String req="insert into reservation values("+r.getId_res()+",'"+r.getNom_p()+"','"+r.getType()+"','"+b.getLigne()+"','"+r.getDate_debut()+"','"+r.getDate_fin()+"')";

            
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
       else 
            System.out.println("Ligne Complet");
            
  
    }
    public void modifierres (String type,String nom)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update reservation set type= ? where nom_p=?");
            pt.setString(1,type);
            pt.setString(2,nom);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void afficheres()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from reservation");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Reservation  ("+rs.getInt(1)+ ") || Nom Parent  : "+rs.getString(2)+" ||  Type de Reservation  : "+rs.getString(3)+"  || Ligne de Transport  : "+rs.getString(4)+"  || Date de Debut D'abonnement : "+rs.getDate(5)+"  || Date de Fin D'abonnement :  "+rs.getDate(6)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerres(int id)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from reservation where id_res=?" );
            pt.setInt(1,id);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Reservation Rechercherres(int id) {
        Reservation r = new Reservation();
        try{
       
        String requete="select * from reservation where id_res="+id+" ";
        PreparedStatement pst=c.prepareStatement(requete);
         ResultSet rs=pst.executeQuery();
       
        while(rs.next()){
            System.out.println("Reservation existe \n");
            r = new Reservation(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toString(),rs.getDate(6).toString());
           
                
          System.out.println(r.toString());
          
        }    
     } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    return null;
   
    
    }
}
