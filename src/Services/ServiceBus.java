/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Bus;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chadi
 */
public class ServiceBus {
Connection c=ConnexionBD.getinstance().getcnx();
      public void ajouterbus(Bus b)
    {
       
        try 
        {   
            Statement st=c.createStatement();
            
        String req="insert into bus values("+b.getId_bus()+",'"+b.getImmat()+"','"+b.getLigne()+"','"+b.getHoraire()+"','"+b.getChauffeur()+"',"+b.getNbrplace()+")";

            
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
      public void modifierbus (String nom,int id)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update bus set chauffeur= ? where id_bus=?");
            pt.setString(1,nom);
            pt.setInt(2,id);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void affichebus()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from bus");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Bus ("+rs.getInt(1)+ ") || Immariculaion : "+rs.getString(2)+" ||  Ligne : "+rs.getString(3)+"  || Horaire : "+rs.getTime(4)+"  || Chauffeur : "+rs.getString(5)+"  || Nombre de place total  : "+rs.getInt(6)+" ||");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void supprimerBus(String imm)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from bus where immat=?" );
            pt.setString(1, imm);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public Bus Rechercherbus(int id) {
        Bus b = new Bus();
        try{
       
        String requete="select * from bus where id_bus="+id+" ";
        PreparedStatement pst=c.prepareStatement(requete);
         ResultSet rs=pst.executeQuery();
       
        while(rs.next()){
            System.out.println("Bus existe \n");
            b = new Bus(rs.getString(2),rs.getString(3),rs.getTime(4).toString(),rs.getString(5),rs.getInt(6));
           
          System.out.println(b.toString());
          
        }    
     } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    return null;
   
    
    }
       public void afficherbustrierparnbr() {
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `bus` ORDER BY nbrplace Desc ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getObject(i).toString() + " ");
                }
                System.out.println("\n");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
