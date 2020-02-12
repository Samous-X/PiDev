/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ahmed
 */
public class partlist {
    private String nom ;
     private String prenom ;
      private int tel ;
      private int nombre_enfant;
      private String mail ;

    public partlist(String nom, String prenom, int tel, int nombre_enfant, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.nombre_enfant = nombre_enfant;
        this.mail = mail;
    }

    public partlist() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getTel() {
        return tel;
    }

    public int getNombre_enfant() {
        return nombre_enfant;
    }

    public String getMail() {
        return mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setNombre_enfant(int nombre_enfant) {
        this.nombre_enfant = nombre_enfant;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "partlist{" + "nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", nombre_enfant=" + nombre_enfant + ", mail=" + mail + '}';
    }
      
      
      
    
}
