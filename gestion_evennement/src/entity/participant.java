/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.*;

/**
 *
 * @author ahmed
 */
public class participant {
   private int id_participant;
   private int id_event;
   private int id_parent;
private int nombre_enfant;

    public participant(int id_participant, int id_event, int id_parent, int nombre_enfant) {
        this.id_participant = id_participant;
        this.id_event = id_event;
        this.id_parent = id_parent;
        this.nombre_enfant = nombre_enfant;
    }

    public participant() {
    }

    public participant(int id_event, int id_parent, int nombre_enfant) {
        this.id_event = id_event;
        this.id_parent = id_parent;
        this.nombre_enfant = nombre_enfant;
    }

    public int getId_participant() {
        return id_participant;
    }

    public int getId_event() {
        return id_event;
    }

    public int getId_parent() {
        return id_parent;
    }

    public int getNombre_enfant() {
        return nombre_enfant;
    }

    public void setId_participant(int id_participant) {
        this.id_participant = id_participant;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setNombre_enfant(int nombre_enfant) {
        this.nombre_enfant = nombre_enfant;
    }

    @Override
    public String toString() {
        return "participant{" + "id_event=" + id_event + ", id_parent=" + id_parent + ", nombre_enfant=" + nombre_enfant + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id_participant;
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
        final participant other = (participant) obj;
        if (this.id_participant != other.id_participant) {
            return false;
        }
        return true;
    }
    
    

     
    
}
