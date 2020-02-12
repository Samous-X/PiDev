/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import Entities.Classe;
import Services.ServiceClasse;
import Entities.Bus;
import Services.ServiceBus;
import Entities.Reservation;
import Services.ServiceReservation;
/**
 *
 * @author chadi
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Bus b2 = new Bus("100 Tunis 1555", "aaaaaa", "02:02:02", "aaaa",10);
               ServiceBus srv = new ServiceBus();
            //srv.ajouterbus(b2);
               //srv.modifierbus("chadi", 1);
              //srv.affichebus();
              //srv.supprimerBus("aa");
              
              Reservation r1 = new Reservation("ahmed", "aaa", "2003/05/02", "2004/05/02");
              ServiceReservation srv1 = new ServiceReservation();
              //srv1.ajouterres(r1, b2);
              //srv1.modifierres("complet", "ahmed");
             
             srv1.afficheres();
             //srv1.supprimerres(7);
             //srv1.afficheres();
             //srv1.count(b2);
             //srv.Rechercherbus(2);
             //srv.afficherbustrierparnbr();
             //srv1.Rechercherres(7);
    }
    
    
}
