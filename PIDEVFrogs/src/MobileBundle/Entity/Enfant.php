<?php

namespace MobileBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Enfant
 *
 * @ORM\Table(name="enfant", indexes={@ORM\Index(name="FK_34B70CA250EAE44", columns={"id_utilisateur"})})
 * @ORM\Entity(repositoryClass="JardinBundle\Repository\EnfantRepository")
 */
class Enfant
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_enfant", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idEnfant;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=11, nullable=false)
     * @Assert\Length(
     *     min = 5,
     *     max = 20,
     *     minMessage = "Your first name must be at least {{ limit }} characters long",
     *     maxMessage = "Your first name cannot be longer than {{ limit }} characters"
     * )
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=11, nullable=false)* @Assert\Length(
     *     min = 5,
     *     max = 20,
     *     minMessage = "Your first name must be at least {{ limit }} characters long",
     *     maxMessage = "Your first name cannot be longer than {{ limit }} characters"
     * )
     */
    private $prenom;

    /**
     * @var integer
     *
     * @ORM\Column(name="age", type="integer", nullable=false)
     */
    private $age;

    /**
     * @var string
     *
     * @ORM\Column(name="photo", type="text", length=65535, nullable=false)
     *@Assert\GreaterThan(0)
     */
    private $photo;

    /**
     * @var boolean
     *
     * @ORM\Column(name="vaccin", type="boolean", nullable=false)
     */
    private $vaccin=false;

    /**
     * @var boolean
     *
     * @ORM\Column(name="alergie", type="boolean", nullable=false)
     */
    private $alergie=false;



    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="UserBundle\Entity\User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_utilisateur", referencedColumnName="id")
     * })
     */
    private $idUtilisateur;



    /**
     * Get idEnfant
     *
     * @return integer
     */
    public function getIdEnfant()
    {
        return $this->idEnfant;
    }

    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Enfant
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     *
     * @return Enfant
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set age
     *
     * @param integer $age
     *
     * @return Enfant
     */
    public function setAge($age)
    {
        $this->age = $age;

        return $this;
    }

    /**
     * Get age
     *
     * @return integer
     */
    public function getAge()
    {
        return $this->age;
    }

    /**
     * Set photo
     *
     * @param string $photo
     *
     * @return Enfant
     */
    public function setPhoto($photo)
    {
        $this->photo = $photo;

        return $this;
    }

    /**
     * Get photo
     *
     * @return string
     */
    public function getPhoto()
    {
        return $this->photo;
    }

    /**
     * Set vaccin
     *
     * @param boolean $vaccin
     *
     * @return Enfant
     */
    public function setVaccin($vaccin)
    {
        $this->vaccin = $vaccin;

        return $this;
    }

    /**
     * Get vaccin
     *
     * @return boolean
     */
    public function getVaccin()
    {
        return $this->vaccin;
    }

    /**
     * Set alergie
     *
     * @param boolean $alergie
     *
     * @return Enfant
     */
    public function setAlergie($alergie)
    {
        $this->alergie = $alergie;

        return $this;
    }

    /**
     * Get alergie
     *
     * @return boolean
     */
    public function getAlergie()
    {
        return $this->alergie;
    }


    /**
     * Set idUtilisateur
     *
     * @param \User\Bundle\Entity\User $idUtilisateur
     *
     * @return Enfant
     */
    public function setIdUtilisateur(\UserBundle\Entity\User $idUtilisateur )
    {
        $this->idUtilisateur = $idUtilisateur;

        return $this;
    }


    /**
     * Get idUtilisateur
     *
     * @return \JardinBundle\Entity\User
     */
    public function getIdUtilisateur()
    {
        return $this->idUtilisateur;
    }

}
