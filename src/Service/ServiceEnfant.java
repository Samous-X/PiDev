/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Enfant;
import entitie.Paarent;
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
import static javax.swing.UIManager.getBoolean;

/**
 *
 * @author Hejer Ghariani
 */
public class ServiceEnfant {
    private Statement ste;
    Connection con = DataBase.getInstance().getConnection();
    public PreparedStatement pst=null;
    public ResultSet rs =null;
    
    private static ServiceEnfant ServiceE;

    public static ServiceEnfant getInstance() {
        if (ServiceE == null) {
            ServiceE = new ServiceEnfant();
        }
        return ServiceE;
    }
    
    public void ajouterEnfant(Enfant E)  {
        
        try 
        {
            Statement st=con.createStatement();
            String req="INSERT INTO `enfant` (`id_enfant`, `nom`, `prenom`, `age`, `photo`, `id_parent`, `vaccin`, `alergie`, `idjardin`) "
                    + "VALUES (NULL, '" + E.getNom() + "', '" + E.getPrenom() + "', '" + E.getAge() + "', '" + E.getPhoto() + "', '" + E.getId_parent() + "', '" + E.getVaccin() + "', '" + E.getAlergie() + "'," + E.getIdjardin() + ");";
            
            st.executeUpdate(req);
            JOptionPane.showMessageDialog(null, "Enfant ajouté");
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void modifierEnfant (Enfant E,String nom)
    {
        try {
            PreparedStatement pt= con.prepareStatement("UPDATE `enfant` SET `nom` = ? WHERE `enfant`.`id_enfant` = ? ;");
            pt.setString(1,nom);
            pt.setInt(2,E.getId_enfant());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public void supprimerEnfant(Enfant E)
    {
        try {
            PreparedStatement pt =con.prepareStatement("DELETE FROM `enfant` WHERE `enfant`.`id_enfant` = ? ;" );
            pt.setInt(1,E.getId_enfant());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Enfant> readAll() throws SQLException {
    List<Enfant> arr=new ArrayList<Enfant>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from enfant");
     while (rs.next()) {                
               int id_enfant=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt("age");
               String photo=rs.getString(5);
               int id_parent=rs.getInt("id_parent");
               String vaccin=rs.getString("vaccin");
               String alergie=rs.getString("alergie");
               Enfant E=new Enfant(id_enfant, nom, prenom, age, photo, id_parent,vaccin,alergie);
     arr.add(E);
     }
    return arr;
    }
    public List<Enfant> readById(Object Id_parent) throws SQLException {
        List<Enfant> arr=new ArrayList<Enfant>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from enfant where id_parent = "+Id_parent+"");
     while (rs.next()) {                
               int id_enfant=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt("age");
               String photo=rs.getString(5);
               int id_parent=rs.getInt("id_parent");
               String vaccin=rs.getString("vaccin");
               String alergie=rs.getString("alergie");
               Enfant E=new Enfant(id_enfant, nom, prenom, age, photo, id_parent,vaccin,alergie);
     arr.add(E);
     }
    return arr;

    }
    public List<Enfant> AfficherEnfanys() throws SQLException {
    List<Enfant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT enfant.* , parent.email FROM `enfant` INNER JOIN `parent` WHERE enfant.id_parent = parent.id_parent ");
     while (rs.next()) {                
               int id_enfant=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt("age");
               String photo=rs.getString(5);
               int id_parent=rs.getInt("id_parent");
               String vaccin=rs.getString("vaccin");
               String alergie=rs.getString("alergie");
               String email=rs.getString("email");
               int idjardin=rs.getInt("idjardin");
               Paarent p=new Paarent(email);
               String a=p.getEmail();
              // Enfant E=new Enfant(id_enfant, nom, prenom, age, photo, id_parent,vaccin,alergie,p.getEmail());
             Enfant A= new Enfant(id_enfant, nom, prenom, age, photo, id_parent, vaccin, alergie,idjardin,a);
               
     arr.add(A);
     System.out.println(A);
     }
    return arr;
    }
    public List<Enfant> AfficherEnfants() throws SQLException {
    List<Enfant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from enfant where id_parent = 40");
     while (rs.next()) {                
               int id_enfant=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt("age");
               String photo=rs.getString(5);
               int id_parent=rs.getInt("id_parent");
               String vaccin=rs.getString("vaccin");
               String alergie=rs.getString("alergie");
               Enfant E=new Enfant(id_enfant, nom, prenom, age, photo, id_parent,vaccin,alergie);
     arr.add(E);
     }
    return arr;
    }
    
    
    public Enfant rechercherenfant(String nom){
       
        Enfant e = new Enfant();
        try{
       
        String requete="select * from enfant where nom="+nom+" ";
        PreparedStatement pst=con.prepareStatement(requete);
         ResultSet rs=pst.executeQuery();
       
        while(rs.next()){
            System.out.println("Enfant existe \n");
                e = new Enfant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
          
                
          System.out.println(e.toString());
          
        }    
     } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    return null;
   
    
}
    public Enfant findEnfant(String nom) {
        Enfant e = new Enfant();
        String requete = "select * from enfant where nom=?";
        try {
            PreparedStatement ps = con.prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                e.setId_enfant(resultat.getInt(1));
                e.setNom(resultat.getString(2));
                e.setPrenom(resultat.getString(3));
                e.setAge(resultat.getInt(4));
                e.setPhoto(resultat.getString(5));
                e.setId_parent(resultat.getInt(6));
                e.setVaccin(resultat.getString(7));
                e.setAlergie(resultat.getString(8));
            }
            return e;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du Cat " + ex.getMessage());
            return null;
        } }
    public int nbEnfants(int id)
    {int nb=0;
        try{
            String sql =("SELECT count(id_enfant) from enfant WHERE id_parent="+id+" ;");
            pst=con.prepareStatement(sql);

            rs=pst.executeQuery();
            if (rs.next()){

                int count= rs.getInt("count(id_enfant)");
                nb=count;
                return nb;

            }
            

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return nb;
    }
    public List<String> displaysm()
       {
             List<String> list = new ArrayList<String>();
      

        Connection c=DataBase.getInstance().getConnection();
         try {
            PreparedStatement pt =c.prepareStatement("select nom from jardin ");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               list.add(rs.getString(1));
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServiceEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
       }
    

}
