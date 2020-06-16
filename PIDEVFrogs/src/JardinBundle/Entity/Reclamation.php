<?php

namespace JardinBundle\Entity;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="JardinBundle\Repository\reclamationRepository")
 */
class Reclamation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_reclamation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=60, nullable=false)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu", type="text", length=65535, nullable=false)
     */
    private $contenu;

    /**
     * @ORM\ManyToOne(targetEntity="UserBundle\Entity\User")
     * @ORM\JoinColumn(name="id_utilisateur", referencedColumnName="id")
     * })
     */
    private $idUtilisateur;

    /**
     * @ORM\ManyToOne(targetEntity="CatReclamation")
     * @ORM\JoinColumn(name="id_categorie", referencedColumnName="id_categorie")
     * })
     */
    private $CatReclamation;


    /**
     * @return mixed
     */
    public function getIdReclamation()
    {
        return $this->idReclamation;
    }

    /**
     * @param mixed $idReclamation
     * @return Reclamation
     */
    public function setIdReclamation($idReclamation)
    {
        $this->idReclamation = $idReclamation;
        return $this;
    }
    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     * @return Reclamation
     */
    public function setEmail($email)
    {
        $this->email = $email;
        return $this;
    }
    /**
     * @return mixed
     */
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * @param mixed $contenu
     * @return Reclamation
     */
    public function setContenu($contenu)
    {
        $this->contenu = $contenu;
        return $this;
    }
    /**
     * @return mixed
     */
    public function getIdUtilisateur()
    {
        return $this->idUtilisateur;
    }

    /**
     * @param mixed $idUtilisateur
     * @return Reclamation
     */
    public function setIdUtilisateur($idUtilisateur)
    {
        $this->idUtilisateur = $idUtilisateur;
        return $this;
    }

    /**
     * @return mixed
     */
    public function getCatReclamation()
    {
        return $this->CatReclamation;
    }

    /**
     * @param mixed $CatReclamation
     * @return Reclamation
     */
    public function setCatReclamationr($catReclamation)
    {
        $this->catReclamation = $catReclamation;
        return $this;
    }



    /**
     * Set catReclamation
     *
     * @param \JardinBundle\Entity\CatReclamation $catReclamation
     *
     * @return Reclamation
     */
    public function setCatReclamation(\JardinBundle\Entity\CatReclamation $catReclamation = null)
    {
        $this->CatReclamation = $catReclamation;

        return $this;
    }

}
