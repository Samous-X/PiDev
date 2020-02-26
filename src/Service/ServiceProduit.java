/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.produit;
import SGBD.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dora
 */
public class ServiceProduit {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


       private Connection con;
    private Statement ste;

    public ServiceProduit() {
        con = DataBase.getInstance().getConnection();

    }

   /* public void ajouter(produit p) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `jardin enfant`.`staff` (`id`, `nom`, `adresse`, `equipement`,'lang','lat','prix') VALUES (NULL, '" + f.getNom_staff()+ "', '" + f.getPrenom_staff()+ "', '" + f.getPoste()+"');";
        ste.executeUpdate(requeteInsert);
    }*/
    public void ajouter1(produit p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `produit` (`idproduit`, `nomproduit`, `image_prod`,`prix_prod` ) VALUES ( NULL,?, ?, ?);");
    
    pre.setString(1,p.getNomproduit());
    pre.setString(2, p.getImage_prod());
    pre.setInt(3, p.getPrix_prod());
    

    pre.executeUpdate();
    }
            

   

    public List<produit> readAll() throws SQLException {
    List<produit> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from produit");
     while (rs.next()) {                
               int idproduit=rs.getInt(1);
               String nomproduit=rs.getString("nomproduit");
               String image_prod=rs.getString("image_prod");
               int prix_prod=rs.getInt("prix_prod");
               
               produit f=new produit(idproduit,nomproduit, image_prod,prix_prod);
     arr.add(f);
     }
    return arr;
    }
     
     public void Deleteproduit(int idproduit) {
       
                     int i=idproduit;
   
        String requete="DELETE FROM produit WHERE idproduit =?";
        try {
             

            PreparedStatement pst = con.prepareStatement(requete);
            pst.setInt(1,i);
            pst.executeUpdate();
            System.out.println("produit supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    public void Update(int idproduit,String nomproduit,String image_prod,int prix_prod) {
         String requete="UPDATE produit SET nomproduit= ?, image_prod=? , prix_prod=?  WHERE idproduit=?";
          try {
             PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1,nomproduit);
            pst.setString(2, image_prod );
            pst.setInt(3, prix_prod );
           
            pst.executeUpdate();
            System.out.println("produit Modifié");
            } catch (SQLException ex) {
              Logger.getLogger(ServiceJardin.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
     public List<produit> rechercherproduitParnom (String nomproduit){
        
        String requete="select * FROM produit where (nomproduit LIKE ? )";
        
        String ch="%"+nomproduit+"%";
        ArrayList<produit> myList = new ArrayList();
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
             pst.setString(1,ch);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                produit st= new produit();
                st.setIdproduit(rs.getInt(1));
                st.setNomproduit(rs.getString(2));
                st.setImage_prod(rs.getString(3));
                st.setPrix_prod(rs.getInt(4));
                
                myList.add(st);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }
    /* 
     public List<produit> rechercherStaffParnomjardin (String nom){
        
        String requete="SELECT * FROM produit  inner join jardin on  jardin.idjardin=staff.idjardin AND (nom LIKE ?)";
        
        String ch="%"+nom+"%";
        ArrayList<produit> myList = new ArrayList();
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
             pst.setString(1,nom);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                produit st= new produit();
                st.setIdproduit(rs.getInt(1));
                
                st.setNomproduit(rs.getString(2));
                st.setImage_prod(rs.getString(3));
               
                st.setPrix_prod(rs.getInt(4));
        
                myList.add(st);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }*/
    
}

