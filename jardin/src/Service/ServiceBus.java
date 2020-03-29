/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Bus;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Service.TrayIconDemo;
import com.itextpdf.text.BaseColor;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Time;


/**
 *
 * @author chadi
 */
public class ServiceBus {
Connection c=DataBase.getInstance().getConnection();

           
      public void ajouterbus(Bus b)
    {
      
           
            
        try 
        {   
            Statement st=c.createStatement();
            
        String req="insert into bus values("+b.getId_bus()+",'"+b.getImmat()+"','"+b.getLigne()+"','"+b.getHoraire()+"','"+b.getChauffeur()+"',"+b.getNbrplace()+",'"+b.getImage()+"')";
          TrayIconDemo td = new TrayIconDemo();
            try {
                JOptionPane.showMessageDialog(null, "Bus ajouté");
                td.displayTray();
            } catch (AWTException ex) {
                Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
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
       public List<Bus> afficherBus (){
        
        
        ArrayList<Bus> myList = new ArrayList();
        try {
            PreparedStatement pt =c.prepareStatement("select * from bus");
            ResultSet rs= pt.executeQuery();
            while(rs.next()){
                Bus a = new Bus();
                
                a.setId_bus(rs.getInt(1));
                a.setImmat(rs.getString(2));
                a.setLigne(rs.getString(3));
                a.setHoraire(rs.getTime(4).toString());
                a.setChauffeur(rs.getString(5));
                a.setNbrplace(rs.getInt(6));
           
                myList.add(a);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return myList;
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
       
       public List<Bus> rechercherBus (String ligne){
        
        String requete="select * FROM bus where (ligne LIKE ? )";
      
        String ch="%"+ligne+"%";
        ArrayList<Bus> myList = new ArrayList();
        try {
            
             PreparedStatement pst = c.prepareStatement(requete);
             pst.setString(1,ch);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Bus a = new Bus();
                
                a.setId_bus(rs.getInt(1));
                a.setImmat(rs.getString(2));
                a.setLigne(rs.getString(3));
                a.setHoraire(rs.getTime(4).toString());
                a.setChauffeur(rs.getString(5));
                a.setNbrplace(rs.getInt(6));
           
                myList.add(a);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }
       public void modifierbus(Bus b) {
        try {
             DateFormat dateFormat= new SimpleDateFormat("HH:mm:ss");
            java.util.Date d=dateFormat.parse(b.getHoraire());
            java.sql.Time ti= new java.sql.Time(d.getTime());
            try {
                PreparedStatement pt=c.prepareStatement("update bus set Immat=?,ligne=?,horaire=?,chauffeur=?,nbrplace=? where Id_bus=?");
                pt.setString(1,b.getImmat());
                pt.setString(2,b.getLigne());
                pt.setTime(3,ti);
                pt.setString(4,b.getChauffeur());
                pt.setInt(5,b.getNbrplace());

                pt.setInt(6, b.getId_bus());
                pt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public List<String> displaysm()
       {
             List<String> list = new ArrayList<String>();
      
        String k ;
        String o="Chauffeur";
        Connection c=DataBase.getInstance().getConnection();
         try {
            PreparedStatement pt =c.prepareStatement("select Nom_staff from staff where Poste=?");
            pt.setString(1,o);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
               list.add(rs.getString(1));
            }
              } catch (SQLException ex) {
            Logger.getLogger(ServiceBus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return list;
       }
       public List<Bus> afficherBus2 (){
        
        
        ArrayList<Bus> myList = new ArrayList();
        try {
            PreparedStatement pt =c.prepareStatement("select * from bus");
            ResultSet rs= pt.executeQuery();
            while(rs.next()){
                Bus a = new Bus();
                
                a.setId_bus(rs.getInt(1));
                a.setImmat(rs.getString(2));
                a.setLigne(rs.getString(3));
                a.setHoraire(rs.getTime(4).toString());
                a.setChauffeur(rs.getString(5));
                a.setNbrplace(rs.getInt(6));
                a.setImage(rs.getString(7));
           
                myList.add(a);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return myList;
    }
        public void FacturePdf() throws SQLException,FileNotFoundException,DocumentException,IOException 
    {
        Document doc = new Document();
        
       Statement st=c.createStatement();
       // ste=myConnex.createStatement();
        ResultSet rs=st.executeQuery("select * from bus");
        PdfWriter.getInstance(doc, new FileOutputStream("C:/pdf/Resultat.pdf"));
        
        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste Des Bus  "));
        doc.add(new Paragraph("   "));
        
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase("Immariculaion",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Ligne",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Horaire",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        
        cell = new PdfPCell(new Phrase("Nombre De place",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        

        
        
        
        
        
        
        
     while (rs.next()) {                
            
             
                  
                  
                  String Immat=rs.getString("Immat");
               String ligne=rs.getString("ligne");
               Time horaire=rs.getTime("horaire");
                  int nbrplace=rs.getInt("nbrplace");
               
            
               
                 
               
               

               DateFormat df = new SimpleDateFormat("hh:mm:ss");
               String rec = df.format(horaire);
                String rank = Integer.toString(nbrplace);
         
               
               
               
               
               cell = new PdfPCell(new Phrase(Immat,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(ligne,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(rec,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
        
        
               cell = new PdfPCell(new Phrase(rank,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
        
        
   
        
        
               
              
        
                        }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File ("C:/pdf/Resultat.pdf"));
            }
      
}
