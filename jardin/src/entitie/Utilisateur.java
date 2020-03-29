/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hejer Ghariani
 */
public abstract class Utilisateur {
    protected int id_utilisateur;
    protected String nom;
    protected String password;
    protected String email;
    protected int tel;
    protected String Login;
    protected String role;
    private static final Map<Integer, Utilisateur> UTILISATEUR = new HashMap<>();

    public Utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String nom, String password, String email, int tel, String Login) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.Login = Login;
    }

   

    public Utilisateur(int id_utilisateur, String nom, String password, String email, int tel,String Login, String role) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.Login=Login;
        this.role = role;
    }

    public Utilisateur(String nom, String password, String email, int tel, String Login) {
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.Login = Login;
    }
    

    
    public Utilisateur(String nom, String password, String email, int tel, String Login, String role) {
        this.nom = nom;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.Login = Login;
        this.role = role;
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

    public String getLogin() {
        return Login;
    }

    public String getRole() {
        return role;
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

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setRole(String role) {
        this.role = role;
    }
   /* public static Utilisateur of(int id_utilisateur) {
        Utilisateur utilisateur = UTILISATEUR.get(id_utilisateur);
        if (utilisateur == null) {
            utilisateur = new Utilisateur(id_utilisateur) {};
            UTILISATEUR.put(id_utilisateur, utilisateur);
        }
        return utilisateur;
    }*/
    
    
    
    
}
