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
public class Enfant {
    private int id_enfant;
    private String nom;
    private String prenom;
    private int age;
    private String photo;
    private int id_parent;
    private String vaccin;
    private String alergie;
    private Paarent parent;
    private int idjardin;
    private String email;

    public Enfant() {
    }
    
    
    

    public Enfant(int id_enfant, String nom, String prenom, int age, String photo, int id_parent, String vaccin, String alergie) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.photo = photo;
        this.id_parent = id_parent;
        this.vaccin = vaccin;
        this.alergie = alergie;
    }
    public Enfant(int id_enfant, String nom, String prenom, int age, String photo, int id_parent, String vaccin, String alergie,String email) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.photo = photo;
        this.id_parent = id_parent;
        this.vaccin = vaccin;
        this.alergie = alergie;
        this.email=email;
    }
    
    

    public Enfant(int id_enfant, String nom, String prenom, int age, String photo, int id_parent, String vaccin, String alergie, Paarent parent, int idjardin,String email) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.photo = photo;
        this.id_parent = id_parent;
        this.vaccin = vaccin;
        this.alergie = alergie;
        this.parent = parent;
        this.idjardin = idjardin;
        
    }

    public Enfant(int id_enfant, String nom, String prenom, int age, String photo, int id_parent, String vaccin, String alergie, int idjardin ,String email) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.photo = photo;
        this.id_parent = id_parent;
        this.vaccin = vaccin;
        this.alergie = alergie;
        this.idjardin = idjardin;
        this.email=email;
    }

    public int getIdjardin() {
        return idjardin;
    }

    public void setIdjardin(int idjardin) {
        this.idjardin = idjardin;
    }
    
    

    public Enfant(String nom, String prenom, int age, String photo, int id_parent, String vaccin, String alergie, int  idjardin) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.photo = photo;
        this.id_parent = id_parent;
        this.vaccin = vaccin;
        this.alergie = alergie;
        this.idjardin = idjardin;
    }

 
    

    public Enfant(String nom, String prenom, int age, String photo, int id_parent, String vaccin, String alergie) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.photo = photo;
        this.id_parent = id_parent;
        this.vaccin = vaccin;
        this.alergie = alergie;
    }
    

    public int getId_enfant() {
        return id_enfant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }

    public int getId_parent() {
        return id_parent;
    }

    public String getVaccin() {
        return vaccin;
    }

    public String getAlergie() {
        return alergie;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setVaccin(String vaccin) {
        this.vaccin = vaccin;
    }

    public void setAlergie(String alergie) {
        this.alergie = alergie;
    }

    @Override
    public String toString() {
        return "Enfant{" + "id_enfant=" + id_enfant + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", photo=" + photo + ", id_parent=" + id_parent + ", vaccin=" + vaccin + ", alergie=" + alergie + ", idjardin=" + idjardin + ", email=" + email + '}';
    }

    
    
    
    
    
}
