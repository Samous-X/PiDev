<?php

namespace eventBundle\Controller;


use eventBundle\Entity\event;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Knp\Component\Pager\PaginatorInterface;

class eventController extends Controller
{
    public function AddeventAction( \Symfony\Component\HttpFoundation\Request $request)
    {

        $em = $this->getDoctrine()->getManager();
        $event = new event();
        $form = $this->createForm('eventBundle\Form\eventType', $event);
        $form->handleRequest($request);
        $now=new \DateTime('now');
        if ($form->isSubmitted() && $now<=$event->getDateevent()){
            $em->persist($event);
            $em->flush();




            return $this->redirectToRoute('Ajoutevent');
        }

        return $this->render('eventBundle:event:ajoutevent.html.twig', array(
            'event' => $event,
            'form' => $form->createView(),

        ));
    }
    public function ListeventFrontAction(Request $request)
    {


        $m = $this->getDoctrine()->getManager();
        $event = $m->getRepository("eventBundle:event")->findAll();
        if ($request->isMethod('POST'))
        {    $repository=$this->getDoctrine()->getManager()->getRepository(event::class);
            if ($request->get('rechercher'))
            {

                $titre=$request->get('titre');

                $event=$repository->rechercher($titre);
                $paginator=$this->get('knp_paginator');
                $result=$paginator->paginate($event,
                    $request->query->getInt('page',1),
                    $request->query->getInt('limit',6));
                return $this->render('eventBundle:event:AfficheFrontevent.html.twig', array(
                    'event' => $result
                ));            }

        }
        $paginator=$this->get('knp_paginator');
        $result=$paginator->paginate($event,
            $request->query->getInt('page',1),
            $request->query->getInt('limit',6));


        return $this->render('eventBundle:event:AfficheFrontevent.html.twig', array(
            'event' => $result
        ));
    }
    public function ListeventAction()
    {


        $m = $this->getDoctrine()->getManager();
        $event = $m->getRepository("eventBundle:event")->findAll();


        return $this->render('eventBundle:event:listevent.html.twig', array(
            'event' => $event

        ));

    }
    public function SupprimeAction($id)
    {

        $em = $this->getDoctrine()->getManager();

        $event = $em->getRepository("eventBundle:event")->find($id);
        $em->remove($event);
        $em->flush();



        return $this->redirectToRoute('list_event');
    }
    public function editeventAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $event = $em->getRepository('eventBundle:event')->find($id);
        $editForm = $this->createForm('eventBundle\Form\eventType', $event);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {

            $em->persist($event);
            $em->flush();

            return $this->redirectToRoute('list_event');
        }
        $em = $this->getDoctrine()->getManager();

        return $this->render('eventBundle:event:editevent.html.twig', array(
            'event' => $event,
            'form' => $editForm->createView(),
        ));
    }
}
