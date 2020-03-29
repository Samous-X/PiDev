/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.Jardin;
import entitie.Staff;
import Utils.DataBase;
import com.itextpdf.text.BaseColor;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dora
 */
public class ServiceStaff {

       private Connection con;
    private Statement ste;

    public ServiceStaff() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Staff f) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `staff` (`id_staff`, `Nom_staff`, `Prenom_staff`, `Poste`,`idjardin`,`Status`) VALUES (NULL, '" + f.getNom_staff()+ "', '" + f.getPrenom_staff()+ "', '" + f.getPoste()+"',22,'"+f.getStatus()+"');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Staff f) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `staff` (`id_staff`, `Nom_staff`, `Prenom_staff`,`Poste`,`idjardin`,`Status`  ) VALUES ( NULL,?, ?, ?, ?,?);");
    
    pre.setString(1, f.getNom_staff());
    pre.setString(2, f.getPrenom_staff());
    pre.setString(3, f.getPoste());
    pre.setInt(4, f.getIdjardin());
    pre.setString(5, f.getStatus());

    pre.executeUpdate();
    }
            

   

    public List<Staff> readAll() throws SQLException {
    List<Staff> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from staff");
     while (rs.next()) {                
               int id_staff=rs.getInt(1);
               String Nom_staff=rs.getString("Nom_staff");
               String Prenom_staff=rs.getString("Prenom_staff");
               String Poste=rs.getString("Poste");
               int idjardin=rs.getInt(5);
               String Status=rs.getString("Status");

               Staff f=new Staff(id_staff, Nom_staff,Prenom_staff,Poste,idjardin,Status);
     arr.add(f);
     }
    return arr;
    }
     
     public void DeleteStaff(int id_staff) {
       
                     int i=id_staff;
   
        String requete="DELETE FROM staff WHERE id_staff =?";
        try {
             

            PreparedStatement pst = con.prepareStatement(requete);
            pst.setInt(1,i);
            pst.executeUpdate();
            System.out.println("staff supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
  public void Update(Staff s,String Nom_staff,String Prenom_staff,String Poste,String Status) {
         String requete="UPDATE Staff SET Nom_staff= ?, Prenom_staff=? , Poste=? , Status=?  WHERE id_staff=?";
          try {
             PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1,Nom_staff);
            pst.setString(2, Prenom_staff );
            pst.setString(3, Poste );
            pst.setString(4, Status);
           pst.setInt(5,s.getId_staff());
           
            pst.executeUpdate();
            System.out.println("staff Modifié");
            } catch (SQLException ex) {
              Logger.getLogger(ServiceJardin.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
     public List<Staff> rechercherStaffParnom (int idjardin){
        
        String requete="select * FROM staff  inner join jardin on  jardin.idjardin=staff.idjardin AND(idjardin LIKE ? )";
        
      
        ArrayList<Staff> myList = new ArrayList();
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
             pst.setInt(1,idjardin);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Staff st= new Staff();
                st.setId_staff(rs.getInt(1));
                st.setIdjardin(rs.getInt(2));
                st.setNom_staff(rs.getString(3));
                st.setPrenom_staff(rs.getString(4));
                st.setPoste(rs.getString(5));
                st.setStatus(rs.getString(6));
                myList.add(st);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }
     
     public List<Staff> rechercherStaffParnomjardin (String nom){
        
        String requete="SELECT * FROM staff  inner join jardin on  jardin.idjardin=staff.idjardin AND (nom LIKE ?)";
        
        String ch="%"+nom+"%";
        ArrayList<Staff> myList = new ArrayList();
        try {
            
             PreparedStatement pst = con.prepareStatement(requete);
             pst.setString(1,nom);
              
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Staff st= new Staff();
                st.setId_staff(rs.getInt(1));
                st.setNom_staff(rs.getString(2));
                st.setPrenom_staff(rs.getString(3));
                st.setPoste(rs.getString(4));
                st.setIdjardin(rs.getInt(5));
                st.setStatus(rs.getString(6));
        
                myList.add(st);
                
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }
      public void supprimerparent(Staff f)
    {
        try {
            PreparedStatement pt =con.prepareStatement("DELETE FROM `Staff` WHERE `Staff`.`Id_staff` = ? ;" );
            pt.setInt(1,f.getId_staff());
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void FacturePdf() throws SQLException,FileNotFoundException,DocumentException,IOException 
    {
        Document doc = new Document();
        
       
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from staff");
        PdfWriter.getInstance(doc, new FileOutputStream("c:/pdf/Resultat.pdf"));
        
        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Resultat de la Competition  "));
        doc.add(new Paragraph("   "));
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase("Nom staff",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Prenom Staff",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Poste",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        
        
       

        
        
        
        
        
        
        
     while (rs.next()) {                
            
               String nom_membre=rs.getString("Nom_staff");
               String prenom_membre=rs.getString("Prenom_staff");
               String poste=rs.getString("Poste");
                  
               
            
               
                 
               
               //Conversion to String
              /*
               String nom  = nom.toString();
               String prenom  = prenom.toString();
*/
              
         
               
               
               
               
               cell = new PdfPCell(new Phrase(nom_membre,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(prenom_membre,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(poste,FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(BaseColor.GRAY);
               table.addCell(cell);
        
        
        
               
              
        
                        }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File ("c:/pdf/Resultat.pdf"));
            }
    
}
 /*public boolean delete(Jardin j) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(Jardin t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    

