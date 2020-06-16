<?php

namespace MobileBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement", indexes={@ORM\Index(name="idjardin", columns={"idjardin"})})
 * @ORM\Entity
 */
class Evenement
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_event", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="titre", type="string", length=30, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="text", length=65535, nullable=false)
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heureD", type="time", nullable=false)
     */
    private $heured;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heureF", type="time", nullable=false)
     */
    private $heuref;

    /**
     * @var float
     *
     * @ORM\Column(name="prix_event", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixEvent;

    /**
     * @var \Jardin
     *
     * @ORM\ManyToOne(targetEntity="Jardin")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idjardin", referencedColumnName="idjardin")
     * })
     */
    private $idjardin;



    /**
     * Get idEvent
     *
     * @return integer
     */
    public function getIdEvent()
    {
        return $this->idEvent;
    }

    /**
     * Set titre
     *
     * @param string $titre
     *
     * @return Evenement
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
     * @return Evenement
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
     * Set date
     *
     * @param \DateTime $date
     *
     * @return Evenement
     */
    public function setDate($date)
    {
        $this->date = $date;

        return $this;
    }

    /**
     * Get date
     *
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * Set heured
     *
     * @param \DateTime $heured
     *
     * @return Evenement
     */
    public function setHeured($heured)
    {
        $this->heured = $heured;

        return $this;
    }

    /**
     * Get heured
     *
     * @return \DateTime
     */
    public function getHeured()
    {
        return $this->heured;
    }

    /**
     * Set heuref
     *
     * @param \DateTime $heuref
     *
     * @return Evenement
     */
    public function setHeuref($heuref)
    {
        $this->heuref = $heuref;

        return $this;
    }

    /**
     * Get heuref
     *
     * @return \DateTime
     */
    public function getHeuref()
    {
        return $this->heuref;
    }

    /**
     * Set prixEvent
     *
     * @param float $prixEvent
     *
     * @return Evenement
     */
    public function setPrixEvent($prixEvent)
    {
        $this->prixEvent = $prixEvent;

        return $this;
    }

    /**
     * Get prixEvent
     *
     * @return float
     */
    public function getPrixEvent()
    {
        return $this->prixEvent;
    }

    /**
     * Set idjardin
     *
     * @param \JardinBundle\Entity\Jardin $idjardin
     *
     * @return Evenement
     */
    public function setIdjardin(\JardinBundle\Entity\Jardin $idjardin = null)
    {
        $this->idjardin = $idjardin;

        return $this;
    }

    /**
     * Get idjardin
     *
     * @return \JardinBundle\Entity\Jardin
     */
    public function getIdjardin()
    {
        return $this->idjardin;
    }
}
