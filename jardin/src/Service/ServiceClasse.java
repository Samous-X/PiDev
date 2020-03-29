/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Classe;
import Utils.DataBase;
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
public class ServiceClasse 
{
    Connection c=DataBase.getInstance().getConnection();
    public void ajouterpersonne(Classe e)
    {
       
        try 
        {
            Statement st=c.createStatement();
            String req="insert into classe values("+e.getId()+",'"+e.getNom_classe()+"',"+e.getNiveau_classe()+",'"+e.getEnfant()+"',"+e.getNombre()+")";
            
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
        
        public void modifierpersonne (Classe e,String nom)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update classe set nom_classe= ? where id=?");
            pt.setString(1,nom);
            pt.setInt(2,e.getId());
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void afficherpersonne()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from classe");
            ResultSet rs= pt.executeQuery();
           
            
            while(rs.next())
            {
                System.out.println("classe {id:"+rs.getInt(1)+" ,Nom du classe :"+rs.getString(2)+" ,niveau du classe :"+rs.getInt(3)+"enfants : "+rs.getString(4)+"nombre : "+rs.getInt(5)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerpersonne(Classe e)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from classe where id=?" );
            pt.setInt(1,e.getId());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
