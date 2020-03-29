/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Produit;
import entitie.store;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER-PC
 */
public class serviceStore {
    Connection  myConnex;
      Statement ste;
    
    public serviceStore() {
  
              myConnex  = DataBase.
                      getInstance()
                      .getConnection();
            
    }
    
    
    
    
  
    public void ajouterstore(store s) throws SQLException {
      
      PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `store` (`idstore`, `nom_store`) VALUES ( NULL, ?);");
        pre.setString(1, s.getNom_store());
        pre.executeUpdate();

    }
    

    public void modifieridstore(int idstore,String nom_store) {
         String req ="UPDATE store SET nom_store= ?  WHERE idstore=?";
         try {
            PreparedStatement pst = myConnex.prepareStatement(req);
            pst.setString(2, nom_store);
                pst.setInt(1,idstore);
          
        pst.executeUpdate();
            System.out.println("store Modifié");
                     ste.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void supstore(int idstore) {
        
          try {
              String req2 =
                      "DELETE FROM store where idstore=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, idstore);
              ps.executeUpdate();
              System.out.println("store supprimé");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }
    }
    
}
