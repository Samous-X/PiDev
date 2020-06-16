<?php

namespace MobileBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class PanierController extends Controller
{
      public function newPanierAction(Request $request)
      {
          $em = $this->getDoctrine()->getManager();

          $a=($request->get('date'));
          $b=($request->get('total'));
          $em = $this->getDoctrine()->getManager();
          $sql = "INSERT INTO panier(date, total) VALUES (:a,:b)";
          $params[':a'] = $a;
          $params[':b'] = $b;


          $stmt = $em->getConnection()->prepare($sql);
          $stmt->execute($params);
          $serializer=new Serializer([new ObjectNormalizer()]);
          $formatted=$serializer->normalize('ok');
          return new JsonResponse($formatted);

      }



}
