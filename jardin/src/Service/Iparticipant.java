/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.itextpdf.text.DocumentException;
import entitie.participant;
import entitie.partlist;
import java.io.FileNotFoundException;
import java.io.IOException;



import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataBase;

/**
 *
 * @author ahmed
 */
public interface Iparticipant {
     public void  ajoutparticipant(participant p);
    public void modifierparticipant(participant p);
    public void supprimerparticipant(int id);
    
    public  List<partlist> listparticipant(int id);
 public void FacturePdf(int id)throws SQLException,FileNotFoundException,DocumentException,IOException;    
  public ResultSet listeevent(int id);
}
