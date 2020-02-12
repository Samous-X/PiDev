/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.participant;
import entity.partlist;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;



import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.ConnexionDB;
import service.TrayIconDemo;

/**
 *
 * @author ahmed
 */
public class participantService implements Iparticipant {
    Connection  myConnex;
      Statement ste;
 
  public participantService() throws ClassNotFoundException {
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
    public void ajoutparticipant(participant p) {
        TrayIconDemo T = null ;
              
        try {
              String req =
                      "INSERT INTO participant (id_event,id_parent,nombre_enfant)"
                      + "VALUES  "
                      + "(?,?,?)";
              
        
             PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, p.getId_event());
            ps.setInt(2, p.getId_parent());
            ps.setInt(3, p.getNombre_enfant());
           
            
             
              ps.executeUpdate();
              if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
            
          } catch (SQLException ex) {
              Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
          } catch (AWTException ex) {
            Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierparticipant(participant p) {
       try {
            String req = "update participant set nombre_enfant=? where id_participant=?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, p.getNombre_enfant());
            ps.setInt(2,p.getId_participant());
            ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprimerparticipant(int id) {
        try {
            String req = "delete from participant where id_participant=?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
           
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

   

    @Override
    public List<partlist> listparticipant(int id) {
        ArrayList<partlist> psr = new ArrayList<>();
        try
        {
            String req3;
            req3 = "select participant.*,parent.* from participant INNER JOIN parent ON participant.id_parent=parent.id_parent where participant.id_event= "+id+"";
           // req3="select * from participant";
           // PreparedStatement ps=myConnex.prepareStatement(req3);
           // ps.setInt(1, id);
            ResultSet res =   ste.executeQuery(req3);
              while (res.next()) {
                  partlist p = new partlist();
                  p.setNom(res.getString("nom"));
                  p.setPrenom(res.getString("prenom"));
                  p.setTel(res.getInt("tel"));
                  p.setMail(res.getString("email"));
                  p.setNombre_enfant(res.getInt("nombre_enfant"));
                  psr.add(p);
              }
        }catch (SQLException ex) {
              Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
          }
        return psr ;
    }

    
    
}