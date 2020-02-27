/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entitie.Bus;
import Service.ServiceBus;
import java.sql.Statement;
import entitie.Reservation;
import Service.TrayIconDemo_1;
import java.awt.AWTException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author chadi
 */
public class ServiceReservation {
   Connection c=DataBase.getInstance().getConnection();
   public int count(Bus  b)
    {
        try {
            PreparedStatement pt= c.prepareStatement("select COUNT(*) AS total from reservation where immatriculation= ?");
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
        if (count(b)<b.getNbrplace())
        try 
        {   
            Statement st=c.createStatement();
            
        String req="insert into reservation values("+r.getId_res()+",'"+r.getNom_p()+"','"+r.getType()+"','"+b.getImmat()+"','"+r.getDate_debut()+"','"+r.getDate_fin()+"','"+r.getEnfant()+"',"+r.getEtat()+")";

            
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
           else {
           System.out.println("matnjamch");
       Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("");
             alert.setHeaderText("Bus Complet");
             alert.setContentText("Nombre de reservation Max atteint");
             
             alert.showAndWait();
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
                a.setEnfant(rs.getString(7));

           
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
     public void supprimer2(String nom)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from reservation where immatriculation=? " );
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
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    return null;
   
    
    }
     public List<String> displaysm()
       {
             List<String> list = new ArrayList<String>();
      

       Connection c=DataBase.getInstance().getConnection();
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
                a.setEnfant(rs.getString(7));
                
         
                myList.add(a);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    public int getidparent(String nom) {
        int r;
        try{
       
        String requete="SELECT id_parent FROM `parent` WHERE nom='"+nom+"' ";
        PreparedStatement pst=c.prepareStatement(requete);
         ResultSet rs=pst.executeQuery();
       
        while(rs.next()){
            
            r = rs.getInt("id_parent");
            return r;
        }    
     } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    return 155;
   
    
    }
        public List<String> getenfant(int id )
       {
             List<String> list = new ArrayList<String>();
      

 Connection c=DataBase.getInstance().getConnection();
         try {
            PreparedStatement pt =c.prepareStatement("select nom from enfant where id_parent = ? ");
            pt.setInt(1, id);
            
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               list.add(rs.getString("nom"));
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
       }
        public boolean Rechercherahmed(String imm )
{
        try {
            String requete="select * from reservation where immatriculation=? and etat=? ";
            PreparedStatement pst=c.prepareStatement(requete);
            pst.setString(1, imm);
            pst.setInt(2, 1);
           
            ResultSet rs=pst.executeQuery();
            if(rs.next())
                return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
}
}
