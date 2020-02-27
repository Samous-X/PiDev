/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entitie.event;
import java.sql.ResultSet;
import java.util.List;


/**
 *
 * @author ahmed
 */
public interface Ievent 
{
    public void  ajouterevent(event p);
    public void modifierevent(event p);
    public void supprimerevent(int id);
    public ResultSet afficherevent(int id);
    public List<event> findByNom(String nom);
    public List<event> listevent();
}
