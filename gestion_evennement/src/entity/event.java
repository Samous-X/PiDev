/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author ahmed
 */
public class event {

    private int id_event;
    private String nom_event;
    private String desc;
    private Date date_event;
    private Time heureD;
    private Time heureF;
    private float prix_event;
    private String img;

    @Override
    public String toString() {
        return "event{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", desc=" + desc + ", date_event=" + date_event + ", heureD=" + heureD + ", heureF=" + heureF + ", prix_event=" + prix_event + ", img=" + img + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_event;
        hash = 97 * hash + Objects.hashCode(this.nom_event);
        hash = 97 * hash + Objects.hashCode(this.desc);
        hash = 97 * hash + Objects.hashCode(this.date_event);
        hash = 97 * hash + Objects.hashCode(this.heureD);
        hash = 97 * hash + Objects.hashCode(this.heureF);
        hash = 97 * hash + Float.floatToIntBits(this.prix_event);
        hash = 97 * hash + Objects.hashCode(this.img);
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
        final event other = (event) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        if (Float.floatToIntBits(this.prix_event) != Float.floatToIntBits(other.prix_event)) {
            return false;
        }
        if (!Objects.equals(this.nom_event, other.nom_event)) {
            return false;
        }

        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.date_event, other.date_event)) {
            return false;
        }
        if (!Objects.equals(this.heureD, other.heureD)) {
            return false;
        }
        if (!Objects.equals(this.heureF, other.heureF)) {
            return false;
        }
        return true;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public Time getHeureD() {
        return heureD;
    }

    public void setHeureD(Time heureD) {
        this.heureD = heureD;
    }

    public Time getHeureF() {
        return heureF;
    }

    public void setHeureF(Time heureF) {
        this.heureF = heureF;
    }

    public float getPrix_event() {
        return prix_event;
    }

    public void setPrix_event(float prix_event) {
        this.prix_event = prix_event;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public event(String nom_event, String desc, Date date_event, Time heureD, Time heureF, float prix_event, String img) {
        this.nom_event = nom_event;

        this.desc = desc;
        this.date_event = date_event;
        this.heureD = heureD;
        this.heureF = heureF;
        this.prix_event = prix_event;
        this.img = img;
    }

    public event(int id_event, String nom_event, String desc, Date date_event, Time heureD, Time heureF, float prix_event, String img) {
        this.id_event = id_event;
        this.nom_event = nom_event;

        this.desc = desc;
        this.date_event = date_event;
        this.heureD = heureD;
        this.heureF = heureF;
        this.prix_event = prix_event;
        this.img = img;
    }

    public event() {
        this.id_event = 0;
        this.nom_event = " ";
        this.desc = " ";
        this.prix_event = 0;
        this.img = " ";
    }

}
