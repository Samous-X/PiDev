/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_evennement;
import service.eventService;
import entity.event;
import entity.participant;
import java.util.List;
import service.participantService;

/**
 *
 * @author ahmed
 */
public class Gestion_evennement {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    
    public static void main(String[] args) throws ClassNotFoundException {
        eventService P = new eventService();
        participantService Q = new participantService();
              String date = "2016-11-03";
              String temp ="12:30:20";
    java.sql.Date javaSqlDate = java.sql.Date.valueOf(date);
    java.sql.Time javaSqlTime = java.sql.Time.valueOf(temp);
        event a = new event(5,"baha","baha",javaSqlDate,javaSqlTime,javaSqlTime, (float) 5.5,"img");
       // P.modifierevent(a);     
        //P.ajouterevent(a);
       //P.supprimerevent(0);
//       List<event> list= P.afficherevent(a);
//       System.out.println(list);
        participant b = new participant(4,5,1,4);
      Q.ajoutparticipant(b);
      //Q.supprimerparticipant(3);
      //Q.modifierparticipant(b);
      //System.out.println(Q.listparticipant(5));
      
        //System.out.println(P.findByNom("baha"));
    }
    
}
