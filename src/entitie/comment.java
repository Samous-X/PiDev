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
public class comment {

private int idc;
private String textec;
private String datec;
private String id;

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setTextec(String textec) {
        this.textec = textec;
    }

    public void setDatec(String datec) {
        this.datec = datec;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdc() {
        return idc;
    }

    public String getTextec() {
        return textec;
    }

    public String getDatec() {
        return datec;
    }

    public String getId() {
        return id;
    }

    public comment(String textec, String datec) {
        
        this.textec = textec;
        this.datec = datec;
        
    }
    public comment(String textec, String datec, String id) {
        
        this.textec = textec;
        this.datec = datec;
        this.id = id;
        
    }
    
}
