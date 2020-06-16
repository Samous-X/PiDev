<?php

namespace JardinBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Participant
 *
 * @ORM\Table(name="participant", indexes={@ORM\Index(name="id_event", columns={"id_event", "id_utilisateur"}), @ORM\Index(name="id_utilisateur", columns={"id_utilisateur"}), @ORM\Index(name="IDX_D79F6B11D52B4B97", columns={"id_event"})})
 * @ORM\Entity
 */
class Participant
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_participant", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idParticipant;

    /**
     * @var integer
     *
     * @ORM\Column(name="nombre_enfant", type="integer", nullable=false)
     */
    private $nombreEnfant;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_utilisateur", referencedColumnName="id")
     * })
     */
    private $idUtilisateur;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_event", referencedColumnName="id_event")
     * })
     */
    private $idEvent;



    /**
     * Get idParticipant
     *
     * @return integer
     */
    public function getIdParticipant()
    {
        return $this->idParticipant;
    }

    /**
     * Set nombreEnfant
     *
     * @param integer $nombreEnfant
     *
     * @return Participant
     */
    public function setNombreEnfant($nombreEnfant)
    {
        $this->nombreEnfant = $nombreEnfant;

        return $this;
    }

    /**
     * Get nombreEnfant
     *
     * @return integer
     */
    public function getNombreEnfant()
    {
        return $this->nombreEnfant;
    }

    /**
     * Set idUtilisateur
     *
     * @param \JardinBundle\Entity\FosUser $idUtilisateur
     *
     * @return Participant
     */
    public function setIdUtilisateur(\JardinBundle\Entity\FosUser $idUtilisateur = null)
    {
        $this->idUtilisateur = $idUtilisateur;

        return $this;
    }

    /**
     * Get idUtilisateur
     *
     * @return \JardinBundle\Entity\FosUser
     */
    public function getIdUtilisateur()
    {
        return $this->idUtilisateur;
    }

    /**
     * Set idEvent
     *
     * @param \JardinBundle\Entity\Evenement $idEvent
     *
     * @return Participant
     */
    public function setIdEvent(\JardinBundle\Entity\Evenement $idEvent = null)
    {
        $this->idEvent = $idEvent;

        return $this;
    }

    /**
     * Get idEvent
     *
     * @return \JardinBundle\Entity\Evenement
     */
    public function getIdEvent()
    {
        return $this->idEvent;
    }
}
