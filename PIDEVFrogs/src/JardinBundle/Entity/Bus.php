<?php

namespace JardinBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Bus
 *
 * @ORM\Table(name="bus", uniqueConstraints={@ORM\UniqueConstraint(name="Immat", columns={"Immat"})})
 * @ORM\Entity
 */
class Bus
{
    /**
     * @var integer
     *
     * @ORM\Column(name="Id_bus", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idBus;

    /**
     * @var string
     *
     * @ORM\Column(name="Immat", type="string", length=50, nullable=false)
     */
    private $immat;

    /**
     * @var string
     *
     * @ORM\Column(name="ligne", type="string", length=50, nullable=false)
     */
    private $ligne;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="horaire", type="time", nullable=false)
     */
    private $horaire;

    /**
     * @var string
     *
     * @ORM\Column(name="chauffeur", type="string", length=50, nullable=false)
     */
    private $chauffeur;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbrplace", type="integer", nullable=false)
     */
    private $nbrplace;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="string", length=500, nullable=false)
     */
    private $image;



    /**
     * Get idBus
     *
     * @return integer
     */
    public function getIdBus()
    {
        return $this->idBus;
    }

    /**
     * Set immat
     *
     * @param string $immat
     *
     * @return Bus
     */
    public function setImmat($immat)
    {
        $this->immat = $immat;

        return $this;
    }

    /**
     * Get immat
     *
     * @return string
     */
    public function getImmat()
    {
        return $this->immat;
    }

    /**
     * Set ligne
     *
     * @param string $ligne
     *
     * @return Bus
     */
    public function setLigne($ligne)
    {
        $this->ligne = $ligne;

        return $this;
    }

    /**
     * Get ligne
     *
     * @return string
     */
    public function getLigne()
    {
        return $this->ligne;
    }

    /**
     * Set horaire
     *
     * @param \DateTime $horaire
     *
     * @return Bus
     */
    public function setHoraire($horaire)
    {
        $this->horaire = $horaire;

        return $this;
    }

    /**
     * Get horaire
     *
     * @return \DateTime
     */
    public function getHoraire()
    {
        return $this->horaire;
    }

    /**
     * Set chauffeur
     *
     * @param string $chauffeur
     *
     * @return Bus
     */
    public function setChauffeur($chauffeur)
    {
        $this->chauffeur = $chauffeur;

        return $this;
    }

    /**
     * Get chauffeur
     *
     * @return string
     */
    public function getChauffeur()
    {
        return $this->chauffeur;
    }

    /**
     * Set nbrplace
     *
     * @param integer $nbrplace
     *
     * @return Bus
     */
    public function setNbrplace($nbrplace)
    {
        $this->nbrplace = $nbrplace;

        return $this;
    }

    /**
     * Get nbrplace
     *
     * @return integer
     */
    public function getNbrplace()
    {
        return $this->nbrplace;
    }

    /**
     * Set image
     *
     * @param string $image
     *
     * @return Bus
     */
    public function setImage($image)
    {
        $this->image = $image;

        return $this;
    }

    /**
     * Get image
     *
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }
}
