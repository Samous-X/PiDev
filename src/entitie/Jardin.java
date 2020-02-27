/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.util.ArrayList;

/**
 *
 * @author Dora
 */
public class Jardin {
    private int idjardin;
    
    private String nom;
    private String Adresse;
    private double lang; 
    private double lat;
    private int Prix_mois;

    public Jardin() {
    }
   
   
   /*Getters&Setters*/

    public Jardin(String nom, String Adresse, int Prix_mois) {
        this.nom = nom;
        this.Adresse = Adresse;
        this.Prix_mois = Prix_mois;
    }

    public int getIdjardin() {
        return idjardin;
    }
    public String getIdStr() {
    return Integer.toString(Prix_mois);
}
public void setId(String Prix_mois) throws NumberFormatException {
    this.Prix_mois = Integer.parseInt(Prix_mois); // Null check to be added 
}

    public void setIdjardin(int idjardin) {
        this.idjardin = idjardin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(float lang) {
        this.lang = lang;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }


   
   

    public int getPrix_mois() {
        return Prix_mois;
    }

    public void setPrix_mois(int Prix_mois) {
        this.Prix_mois = Prix_mois;
    }
  /*ToString*/

    @Override
    public String toString() {
        return "Jardin{" + "idjardin=" + idjardin + ", nom=" + nom + ", Adresse=" + Adresse + ", lang=" + lang + ", lat=" + lat + ", Prix_mois=" + Prix_mois + '}';
    }

  
    
  /*Equals*/
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jardin other = (Jardin) obj;
        if (this.nom != other.nom) {
            return false;
        }
        return true;
    }

    public Jardin(int idjardin, String nom, String Adresse, int Prix_mois) {
        this.idjardin = idjardin;
        this.nom = nom;
        this.Adresse = Adresse;
        this.Prix_mois = Prix_mois;
    }

   
    

    public Jardin(int idjardin, String nom, String Adresse, double lang, double lat, int Prix_mois) {
        this.idjardin = idjardin;
        this.nom = nom;
        this.Adresse = Adresse;
        this.lang = lang;
        this.lat = lat;
        
        this.Prix_mois = Prix_mois;
    }


    

 
    

}
