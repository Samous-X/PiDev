<?php

namespace eventBundle\Controller;


use eventBundle\Entity\favoris;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Knp\Component\Pager\PaginatorInterface;
use eventBundle\Entity\event;
use UserBundle\Entity\User;

class favorisController extends Controller
{
    public function AddfavorisAction($id)
    {

        $em = $this->getDoctrine()->getManager();
        $favoris = new favoris();
        $user = $em->getRepository(User::class)->find($this->getUser());
        $event = $em->getRepository(event::class)->find($id);
        $test=$em->getRepository(favoris::class)->findBy(['idUser' => $this->getUser(),'idEvent' => $id]);
        if ($test) {
            return $this->redirectToRoute('event_Front_Affiche');
        }
        else{
            $favoris->setIdEvent($event);
            $favoris->setIdUser($user);



            $em->persist($favoris);
            $em->flush();

            return $this->redirectToRoute('favoris_Front_Affiche');
        }
        return $this->redirectToRoute('event_Front_Affiche');


    }
    public function ListfavorisFrontAction(Request $request)
    {


        $m = $this->getDoctrine()->getManager();
        $favoris = $m->getRepository("eventBundle:favoris")->findBy(['idUser' => $this->getUser()]);
        $paginator=$this->get('knp_paginator');
        $result=$paginator->paginate($favoris,
            $request->query->getInt('page',1),
            $request->query->getInt('limit',6));


        return $this->render('eventBundle:event:AfficheFrontfavoris.html.twig', array(
            'favoris' => $result
        ));
    }
    public function favorisSupprimeAction($id)
    {

        $em = $this->getDoctrine()->getManager();

        $event = $em->getRepository("eventBundle:favoris")->find($id);
        $em->remove($event);
        $em->flush();



        return $this->redirectToRoute('favoris_Front_Affiche');
    }
}


