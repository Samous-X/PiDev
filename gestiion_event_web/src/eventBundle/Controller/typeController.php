<?php

namespace eventBundle\Controller;
use eventBundle\Entity\type;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

use eventBundle\Entity\event;

use Knp\Component\Pager\PaginatorInterface;

class typeController extends Controller
{
    public function AddtypeAction( \Symfony\Component\HttpFoundation\Request $request)
    {

        $em = $this->getDoctrine()->getManager();
        $type = new type();
        $form = $this->createForm('eventBundle\Form\typeType', $type);
        $form->handleRequest($request);

        if ($form->isSubmitted() ){
            $em->persist($type);
            $em->flush();




            return $this->redirectToRoute('Ajouttype');
        }

        return $this->render('eventBundle:event:ajouttype.html.twig', array(
            'type' => $type,
            'form' => $form->createView(),

        ));
    }
    public function ListtypeAction()
    {


        $m = $this->getDoctrine()->getManager();
        $type = $m->getRepository("eventBundle:type")->findAll();


        return $this->render('eventBundle:event:listtype.html.twig', array(
            'type' => $type

        ));

    }

    public function SupprimeAction($id)
    {

        $em = $this->getDoctrine()->getManager();

        $type = $em->getRepository("eventBundle:type")->find($id);
        $em->remove($type);
        $em->flush();



        return $this->redirectToRoute('list_type');
    }
    public function edittypeAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $type = $em->getRepository('eventBundle:type')->find($id);
        $editForm = $this->createForm('eventBundle\Form\typeType', $type);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {

            $em->persist($type);
            $em->flush();

            return $this->redirectToRoute('list_type');
        }
        $em = $this->getDoctrine()->getManager();

        return $this->render('eventBundle:event:edittype.html.twig', array(
            'type' => $type,
            'form' => $editForm->createView(),
        ));
    }
}
