<?php

namespace JardinBundle\Controller;

use JardinBundle\Entity\CatReclamation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;use Symfony\Component\HttpFoundation\Request;

/**
 * Catreclamation controller.
 *
 * @Route("catreclamation")
 */
class CatReclamationController extends Controller
{
    /**
     * Lists all catReclamation entities.
     *
     * @Route("/", name="catreclamation_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $catReclamations = $em->getRepository('JardinBundle:CatReclamation')->findAll();

        return $this->render('catreclamation/index.html.twig', array(
            'catReclamations' => $catReclamations,
        ));
    }

    /**
     * Creates a new catReclamation entity.
     *
     * @Route("/new", name="catreclamation_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $catReclamation = new Catreclamation();
        $form = $this->createForm('JardinBundle\Form\CatReclamationType', $catReclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($catReclamation);
            $em->flush();

            return $this->redirectToRoute('catreclamation_show', array('idCategorie' => $catReclamation->getIdcategorie()));
        }

        return $this->render('catreclamation/new.html.twig', array(
            'catReclamation' => $catReclamation,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a catReclamation entity.
     *
     * @Route("/{idCategorie}", name="catreclamation_show")
     * @Method("GET")
     */
    public function showAction(CatReclamation $catReclamation)
    {
        $deleteForm = $this->createDeleteForm($catReclamation);

        return $this->render('catreclamation/show.html.twig', array(
            'catReclamation' => $catReclamation,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing catReclamation entity.
     *
     * @Route("/{idCategorie}/edit", name="catreclamation_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, CatReclamation $catReclamation)
    {
        $deleteForm = $this->createDeleteForm($catReclamation);
        $editForm = $this->createForm('JardinBundle\Form\CatReclamationType', $catReclamation);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('catreclamation_edit', array('idCategorie' => $catReclamation->getIdcategorie()));
        }

        return $this->render('catreclamation/edit.html.twig', array(
            'catReclamation' => $catReclamation,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a catReclamation entity.
     *
     * @Route("/{idCategorie}", name="catreclamation_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, CatReclamation $catReclamation)
    {
        $form = $this->createDeleteForm($catReclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($catReclamation);
            $em->flush();
        }

        return $this->redirectToRoute('catreclamation_index');
    }

    /**
     * Creates a form to delete a catReclamation entity.
     *
     * @param CatReclamation $catReclamation The catReclamation entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(CatReclamation $catReclamation)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('catreclamation_delete', array('idCategorie' => $catReclamation->getIdcategorie())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
