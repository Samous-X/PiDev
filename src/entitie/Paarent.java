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
public class Paarent {
    private static final Map<Integer, Paarent> PARENTS = new HashMap<>();
    private int id_parent;
    private String nom;
    private String prenom;
    private int cin;
    private String email;
    private String photo;
    private int tel;
    private String login;
    private String password;
    private boolean etat;
    private Date created_on;

    public Paarent() {
    }
    public Paarent(int id_parent) {
        this.id_parent = id_parent;
    }

    public Paarent(String email) {
        this.email = email;
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
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.tel = tel;
        this.login = login;
        this.password = password;
    }
    

    public Paarent(int id_parent, String nom, String prenom,int cin, String email,  String photo, int tel, String login, String password, boolean etat, Date created_on) {
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
        this.login = login;
        this.password = password;
        this.etat = etat;
        this.created_on = created_on;
    }

    

    public Paarent(String nom, String prenom,int cin, String email,  String photo, int tel, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
        this.login = login;
        this.password = password;
    }

    public Paarent(String nom, String prenom, int cin, String email, String photo, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
    }
    

    public Paarent(int id_parent, String nom, String prenom,int cin, String email, String photo, int tel, String login, String password) {
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
        this.login = login;
        this.password = password;
    }
    

    public Paarent(int id_parent, String nom, String prenom,int cin, String email,  String photo, int tel) {
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
    }

    public Paarent(int id_parent, String nom, String prenom, int cin, String email, int tel) {
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.tel = tel;
    }

   
    
    
    public int getId_parent() {
        return id_parent;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public int getTel() {
        return tel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getCin() {
        return cin;
    }

    public boolean isEtat() {
        return etat;
    }

    public Date getCreated_on() {
        return created_on;
    }
    

    
    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }
    
    
    


    @Override
    public String toString() {
        return "Parent{" + "id_parent=" + id_parent + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", cin=" + cin + ", photo=" + photo + ", tel=" + tel + ", login=" + login + ", password=" + password + ", etat=" + etat + ", created_on=" + created_on + '}';
    }
    

    

}
