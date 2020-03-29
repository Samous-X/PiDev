/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.commande;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER-PC
 */
public class serviceCommande {
     Connection  myConnex;
      Statement ste;
    
    public serviceCommande() {
  
              myConnex  = DataBase.
                      getInstance()
                      .getConnection();
            
    }
    
    
   

    
    
     public void ajouterCom(commande cm) throws SQLException {
      
     PreparedStatement pre=myConnex.prepareStatement
("INSERT INTO `commande` (`id_com`, `date_com`, `date_liv`,`numcompte`) VALUES ( NULL, ?, ?,?);");
     
     pre.setString(1, cm.getDate_com());
     pre.setDate(2, cm.getDate_liv());
     pre.setString(3, cm.getNumcompte());
  
    pre.executeUpdate();
    
        JOptionPane.showMessageDialog(null, "Commande Ajouté!");

    }
     public void supproduit(int idproduit) {
        
          try {
              String req2 =
                      "DELETE FROM commande where id_com=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, idproduit);
              ps.executeUpdate();
              System.out.println("prod supprimé");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }
    }
}
