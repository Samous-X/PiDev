/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

/**
 *
 * @author LENOVO-PC
 */


public class publication {
    
    public int id;
    private String texte;
    private String date;
    private int score;
    private String categorie;
    private String image;
    private int id_parent;
    private String nom;

    public publication(int id, String texte, String date, int score, String categorie, String image, String nom) {
        this.id = id;
        this.texte = texte;
        this.date = date;
        this.score = score;
        this.categorie = categorie;
        this.image = image;
        this.nom=nom;
    }

    public publication(String texte, String date, int score, String categorie, String image, String nom) {
        this.texte = texte;
        this.date = date;
        this.score = score;
        this.categorie = categorie;
        this.image = image;
       
        
    }
    

   

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
  

    public void setId(int id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public String getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public publication(int id, String texte, String date, int score, String categorie) {
        this.id = id;
        this.texte = texte;
        this.date = date;
        this.score = score;
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public publication() {
    }

    public publication(String texte, String date, int score, String categorie, String image) {
      
        this.texte = texte;
        this.date = date;
        this.score = score;
        this.categorie = categorie;
        this.image = image;
    }

    public publication(String texte, String date, int score, String categorie) {
        
        this.texte = texte;
        this.date = date;
      
        this.score = score;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "publication{" + "id=" + id + ", texte=" + texte + ", date=" + date + ", score=" + score + ", categorie=" + categorie + ", image=" + image + ", nom=" + nom + '}';
    }

    
}