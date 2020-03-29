/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;
import entitie.Produit;
import java.util.ArrayList;

/**
 *
 * @author ACER-PC
 */
public class panier {
    int idpanier;
    int idproduit;
    int id_parent;
    int qte_prod;
    int prix_prod;
    Produit p=new Produit();
  //  int prixprod=p.getPrix_prod();
    
    

   
    public panier(int idpanier, int idproduit, int id_parent, int qte_prod) {
        this.idpanier = idpanier;
        this.idproduit = idproduit;
        this.id_parent = id_parent;
        this.qte_prod = qte_prod;
    }

    public panier(int idpanier, int idproduit, int id_parent, int qte_prod, int prix_prod) {
        this.idpanier = idpanier;
        this.idproduit = idproduit;
        this.id_parent = id_parent;
        this.qte_prod = qte_prod;
        this.prix_prod = prix_prod;
    }

    public panier(int prix_prod) {
        this.prix_prod=prix_prod; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "panier{" + "idpanier=" + idpanier + ", idproduit=" + idproduit + ", id_parent=" + id_parent + ", qte_prod=" + qte_prod + ", p=" + p + '}';
    }
    

    public panier(int idproduit, int id_parent, int prix_prod) {
        this.idproduit = idproduit;
        this.id_parent = id_parent;
        this.prix_prod = prix_prod;
    }
   
    
    

    public panier() {
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setQte_prod(int qte_prod) {
        this.qte_prod = qte_prod;
    }

    public int getIdpanier() {
        return idpanier;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public int getId_parent() {
        return id_parent;
    }

    public int getQte_prod() {
        return qte_prod;
    }

    public panier(int idproduit, int id_parent) {
        this.idproduit = idproduit;
        this.id_parent = id_parent;
    }

    public void setPrix_prod(int prix_prod) {
        this.prix_prod = prix_prod;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public int getPrix_prod() {
        return prix_prod;
    }

    public Produit getP() {
        return p;
    }

   
    
}
