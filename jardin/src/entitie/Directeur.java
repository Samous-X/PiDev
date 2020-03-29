/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hejer Ghariani
 */
public class Directeur extends Utilisateur {
    private static final Map<Integer, Directeur> DIRECTEUR = new HashMap<>();
    
    
    public Directeur(){
        super();
    }
    public Directeur(int id_utilisateur){
    super();
    }
    public Directeur(int id_utilisateur, String nom, String password, String email, int tel, String Login) {
        super();
    }
    public Directeur(int id_utilisateur, String nom, String password, String email, int tel,String Login, String role) {
        super();
    }
    public Directeur(String nom, String password, String email, int tel, String Login) {
        super();
    }
    public Directeur(String nom, String password, String email, int tel, String Login, String role) {
        super();
    }

    @Override
    public void setRole(String role) {
        super.setRole(role); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLogin(String Login) {
        super.setLogin(Login); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTel(int tel) {
        super.setTel(tel); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId_utilisateur(int id_utilisateur) {
        super.setId_utilisateur(id_utilisateur); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRole() {
        return super.getRole(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLogin() {
        return super.getLogin(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTel() {
        return super.getTel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom() {
        return super.getNom(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId_utilisateur() {
        return super.getId_utilisateur(); //To change body of generated methods, choose Tools | Templates.
    }
   public static Directeur of(int id_utilisateur) {
        Directeur directeur = DIRECTEUR.get(id_utilisateur);
        if (directeur == null) {
            directeur = new Directeur(id_utilisateur);
            DIRECTEUR.put(id_utilisateur, directeur);
        }
        return directeur;
    }


    
    
}
