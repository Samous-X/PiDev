/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.util.Objects;

/**
 *
 * @author Dora
 */
public class Staff {
    
    private int id_staff;
    private String Nom_staff;
    private String Prenom_staff;
    private String Poste; 
    private int idjardin;
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }


    public int getIdjardin() {
        return idjardin;
    }

    public void setIdjardin(int idjardin) {
        this.idjardin = idjardin;
    }

   

    public Staff(int id_staff, int IdJardin, String Nom_staff, String Prenom_staff, String Poste) {
        this.id_staff = id_staff;
        this.idjardin = idjardin;
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
    }

    public Staff(String Nom_staff, String Prenom_staff, String Poste, String Status) {
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
        this.Status = Status;
    }
    

    public Staff(int id_staff, String Nom_staff, String Prenom_staff, String Poste, String Status) {
        this.id_staff = id_staff;
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
        this.Status = Status;
    }
    

    public Staff(String Nom_staff, String Prenom_staff, String Poste, int idjardin, String Status) {
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
        this.idjardin = idjardin;
        this.Status = Status;
    }

    public Staff(int id_staff, String Nom_staff, String Prenom_staff, String Poste, int idjardin, String Status) {
        this.id_staff = id_staff;
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
        this.idjardin = idjardin;
        this.Status = Status;
    }
    

    public Staff(int id_staff, String Nom_staff, String Prenom_staff, String Poste) {
        this.id_staff = id_staff;
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
    }

    public Staff(String Nom_staff, String Prenom_staff, String Poste) {
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
    }

    public Staff(String Nom_staff, String Prenom_staff, String Poste, int idjardin) {
        this.Nom_staff = Nom_staff;
        this.Prenom_staff = Prenom_staff;
        this.Poste = Poste;
        this.idjardin = idjardin;
    }
    

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public String getNom_staff() {
        return Nom_staff;
    }

    public void setNom_staff(String Nom_staff) {
        this.Nom_staff = Nom_staff;
    }

    public String getPrenom_staff() {
        return Prenom_staff;
    }

    public void setPrenom_staff(String Prenom_staff) {
        this.Prenom_staff = Prenom_staff;
    }

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String Poste) {
        this.Poste = Poste;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id_staff;
        hash = 23 * hash + Objects.hashCode(this.Nom_staff);
        return hash;
    }

    @Override
    public String toString() {
        return "Staff{" + "id_staff=" + id_staff + ", idjardin=" + idjardin + ", Nom_staff=" + Nom_staff + ", Prenom_staff=" + Prenom_staff + ", Poste=" + Poste + '}';
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
        final Staff other = (Staff) obj;
        if (this.id_staff != other.id_staff) {
            return false;
        }
        if (!Objects.equals(this.Nom_staff, other.Nom_staff)) {
            return false;
        }
        return true;
    }

    public Staff() {
    }
    
    
}
