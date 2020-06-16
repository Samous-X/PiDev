<?php

namespace JardinBundle\Controller;


use JardinBundle\Entity\Reclamation;
use JardinBundle\Entity\CatReclamation;
use JardinBundle\Form\ReclamationType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;

/**
 * Reclamation controller.
 *
 * @Route("reclamation")
 */
class ReclamationController extends Controller
{
    /**
     * Lists all reclamation entities.
     *
     * @Route("/", name="reclamation_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $reclamations = $em->getRepository('JardinBundle:Reclamation')->findAll();

        return $this->render('reclamation/index.html.twig', array(
            'reclamations' => $reclamations,
        ));
    }

    /**
     * Creates a new reclamation entity.
     *
     * @Route("/new", name="reclamation_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        if( $this->container->get( 'security.authorization_checker' )->isGranted( 'IS_AUTHENTICATED_FULLY' ) ) {
            $user = $this->container->get('security.token_storage')->getToken()->getUser();
        }
        else{
            return $this->redirectToRoute('fos_user_security_login');
        }


        $reclamation = new Reclamation();
        $reclamation ->setIdUtilisateur($user);
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($reclamation);
            $em->flush();

            return $this->redirectToRoute('reclamation_show');
        }

        return $this->render('reclamation/new.html.twig', array(
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a reclamation entity.
     *
     * @Route("/", name="reclamation_show")
     * @Method("GET")
     */
    public function showAction()
    {


        $em = $this->getDoctrine()->getManager();

        $user = $this->get('security.token_storage')->getToken()->getUser();
        $user_id = $user->getId();
        $reclamation = $em->getRepository('JardinBundle:Reclamation')->findEntitiesByIdReclamation($user_id);
        return $this->render('reclamation/show.html.twig', array(
            'reclamation' => $reclamation));
    }

    /**
     * Displays a form to edit an existing reclamation entity.
     *
     * @Route("/{idReclamation}/edit", name="reclamation_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, Reclamation $reclamation)
    {
        $deleteForm = $this->createDeleteForm($reclamation);
        $editForm = $this->createForm('JardinBundle\Form\ReclamationType', $reclamation);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('reclamation_edit', array('idReclamation' => $reclamation->getIdreclamation()));
        }

        return $this->render('reclamation/edit.html.twig', array(
            'reclamation' => $reclamation,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a reclamation entity.
     *
     * @Route("/{idReclamation}", name="reclamation_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, Reclamation $reclamation)
    {
        $form = $this->createDeleteForm($reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($reclamation);
            $em->flush();
        }

        return $this->redirectToRoute('reclamation_index');
    }

    /**
     * Creates a form to delete a reclamation entity.
     *
     * @param Reclamation $reclamation The reclamation entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Reclamation $reclamation)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('reclamation_delete', array('idReclamation' => $reclamation->getIdreclamation())))
            ->setMethod('DELETE')
            ->getForm()
            ;
    }
    /**
     *
     * @Route("/liste", name="reclamation_")
     */
    public function reclamationAction()
    {
        $repository=$this->getDoctrine()->getManager()->getRepository(Reclamation::class);
        $listreclamations=$repository->myfindDomaine();
        return($this->render('@Jardin/Jardin/listReclamation.html.twig',array("listreclamations"=>$listreclamations)));
    }
    /*public function affAction()
    {


        $em = $this->getDoctrine()->getManager();

        $user = $this->get('security.token_storage')->getToken()->getUser();
        $user_id = $user->getId();
        $reclamation = $em->getRepository('JardinBundle:Reclamation')->findEntitiesByIdReclamation($user_id);
        return $this->render('reclamation/show.html.twig', array(
            'reclamation' => $reclamation));
    }*/

    public function countAction()
    {
        $em=$this->getDoctrine()->getManager();
        $sql="SELECT COUNT(id_reclamation) FROM reclamation WHERE id_categorie=2";
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute();
        $a = $stmt->fetchAll();
        return $this->render('@Jardin\Default\index.html.twig', array());


    }

   public function StatAction()
    {
        $pieChart=new PieChart();
        $em=$this->getDoctrine();
        $reclamations=$em->getRepository(Reclamation::class)->findAll();
        $em = $this->getDoctrine()->getManager();
        $query = $em->createQuery(
            'SELECT COUNT(idReclamation) FROM JardinBundle:Reclamation'
        );

        $u = $query->getResult();
        $nbReclamation=$u;
        $data=array();
        $stat=['reclamation','CatReclamaion'];
        $nb=0;
        array_push($data,$stat);
        foreach($reclamations as $reclamation) {
            $stat=array();
            $nbCat=$reclamation=$em->getRepository(Reclamation::class)->findByCategorie();
            array_push($stat,$reclamation->getEmail(),($nbCat *100)/$nbReclamation);
            $nb=(($reclamation=$em->getRepository(Reclamation::class)->findByCategorie()) *100)/$nbReclamation;
            $stat=[$reclamation->getCatReclamation(),$nb];
            array_push($data,$stat);
        }
        $pieChart->getData()->setArrayToDataTable(
            $data
        );
        $pieChart->getOptions()->setTitle('Pourcentages des réclamtions par catégorie');
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
        $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
        $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
        $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
        $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);
        return $this->render('@Jardin\Jardin\charts.html.twig', array('piechart' => $pieChart));
    }







}
