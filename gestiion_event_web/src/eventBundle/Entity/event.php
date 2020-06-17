<?php

namespace eventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * event
 *
 * @ORM\Table(name="event")
 * @ORM\Entity(repositoryClass="eventBundle\Repository\eventRepository")
 */
class event
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="titre", type="string", length=255)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255)
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateevent", type="date")
     */
    private $dateevent;

    /**
     * @var float
     *
     * @ORM\Column(name="prix", type="float")
     */
    private $prix;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heuredebut", type="time")
     */
    private $heuredebut;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heurefin", type="time")
     */
    private $heurefin;

    /**
     * @var \eventBundle\Entity\type
     *
     * @ORM\ManyToOne(targetEntity="eventBundle\Entity\type")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_type", referencedColumnName="id" ,onDelete="CASCADE")
     * })
     */
    private $idType;

    /**
     * @var \UserBundle\Entity\User
     *
     * @ORM\ManyToOne(targetEntity="UserBundle\Entity\User")
     * @ORM\JoinColumns({
     * @ORM\JoinColumn(name="id_responsable", referencedColumnName="id" ,onDelete="CASCADE")
     * })
     */
    private $idResponsable;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set titre
     *
     * @param string $titre
     *
     * @return event
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this;
    }

    /**
     * Get titre
     *
     * @return string
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return event
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set dateevent
     *
     * @param \DateTime $dateevent
     *
     * @return event
     */
    public function setDateevent($dateevent)
    {
        $this->dateevent = $dateevent;

        return $this;
    }

    /**
     * Get dateevent
     *
     * @return \DateTime
     */
    public function getDateevent()
    {
        return $this->dateevent;
    }

    /**
     * Set prix
     *
     * @param float $prix
     *
     * @return event
     */
    public function setPrix($prix)
    {
        $this->prix = $prix;

        return $this;
    }

    /**
     * Get prix
     *
     * @return float
     */
    public function getPrix()
    {
        return $this->prix;
    }

    /**
     * Set heuredebut
     *
     * @param \DateTime $heuredebut
     *
     * @return event
     */
    public function setHeuredebut($heuredebut)
    {
        $this->heuredebut = $heuredebut;

        return $this;
    }

    /**
     * Get heuredebut
     *
     * @return \DateTime
     */
    public function getHeuredebut()
    {
        return $this->heuredebut;
    }

    /**
     * Set heurefin
     *
     * @param \DateTime $heurefin
     *
     * @return event
     */
    public function setHeurefin($heurefin)
    {
        $this->heurefin = $heurefin;

        return $this;
    }

    /**
     * Get heurefin
     *
     * @return \DateTime
     */
    public function getHeurefin()
    {
        return $this->heurefin;
    }

    /**
     * Set idType
     *
     * @param integer $idType
     *
     * @return event
     */
    public function setIdType($idType)
    {
        $this->idType = $idType;

        return $this;
    }

    /**
     * Get idType
     *
     * @return int
     */
    public function getIdType()
    {
        return $this->idType;
    }

    /**
     * Set idResponsable
     *
     * @param integer $idResponsable
     *
     * @return event
     */
    public function setIdResponsable($idResponsable)
    {
        $this->idResponsable = $idResponsable;

        return $this;
    }

    /**
     * Get idResponsable
     *
     * @return int
     */
    public function getIdResponsable()
    {
        return $this->idResponsable;
    }
    public function __toString()
    {
        return (string) $this->getId();
    }
}

