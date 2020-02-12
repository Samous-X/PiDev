/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.participant;
import entity.partlist;



import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.ConnexionDB;

/**
 *
 * @author ahmed
 */
public interface Iparticipant {
     public void  ajoutparticipant(participant p);
    public void modifierparticipant(participant p);
    public void supprimerparticipant(int id);
    
    public List<partlist> listparticipant(int id);
    
}
