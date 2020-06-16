<?php

namespace MobileBundle\Controller;
use MobileBundle\Entity\Enfant;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\HttpFoundation\Request;

class EnfantController extends Controller
{
    public function allAction($id)
    {
        $enfants = $this->getDoctrine()->getManager()
            ->getRepository('MobileBundle:Enfant')
            ->find($id);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($enfants);
        return new JsonResponse($formatted);
    }



    public function  newAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $a=($request->get('nom'));
        $b=($request->get('prenom'));
        $c=($request->get('age'));
        $d=($request->get('photo'));
        $e=($request->get('id_utilisateur'));
        $em = $this->getDoctrine()->getManager();
        $sql = "INSERT INTO enfant(id_utilisateur, nom, prenom, age, photo) VALUES (:e,:a,:b,:c,:d)";
        $params[':a'] = $a;
        $params[':b'] = $b;
        $params[':c'] = $c;
        $params[':d'] = $d;
        $params[':e'] = $e;


        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize('ok');
        return new JsonResponse($formatted);
    }


    public function  enfantsAction($id,Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "SELECT * FROM Enfant  WHERE
                    id_utilisateur=:dom";
        $params[':dom'] = $id;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a = $stmt->fetchAll();
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize($a);
        return new JsonResponse($formatted);
    }

    public function  dellAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $a=($request->get('id'));

        $em = $this->getDoctrine()->getManager();
        $sql = "DELETE FROM enfant WHERE enfant.id_enfant=:dom";
        $params[':dom'] = $a;



        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize('ok');
        return new JsonResponse($formatted);
    }
}
