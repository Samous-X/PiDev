/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Produit;
import entitie.panier;
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
import javax.swing.JOptionPane;

/**
 *
 * @author ACER-PC
 */
public class ServicePanier {
    
    Connection  myConnex;
      Statement ste;
    
    public ServicePanier() {
  
              myConnex  = DataBase.
                      getInstance()
                      .getConnection();
            
    }
    
    public void ajouterPanier(panier pan) throws SQLException {
      
      PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `panier` (`idpanier`, `idproduit`, `id_parent`) VALUES (NULL,?, ?);");
    
 pre.setInt(1, pan.getIdproduit());
pre.setInt(2, pan.getId_parent());
//pre.setInt(1, pan.getQte_prod());
     pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Produit Ajouté au panier!");

    }
    
    
      public void modifierpanier (panier p) {
        String req ="update produit set idproduit=?, qte_prod=? WHERE id_parent=?";
         try {
            PreparedStatement pst = myConnex.prepareStatement(req);
                       pst.setInt(1,p.getId_parent());
                       pst.setInt(2,p.getIdproduit());
                       pst.setInt(3,p.getQte_prod());
                       pst.executeUpdate();
            System.out.println("Panier Modifié");
              
              
              ste.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    } 
      
       public void suppanier(int idpanier) {
        
          try {
              String req2 =
                      "DELETE FROM panier where idpanier=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, idpanier);
              ps.executeUpdate();
              System.out.println("panier supprimé");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }
    }
      
       
    public List<panier> readAll() throws SQLException {
    List<panier> arr=new ArrayList<>();
    ste=myConnex.createStatement();
            ResultSet rs=ste.executeQuery("SELECT produit.prix_prod ,produit.idproduit , panier.id_parent , panier.idpanier ,panier.qte_prod FROM produit INNER JOIN panier ON panier.idproduit=produit.idproduit");
     while (rs.next()) {  
         
         int idproduit=rs.getInt(2);
         int id_parent=rs.getInt(3);
         int idpanier=rs.getInt(4);
         int prix_prod=rs.getInt(1);
         int qte_prod=rs.getInt(5);
        // System.out.println(prix_prod);
             Produit p3= new Produit(prix_prod);

           //  System.out.println(p3);

         panier p1=new panier(idpanier,idproduit, id_parent, qte_prod,p3.getPrix_prod());
        // System.out.println(p1);
     arr.add(p1);
     }
     return arr;
    }
    
    public void montanttotal(int prix_prod) throws SQLException{
        
            ste=myConnex.createStatement();
            ResultSet rs=ste.executeQuery("SELECT SUM(produit.prix_prod) ,panier.idproduit FROM produit INNER JOIN panier ON panier.idproduit=produit.idproduit and panier.id_parent='1'");
           int montanttot = rs.getInt(1);

        
    }
    
      public int somme() throws SQLException {
    ste=myConnex.createStatement();
    int k =0;
            ResultSet rs=ste.executeQuery("SELECT SUM(produit.prix_prod) ,panier.idproduit FROM produit INNER JOIN panier ON panier.idproduit=produit.idproduit and panier.id_parent='1'");
     while (rs.next()) {  
         
        k=rs.getInt(1);
     }
     return k;
    }

    
    
}
