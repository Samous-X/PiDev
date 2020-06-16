<?php


namespace MobileBundle\Controller;
use MobileBundle\Entity\Enfant;
use FOS\UserBundle\Entity\User;


use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundleBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\HttpFoundation\Request;

class SecurityController extends Controller
{
    public function loginAction($username)
    {
        $em=$this->getDoctrine()->getManager();
        $sql="select * from fos_user where username=:dom";
        $params[':dom']=$username;
        $em=$this->getDoctrine()->getManager();
        $stmt=$em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a=$stmt->fetchAll();
        $serializer=new Serializer([new ObjectNormalizer()]);
        $formatted=$serializer->normalize($a);
        return new JsonResponse($formatted);

    }

}