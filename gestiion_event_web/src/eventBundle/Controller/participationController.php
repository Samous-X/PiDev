<?php

namespace eventBundle\Controller;
use eventBundle\Entity\favoris;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use UserBundle\Entity\User;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use eventBundle\Entity\participation;
use eventBundle\Entity\event;
use mikehaertl\wkhtmlto\Pdf;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class participationController extends Controller
{

    public function AddparticipationAction($id)
    {

        $em = $this->getDoctrine()->getManager();
        $participation = new participation();
        $user = $em->getRepository(User::class)->find($this->getUser());
        $event = $em->getRepository(event::class)->find($id);
        $test=$em->getRepository(participation::class)->findBy(['idUser' => $this->getUser(),'idEvent' => $id]);
        if ($test) {
            return $this->redirectToRoute('event_Front_Affiche');
        }
        else{
            $participation->setIdEvent($event);
            $participation->setIdUser($user);
            $participation->setNbrEnfant(4);


            $em->persist($participation);
            $em->flush();

            return $this->redirectToRoute('event_Front_Affiche');
        }





    }
    public function pdfAction(Request $request, $id)

    {$em = $this->getDoctrine()->getManager();

        $participant = $em->getRepository('eventBundle:participation')->findBy(['idEvent' => $id]);
        $snappy = $this->get('knp_snappy.pdf');

        $html = $this->renderView('eventBundle:event:pdf.html.twig', array(
            'f' => $participant,
            "title" => "participation"
        ));



        $filename = 'custom_pdf_from_twig';
        return new Response(
            $snappy->getOutputFromHtml($html),
            200,
            array(
                'Content-Type' => 'application/pdf',
                'Content-Disposition' => 'inline; filename="' . $filename . '.pdf"'
            )
        );
    }

    public function  find_userAction($username)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "select * from user where username=:dom";
        $params[':dom'] = $username;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a = $stmt->fetchAll();
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize($a);
        return new JsonResponse($formatted);
    }
    public function  find_eventAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "select * from event";
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute();
        $a = $stmt->fetchAll();
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize($a);
        return new JsonResponse($formatted);
    }

    public function  mob_participerAction(Request $request,$id,$id_u)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "INSERT INTO participation(id_event, id_user) VALUES (:dom1,:dom2)";
        $params[':dom1'] = $id;
        $params[':dom2'] = $id_u;

        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);

        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize('ok');

        // $basic  = new \Nexmo\Client\Credentials\Basic('4bb343f3', 'LqfcVMdquWf6jU8a');
        //  $client = new \Nexmo\Client($basic);

        // $message = $client->message()->send([
        //      'to' => '21696681004',
        //      'from' => 'GoBike',
        //     'text' => 'New Participation',
        // ]);
        return new JsonResponse($formatted);
    }
    public function  my_eventsAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "SELECT * from event INNER join participation on event.id=participation.id_event where participation.id_user=:dom";
        $params[':dom'] = $id;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a = $stmt->fetchAll();
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize($a);
        return new JsonResponse($formatted);
    }

    public function  checkParticipationMobAction(Request $request,$id,$idu)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "SELECT * from participation where id_user=:dom and id_event =:dom1";
        $params[':dom'] = $idu;
        $params[':dom1'] = $id;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a = $stmt->fetchAll();
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize($a);
        return new JsonResponse($formatted);
    }
    public function  suppParAction(Request $request,$id,$id_u)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "Delete from participation where id_event=:val and id_user=:val2";
        $params[':val'] = $id;
        $params[':val2'] = $id_u;

        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);

        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize('ok');

        return new JsonResponse($formatted);
    }

}
