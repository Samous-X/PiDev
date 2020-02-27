/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entitie.event;
import entitie.participant;
import entitie.partlist;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import Utils.DataBase;
import Service.TrayIconDemo;

/**
 *
 * @author ahmed
 */
public class participantService implements Iparticipant {
    Connection  myConnex;
      Statement ste;
 
  public participantService() throws ClassNotFoundException {
          try {
              myConnex  = DataBase.getInstance().getConnection();
              ste = myConnex.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void ajoutparticipant(participant p) {
        TrayIconDemo T = null ;
              
        try {
              String req =
                      "INSERT INTO participant (id_event,id_parent,nombre_enfant)"
                      + "VALUES  "
                      + "(?,?,?)";
              
        
             PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, p.getId_event());
            ps.setInt(2, p.getId_parent());
            ps.setInt(3, p.getNombre_enfant());
           
            
             
              ps.executeUpdate();
              if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
            
          } catch (SQLException ex) {
              Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
          } catch (AWTException ex) {
            Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierparticipant(participant p) {
       try {
            String req = "update participant set nombre_enfant=? where id_participant=?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, p.getNombre_enfant());
            ps.setInt(2,p.getId_participant());
            ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprimerparticipant(int id) {
        try {
            String req = "delete from participant where id_participant=?";
            PreparedStatement ps = myConnex.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
           
          } catch (SQLException ex) {
              Logger.getLogger(eventService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

   

    @Override
    public List<partlist> listparticipant(int id) {
        ArrayList<partlist> psr = new ArrayList<>();
        try
        {
            String req3;
            req3 = "select participant.*,parent.* from participant INNER JOIN parent ON participant.id_parent=parent.id_parent where participant.id_event= "+id+"";
           // req3="select * from participant";
           // PreparedStatement ps=myConnex.prepareStatement(req3);
           // ps.setInt(1, id);
            ResultSet res =   ste.executeQuery(req3);
              while (res.next()) {
                  partlist p = new partlist();
                  p.setId_participant(res.getInt("id_participant"));
                  p.setNom(res.getString("nom"));
                  p.setPrenom(res.getString("prenom"));
                  p.setTel(res.getInt("tel"));
                  p.setMail(res.getString("email"));
                  p.setNombre_enfant(res.getInt("nombre_enfant"));
                 
                  psr.add(p);
              }
        }catch (SQLException ex) {
              Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
          }
        return psr ;
    }
@Override
    public void FacturePdf(int id) throws SQLException,FileNotFoundException,DocumentException,IOException 
    {
        Document doc = new Document();
        
       
        ste=myConnex.createStatement();
        ResultSet rs=ste.executeQuery("select participant.*,parent.* from participant INNER JOIN parent ON participant.id_parent=parent.id_parent where participant.id_event= "+id+"");
        PdfWriter.getInstance(doc, new FileOutputStream("d:/Resultat.pdf"));
        
        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste de participant dans cette evenment  "));
        doc.add(new Paragraph("   "));
        
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase("nom",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("prenom",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("telephone",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        
        cell = new PdfPCell(new Phrase("nombre enfant",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("email",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        

        
        
        
        
        
        
        
     while (rs.next()) {                
            
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
                  int tel=rs.getInt("tel");
                  int nombre=rs.getInt("nombre_enfant");
              String mail=rs.getString("email");

                  
               
            
               
                 
               
               //Conversion to String
              /*
               String nom  = nom.toString();
               String prenom  = prenom.toString();
*/
              
              
                String tele = Integer.toString(tel);
                String nombree = Integer.toString(nombre);

         
               
               
               
               
               cell = new PdfPCell(new Phrase(nom,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(prenom,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(tele,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
        
        
               cell = new PdfPCell(new Phrase(nombree,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(mail,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
        
   
        
        
               
              
        
                        }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File ("d:/Resultat.pdf"));
            }
    public ResultSet listeevent(int id) {
        
         ArrayList<event> psr = new ArrayList<>();
                  try {
              String req3;
                      req3 = "select participant.id_participant,evenement.* from participant INNER JOIN evenement ON participant.id_event=evenement.id_event where participant.id_parent = ?";
                       PreparedStatement ps = myConnex.prepareStatement(req3);
                      ps.setInt(1, id);
                      ResultSet res =   ps.executeQuery();
              
            return res ;
              
             
          } catch (SQLException ex) {
              Logger.getLogger(participantService.class.getName()).log(Level.SEVERE, null, ex);
          }
            return null;
    }
    
}