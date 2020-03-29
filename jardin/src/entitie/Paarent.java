/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hejer Ghariani
 */
public class Paarent extends Utilisateur{
    private static final Map<Integer, Paarent> PARENTS = new HashMap<>();
    /*private int id_parent;//
    private String nom;//
    private String email;//
    private int tel;//
    private String login;//
    private String password;//*/
    private String prenom;
    private int cin;
    private boolean etat;
    private Date created_on;
    private String photo;

    public Paarent() {
    }
    public Paarent(int id_parent) {
        super.id_utilisateur=id_parent;
    }

    public Paarent(String email) {
        super.email=email;
    }
    
    
      public static Paarent of(int id_parent) {
        Paarent parent = PARENTS.get(id_parent);
        if (parent == null) {
            parent = new Paarent(id_parent);
            PARENTS.put(id_parent, parent);
        }
        return parent;
    }

    public Paarent(int id_parent, String nom, String prenom, int cin, String email, int tel, String login, String password) {
        super.id_utilisateur = id_parent;
        super.nom = nom;
        super.email = email;
        super.Login = login;
        super.tel = tel;
        super.password = password;
        this.prenom = prenom;
        this.cin = cin;
        
        
        
        
        
    }
    
    

    public Paarent(int id_parent, String nom, String prenom,int cin, String email,  String photo, int tel, String login, String password, boolean etat, Date created_on) {
        super.id_utilisateur  = id_parent;
        super.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        super.email = email;
        this.photo = photo;
        super.tel = tel;
        super.Login = login;
        super.password = password;
        this.etat = etat;
        this.created_on = created_on;
        
        
        
    }

    

    public Paarent(String nom, String prenom,int cin, String email,  String photo, int tel, String login, String password) {
        super.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        super.email = email;
        this.photo = photo;
        super.tel = tel;
        super.Login = login;
        super.password = password;
        
        
    }

    public Paarent(String nom, String prenom, int cin, String email, String photo, int tel) {
        super.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        super.email = email;
        this.photo = photo;
        super.tel = tel;
        
        
    }
    

    public Paarent(int id_parent, String nom, String prenom,int cin, String email, String photo, int tel, String login, String password) {
        super.id_utilisateur = id_parent;
        super.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        super.email = email;
        this.photo = photo;
        super.tel = tel;
        super.Login = login;
        super.password = password;
        
    }
    

    public Paarent(int id_parent, String nom, String prenom,int cin, String email,  String photo, int tel) {
        super.id_utilisateur = id_parent;
        super.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        super.email = email;
        this.photo = photo;
        super.tel = tel;
        
    }

    public Paarent(int id_parent, String nom, String prenom, int cin, String email, int tel) {
        super.id_utilisateur = id_parent;
        super.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        super.email = email;
        super.tel = tel;
        
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    

   


    @Override
    public String toString() {
        return "Parent{" + "id_parent=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", cin=" + cin + ", photo=" + photo + ", tel=" + tel + ", login=" + Login + ", password=" + password + ", etat=" + etat + ", created_on=" + created_on + '}';
    }
    

    

}
