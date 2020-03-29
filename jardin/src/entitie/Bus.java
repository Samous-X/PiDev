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
public class Bus {
    private int id_bus;
    private String Immat;
    private String ligne;
    private String horaire;
    private String chauffeur;
    private int nbrplace;
    private String image;

    public Bus(String Immat, String ligne, String horaire, String chauffeur , int nbrplace,String image) {
        this.Immat = Immat;
        this.ligne = ligne;
        this.horaire = horaire;
        this.chauffeur = chauffeur;
        this.nbrplace = nbrplace;
        this.image = image;
    }

    public Bus() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public String getImmat() {
        return Immat;
    }

    public void setImmat(String Immat) {
        this.Immat = Immat;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(String chauffeur) {
        this.chauffeur = chauffeur;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    @Override
    public String toString() {
        return "Bus Recherchee : || " + "Immat  : " + Immat + " || ligne : " + ligne + " || horaire : " + horaire + " || chauffeur : " + chauffeur + " || nbrplace : " + nbrplace + " ||";
    }

    

    
}
