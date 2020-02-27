/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Jardin;
import Utils.DataBase;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dora
 */
public class ServiceJardin {
       private Connection con;
    private Statement ste;

    public ServiceJardin() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Jardin j) throws SQLException {
        ste = con.createStatement();
     //   String requeteInsert = "INSERT INTO `jardin` (`idjardin`, `nom`, `Adresse`,'lang','lat','Prix_mois') VALUES (NULL, '" + j.getNom() + "', '" + j.getAdresse()+ "', '', '', '" + j.getPrix_mois()+"');";
        String req = "INSERT INTO `jardin` (`idjardin`, `nom`, `Adresse`, `lang`, `lat`, `Prix_mois`,`Numero_telephone`,`id_utilisateur`) VALUES (NULL,'" + j.getNom() + "', '" + j.getAdresse()+ "', 0, 0,'" + j.getPrix_mois()+"',0,11);";
        ste.executeUpdate(req);
    }
    public void ajouter1(Jardin j) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `jardin` (`idjardin`, `nom`, `Adresse`,lang,lat ,prix_mois) VALUES ( ?, ?, ?, ?, ?, ?);");
    
    pre.setInt(1, j.getIdjardin());
    pre.setString(2, j.getNom());
    pre.setString(3, j.getAdresse());
    pre.setDouble(4, j.getLang());
    pre.setDouble(5, j.getLat());

    pre.setInt(6, j.getPrix_mois());
    pre.executeUpdate();
    }
      /*public void ajouter2(Jardin j) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `jardin` (`idjardin`, `nom`, `Adresse`, `long`,`lat` ,`Prix_mois`) VALUES ( Null, ?, ?,'','', ?);");
    
   
    pre.setString(2, j.getNom());
    pre.setString(3, j.getAdresse());
    //pre.setDouble(4, j.getLang());
    //pre.setDouble(5, j.getLat());
    pre.setInt(6, j.getPrix_mois());
    pre.executeUpdate();
    }*/
           
            

    public void delete(Jardin j){
      
        try {
            PreparedStatement pt =con.prepareStatement("DELETE FROM `jardin` WHERE `jardin`.`idjardin` = ? ;" );
            pt.setInt(1,j.getIdjardin());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public boolean update(Jardin t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Jardin> readAll() throws SQLException {
    List<Jardin> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from jardin");
     while (rs.next()) {                
               int idjardin=rs.getInt(1);
               String nom=rs.getString("nom");
               String Adresse=rs.getString("Adresse");
               float lang=rs.getInt("lang");
               float lat=rs.getInt("lat");
           
               int Prix_mois=rs.getInt("Prix_mois");
               Jardin j=new Jardin(idjardin, nom,Adresse,  lang,  lat,  Prix_mois);
     arr.add(j);
     }
    return arr;
    }
      public boolean Update2(Jardin j, String nom,String Adresse,int Prix_mois) {
           String requete="UPDATE jardin SET nom= ?, Adresse=? , Prix_mois=? WHERE idjardin=?";
            Jardin a = new Jardin();
          try {
             PreparedStatement pst = con.prepareStatement(requete);
             
             pst.setString(1,j.getNom());
            pst.setString(2,j.getAdresse());
           pst.setInt(3,j.getPrix_mois());
           pst.setInt(4,j.getIdjardin());
           
            pst.executeUpdate();
            System.out.println("Jardin Modifié");
                    
          } catch (SQLException ex) {
              Logger.getLogger(ServiceJardin.class.getName()).log(Level.SEVERE, null, ex);
          }
          return true;
    }
   public  Jardin rechercherJardinParid (String nom){
        String requete="select * FROM jardin where (nom Like ?)";
        Jardin a = new Jardin();
       
        
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
            
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                a.setIdjardin(rs.getInt(1));
                a.setNom(rs.getString("nom"));
                a.setAdresse(rs.getString("Adresse"));
                a.setLang(rs.getFloat(4));
                a.setLat(rs.getFloat(5));
                a.setPrix_mois(rs.getInt("Prix_mois"));
                
              return a;  
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return a; 
   }
    public List<Jardin> rechercherJardinParnom (int idjardin){
        
        String requete="select * FROM jardin where (idjardin LIKE ? )";
        
        String ch="%"+idjardin+"%";
        int c=Integer.parseInt(ch);
        ArrayList<Jardin> myList = new ArrayList();
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
             pst.setInt(1,c);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Jardin a = new Jardin();
                a.setIdjardin(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setAdresse(rs.getString(3));
                a.setLang(rs.getFloat(4));
                a.setLat(rs.getFloat(5));
                a.setPrix_mois(rs.getInt(6));
                myList.add(a);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }
     public Jardin rechercherJardinParnom2(String Nom){
        
        String requete="select * FROM jardin where (nom LIKE ? )";
        
        String ch="%"+Nom+"%";
       Jardin a = new Jardin();
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
             pst.setString(1,ch);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                a.setIdjardin(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setAdresse(rs.getString(3));
                a.setLang(rs.getFloat(4));
                a.setLat(rs.getFloat(5));
                a.setPrix_mois(rs.getInt(6));
              
                return a;
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }return a;
     }
     public int getidjardin(String nom) {
        int r;
        try{
       
        String requete="SELECT idjardin FROM jardin WHERE nom='"+nom+"' ";
        PreparedStatement pst=con.prepareStatement(requete);
         ResultSet rs=pst.executeQuery();
       
        while(rs.next()){
            
            r = rs.getInt("idjardin");
            return r;
        }    
     } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    return 155;
   
    
    }
}
    

