/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

/**
 *
 * @author ACER-PC
 */
public class store {
    int idstore;
    String nom_store;

    public store(int idstore, String nom_store) {
        this.idstore = idstore;
        this.nom_store = nom_store;
    }

    public store(String nom_store) {
        this.nom_store = nom_store;
    }

    public String getNom_store() {
        return nom_store;
    }

    public void setNom_store(String nom_store) {
        this.nom_store = nom_store;
    }
    
    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }

    public int getIdstore() {
        return idstore;
    }


    @Override
    public String toString() {
        return "store{" + "idstore=" + idstore + ", nom_store=" + nom_store + '}';
    }

    
}
