/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

/**
 *
 * @author Hejer Ghariani
 */
public class Parent {
    private int id_parent;
    private String nom;
    private String prenom;
    private String email;
    private String photo;
    private int tel;
    private String login;
    private String password;

    public Parent(int id_parent, String nom, String prenom, String email, String photo, int tel, String login, String password) {
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
        this.login = login;
        this.password = password;
    }
    
    

    public Parent(String nom, String prenom, String email, String photo, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.photo = photo;
        this.tel = tel;
    }

    public Parent(int id_parent, String nom, String prenom, String email, String photo, int tel) {
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.photo = photo;
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

    @Override
    public String toString() {
        return "Parent{" + "id_parent=" + id_parent + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", photo=" + photo + ", tel=" + tel + ", login=" + login + ", password=" + password + '}';
    }

    

    
    
    
    
}
