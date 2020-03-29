/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

/**
 *
 * @author chadi
 */
public class Reservation {
    private int id_res;
    private String nom_p;
    private String type;
    private String immatriculation;
    private String date_debut;
    private String date_fin;
    private String enfant;   
    private int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Reservation(String nom_p, String type, String date_debut, String date_fin) {
        this.nom_p = nom_p;
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Reservation( String nom_p, String type, String ligne_r, String date_debut, String date_fin) {
        
        this.nom_p = nom_p;
        this.type = type;
        this.immatriculation = immatriculation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public String getEnfant() {
        return enfant;
    }

    public void setEnfant(String enfant) {
        this.enfant = enfant;
    }
    


    public Reservation() {
    }

    public String getimmatriculation() {
        return immatriculation;
    }

    public void setimmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }


    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  
    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
}
