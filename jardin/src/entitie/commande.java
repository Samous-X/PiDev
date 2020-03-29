/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ACER-PC
 */
public class commande {
    int id_com;
    String date_com;
    Date  date_liv;
    String numcompte;
    int montant;

   

    @Override
    public String toString() {
        return "commande{" + "id_com=" + id_com + ", date_com=" + date_com + ", date_liv=" + date_liv + ", numcompte=" + numcompte + '}';
    }

    public commande(String date_com, Date date_liv, String numcompte) {
        this.date_com = date_com;
        this.date_liv = date_liv;
        this.numcompte = numcompte;
    }

    public commande(Date date_liv) {
        this.date_liv = date_liv;
    }

    public commande(String numcompte) {
        this.numcompte = numcompte;
    }
    

    public commande(String date_com, Date date_liv, String numcompte, int montant) {
        this.date_com = date_com;
        this.date_liv = date_liv;
        this.numcompte = numcompte;
        this.montant = montant;
    }

    public commande(int id_com, String date_com, Date date_liv, String numcompte, int montant) {
        this.id_com = id_com;
        this.date_com = date_com;
        this.date_liv = date_liv;
        this.numcompte = numcompte;
        this.montant = montant;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public void setDate_liv(Date date_liv) {
        this.date_liv = date_liv;
    }

    public void setNumcompte(String numcompte) {
        this.numcompte = numcompte;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getId_com() {
        return id_com;
    }

    public String getDate_com() {
        return date_com;
    }

    public Date getDate_liv() {
        return date_liv;
    }

    public String getNumcompte() {
        return numcompte;
    }

    public int getMontant() {
        return montant;
    }

    
   
    
    
    
    
}
