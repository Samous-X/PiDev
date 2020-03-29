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
public class Produit {
    int idproduit;
    String nomproduit;
    int prix_prod;
    String img_prod;
    int qte;

    public Produit(int idproduit, String nomproduit, int prix_prod, String img_prod, int qte) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.prix_prod = prix_prod;
        this.img_prod = img_prod;
        this.qte = qte;
    }

    public Produit(int prix_prod) {
        this.prix_prod = prix_prod;
    }

    public Produit() {
    }

    public Produit(String nomproduit, int prix_prod, String img_prod, int qte) {
        this.nomproduit = nomproduit;
        this.prix_prod = prix_prod;
        this.img_prod = img_prod;
        this.qte = qte;
    }

    public Produit(String nomproduit, int prix_prod, int qte) {
        this.nomproduit = nomproduit;
        this.prix_prod = prix_prod;
        this.qte = qte;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public int getPrix_prod() {
        return prix_prod;
    }

    public String getImg_prod() {
        return img_prod;
    }

    public int getQte() {
        return qte;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public void setPrix_prod(int prix_prod) {
        this.prix_prod = prix_prod;
    }

    public void setImg_prod(String img_prod) {
        this.img_prod = img_prod;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Produit{" + "idproduit=" + idproduit + ", nomproduit=" + nomproduit + ", prix_prod=" + prix_prod + ", img_prod=" + img_prod + ", qte=" + qte + '}';
    }
    

   
}
