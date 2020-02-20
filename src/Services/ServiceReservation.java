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
import Services.TrayIconDemo_1;
import java.awt.AWTException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

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
    public void ajouterres(Reservation r , Bus b )
    { 
        try 
        {   
            Statement st=c.createStatement();
            
        String req="insert into reservation values("+r.getId_res()+",'"+r.getNom_p()+"','"+r.getType()+"','"+b.getImmat()+"','"+r.getDate_debut()+"','"+r.getDate_fin()+"')";

            
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void modifierres (Reservation r)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update reservation set type= ?,date_debut= ?,date_fin= ? where nom_p=?");
            pt.setString(1,r.getType());
            pt.setString(2,r.getDate_debut());
            pt.setString(3,r.getDate_fin());
            pt.setString(4,r.getNom_p());
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public List<Reservation> afficherres(){
       
        
        ArrayList<Reservation> myList = new ArrayList();
        try {
            PreparedStatement pt =c.prepareStatement("select * from reservation");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                Reservation a = new Reservation();
                a.setNom_p(rs.getString(2));  
                a.setType(rs.getString(3));
                a.setimmatriculation(rs.getString(4));
                a.setDate_debut(rs.getString(5));
                a.setDate_fin(rs.getString(6));

           
                myList.add(a);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    public void supprimerres(String nom)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from reservation where nom_p=?" );
            pt.setString(1,nom);
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
     public List<String> displaysm()
       {
             List<String> list = new ArrayList<String>();
      

        Connection c=ConnexionBD.getinstance().getcnx();
         try {
            PreparedStatement pt =c.prepareStatement("select nom from parent ");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               list.add(rs.getString(1));
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
       }
      public List<Reservation> afficherBus(String nom){
       
        
        ArrayList<Reservation> myList = new ArrayList();
        try {
            PreparedStatement pt =c.prepareStatement("select * from reservation where immatriculation = ?");
            pt.setString(1,nom);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next()){
                Reservation a = new Reservation();
                a.setNom_p(rs.getString(2));  
                a.setType(rs.getString(3));
                a.setimmatriculation(rs.getString(4));
                a.setDate_debut(rs.getString(5));
                a.setDate_fin(rs.getString(6));
         
                myList.add(a);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return myList;
    }
}
