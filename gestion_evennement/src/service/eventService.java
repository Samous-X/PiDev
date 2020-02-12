/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entity.event;
import java.sql.Array;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utility.ConnexionDB;

/**
 *
 * @author ahmed
 */
public class eventService implements Ievent
{
      Connection  myConnex;
      Statement ste;
 
  public eventService() throws ClassNotFoundException {
          try {
              myConnex  = ConnexionDB.
                      getInstance()
                      .getConnection();
              ste = myConnex.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

      @Override
    public void ajouterevent(event p) {
        try {
              String req =
                      "INSERT INTO evenement (titre,description,date,image,heureD,heureF,prix_event)"
                      + " VALUES "
                      + "(?,?,?,?,?,?,?)";
              
        
             PreparedStatement ps = myConnex.prepareStatement(req);
            
             ps.setString(1, p.getNom_event());
            ps.setString(2, p.getDesc());
            ps.setDate(3, p.getDate_event());                        
            ps.setString(4, p.getImg());
            ps.setTime(5, p.getHeureD());
            ps.setTime(6, p.getHeureF());
            ps.setFloat(7, p.getPrix_event());
             
              ps.executeUpdate();
              JOptionPane.showMessageDialog(null , "evenement ajouté" );
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void modifierevent(event p) {
        try {
            String req = "update evenement set titre=?,description=?,date=?,image=?,heureD=?,heureF=?,prix_event=? where id_event=?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setString(1, p.getNom_event());
            ps.setString(2, p.getDesc());
            ps.setDate(3, p.getDate_event());                        
            ps.setString(4, p.getImg());
            ps.setTime(5, p.getHeureD());
            ps.setTime(6, p.getHeureF());
            ps.setFloat(7, p.getPrix_event());
            ps.setInt(8,p.getId_event());
            ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public void supprimerevent(int id)
    {
         try {
            String req = "delete from evenement where id_event=?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
           
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

      @Override
    public List<event> afficherevent(event p) {
        try {
              String req3 =
                      "select * from evenement order by date";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("l'evenement est " +
                         res.getString("titre")+" "+
                          res.getString("description")+" "+
                          res.getDate("date")+" "+
                          res.getString("image")+" "+
                          res.getTime("heureD")+""+
                          res.getTime("heureF")+""+
                          res.getFloat("prix_event"));
                          
                          
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

      @Override
    public ArrayList<event> findByNom(String nom) {
              ArrayList<event> ee = new ArrayList<>();
        try {
//           ArrayList bhim = new ArrayList<>();
           
           event e = new event();
            String req = "select * from evenement where titre =?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//               
               e = new event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(6),rs.getTime(7),rs.getFloat(8),rs.getString(5));
               ee.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return ee;  
    }
    
    
}

   

