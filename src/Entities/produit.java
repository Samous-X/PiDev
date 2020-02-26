/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Dora
 */
public class produit {
    private int idproduit;
    private String nomproduit;
    private String image_prod;
    private int prix_prod;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getImage_prod() {
        return image_prod;
    }

    public void setImage_prod(String image_prod) {
        this.image_prod = image_prod;
    }

    public int getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(int prix_prod) {
        this.prix_prod = prix_prod;
    }

    public produit(int idproduit, String nomproduit, String image_prod, int prix_prod) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.image_prod = image_prod;
        this.prix_prod = prix_prod;
    }

    public produit() {
    }

    public produit(String nomproduit, String image_prod, int prix_prod) {
        this.nomproduit = nomproduit;
        this.image_prod = image_prod;
        this.prix_prod = prix_prod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idproduit;
        hash = 97 * hash + Objects.hashCode(this.nomproduit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final produit other = (produit) obj;
        if (this.idproduit != other.idproduit) {
            return false;
        }
        if (!Objects.equals(this.nomproduit, other.nomproduit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produit{" + "idproduit=" + idproduit + ", nomproduit=" + nomproduit + ", image_prod=" + image_prod + ", prix_prod=" + prix_prod + '}';
    }
    
    
    
}
