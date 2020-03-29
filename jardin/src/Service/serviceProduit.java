/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Produit;

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
public class serviceProduit  {
 Connection  myConnex;
      Statement ste;
    
    public serviceProduit() {
  
              myConnex  = DataBase.
                      getInstance()
                      .getConnection();
            
    }
    
    
    
    
  
    public void ajouterproduit(Produit p) throws SQLException {
      
      PreparedStatement pre=myConnex.prepareStatement
("INSERT INTO `produit` (`idproduit`, `nomproduit`, `prix_prod`,`qte`, `img_prod`) VALUES ( NULL, ?, ?, ?,?);");
      
    pre.setString(1, p.getNomproduit());
    pre.setInt(2, p.getPrix_prod());
pre.setInt(3, p.getQte());
    pre.setString(4, p.getImg_prod());
    pre.executeUpdate();
    
        JOptionPane.showMessageDialog(null, "Produit Ajouté!");

    }
        

   public void modifierprodint (Produit prod) throws SQLException {
       
       
     /*  String req ="UPDATE produit SET nomproduit= ? , prix_prod=?, qte=? WHERE idproduit=?";
       PreparedStatement pst = myConnex.prepareStatement(req);
        pst.setString(1,prod.getNomproduit());
                       pst.setInt(2,prod.getPrix_prod());
                       pst.setInt(3,prod.getQte());
        pst.executeUpdate();
        System.out.println("Utilisateur Modifier");
      
        */
   
         String req ="update produit set nomproduit= ? , prix_prod=?, qte=? WHERE idproduit=?";
         try {
            PreparedStatement pst = myConnex.prepareStatement(req);
                       pst.setString(1,prod.getNomproduit());
                       pst.setInt(2,prod.getPrix_prod());
                       pst.setInt(3,prod.getQte());
                       pst.setInt(4,prod.getIdproduit());
                       pst.executeUpdate();
            System.out.println("produit Modifié");
              
              
              ste.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(serviceProduit.class.getName()).log(Level.SEVERE, null, ex);
          }
    }


    public void supproduit(int idproduit) {
        
          try {
              String req2 =
                      "DELETE FROM produit where idproduit=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, idproduit);
              ps.executeUpdate();
              System.out.println("prod supprimé");
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }
    }
    
    
     public List<Produit> readAll() throws SQLException {
    ArrayList<Produit> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery("select * from produit  ");
     while (rs.next()) {                
               int idproduit=rs.getInt(1);
               String nomprod=rs.getString(2);
               int prix_prod=rs.getInt(3);
               int qte=rs.getInt(4);
                          String img_prod =rs.getString(5);

               Produit p=new Produit(idproduit ,nomprod, prix_prod, img_prod, qte);
     arr.add(p);
     }
    return arr;
    }
     
    public List<Produit> listeprod() throws SQLException{
       List<Produit> ARR=new ArrayList<>();
    ste=myConnex.createStatement();
        ResultSet rs=ste.executeQuery("select nomproduit,prix_prod from produit where idproduit=? ");
         while (rs.next()) {                
               int idproduit=rs.getInt(1);
               String nomprod=rs.getString(2);
               int prix_prod=rs.getInt(3);
               int qte=rs.getInt(4);
                          String img_prod =rs.getString(5);

               Produit p=new Produit(idproduit ,nomprod, prix_prod, img_prod, qte);
     ARR.add(p);
     }
     return ARR;

    }
    
   public List<Produit> rechercherProduit(String nomproduit){
        
        String requete="select * FROM produit where (nomproduit=? )";
       
        
        ArrayList<Produit> myList = new ArrayList();
        try {
            ste = myConnex.createStatement();
             PreparedStatement pst = myConnex.prepareStatement(requete);
             pst.setString(1,nomproduit);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Produit P = new Produit();
                P.setIdproduit(rs.getInt(1));
                P.setNomproduit(rs.getString(2));
                P.setPrix_prod(rs.getInt(3));
                P.setQte(rs.getInt(4));
                
           
                myList.add(P);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    } 
    
}