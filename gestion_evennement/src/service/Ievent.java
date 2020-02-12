/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.event;
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
    public List<event> afficherevent(event p);
    public List<event> findByNom(String nom);
}
