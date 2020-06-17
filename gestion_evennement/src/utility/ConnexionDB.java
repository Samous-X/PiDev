package utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salma
 */
public class ConnexionDB {
    
    String url="jdbc:mysql://localhost:3308/jardins?characterEncoding=latin1" ;
    String login="root";
    String pwd="";
   
    static Connection myConnex;
    static ConnexionDB myconnBD;
    
    private ConnexionDB() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
          myConnex = DriverManager
                  .getConnection(url, login, pwd);

          System.out.println("connexion etablie");
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
    
    public static ConnexionDB getInstance() throws ClassNotFoundException{
        
        if(myconnBD == null)
         myconnBD =   new ConnexionDB();
           
        return myconnBD;
    }
    
    
    public  Connection getConnection(){
        
       
            return myConnex;
    }
    
    
}