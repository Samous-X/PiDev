/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Hejer Ghariani
 */
public class Utilisateur {
    private int id_utilisateur;
    private String nom;
    private String password;
    private String email;
    private int tel;
    private String adresse;

    public Utilisateur(int id_utilisateur, String nom, String password, String email, int tel, String adresse) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
    }

    public Utilisateur(String nom, String password, String email, int tel, String adresse) {
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
}
