<?php


namespace JardinBundle\Controller;


use JardinBundle\Entity\Categorie;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class CategorieController extends Controller
{

    public function AjoutCategorieAction(Request $request)
    {

        $em = $this->getDoctrine()->getManager();
        $categorie = new Categorie();
        $form = $this->createForm('JardinBundle\Form\CategorieType', $categorie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em->persist($categorie);
            $em->flush();

            return $this->redirectToRoute('categorie_Affiche');
        }
        return $this->render('JardinBundle:Categorie:AjoutCategorie.html.twig', array(
            'form' => $form->createView(),
        ));

    }

    public function AfficheCategorieAction(Request $request)
    {


        $m = $this->getDoctrine()->getManager();
        $Categorie = $m->getRepository("JardinBundle:Categorie")->findAll();
        /**
         * @var $paginator \Knp\Component\Pager\Paginator
         */
        $paginator = $this->get('knp_paginator');
        $result = $paginator->paginate(
            $Categorie,
            $request->query->getInt('page',1),
            $request->query->getInt('limit',10)

        );


        return $this->render('JardinBundle:Categorie:AfficherCategorie.html.twig', array(
            'cat' => $result
        ));
    }


    public function deleteCategorieAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $Categorie = $em->getRepository('JardinBundle:Categorie')->find($id);
        $em->remove($Categorie);
        $em->flush();
        return $this->redirectToRoute('categorie_Affiche');
    }

    public function ModifierCategorieAction(\Symfony\Component\HttpFoundation\Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $categorie = $em->getRepository('JardinBundle:Categorie')->find($id);
        $editForm = $this->createForm('JardinBundle\Form\CategorieType', $categorie);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {

            $em->persist($categorie);
            $em->flush();

            return $this->redirectToRoute('categorie_Affiche');
        }
        $em = $this->getDoctrine()->getManager();

        return $this->render('JardinBundle:Categorie:ModifierCategorie.html.twig', array(
            'cat' => $categorie,
            'form' => $editForm->createView(),
        ));
    }
}