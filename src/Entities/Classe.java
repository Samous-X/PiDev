/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author chadi
 */
public class Classe {
    private int id ;
    private String nom_classe;
    private int niveau_classe;
    private String enfant;
    private int nombre;

    public Classe(String nom_classe, int niveau_classe, String enfant, int nombre) {
        
        this.nom_classe = nom_classe;
        this.niveau_classe = niveau_classe;
        this.enfant = enfant;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public int getNiveau_classe() {
        return niveau_classe;
    }

    public String getEnfant() {
        return enfant;
    }

    public int getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public void setNiveau_classe(int niveau_classe) {
        this.niveau_classe = niveau_classe;
    }

    public void setEnfant(String enfant) {
        this.enfant = enfant;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", nom_classe=" + nom_classe + ", niveau_classe=" + niveau_classe + ", enfant=" + enfant + ", nombre=" + nombre + '}';
    }
                                
    
}
