<?php

namespace eventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * participation
 *
 * @ORM\Table(name="participation")
 * @ORM\Entity(repositoryClass="eventBundle\Repository\participationRepository")
 */
class participation
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
     * @var \eventBundle\Entity\event
     *
     * @ORM\ManyToOne(targetEntity="eventBundle\Entity\event")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_event", referencedColumnName="id" ,onDelete="CASCADE")
     * })
     */
    private $idEvent;

    /**
     * @var \UserBundle\Entity\User
     *
     * @ORM\ManyToOne(targetEntity="UserBundle\Entity\User")
     * @ORM\JoinColumns({
     * @ORM\JoinColumn(name="id_user", referencedColumnName="id" ,onDelete="CASCADE")
     * })
     */
    private $idUser;

    /**
     * @var int
     *
     * @ORM\Column(name="nbr_enfant", type="integer")
     */
    private $nbrEnfant;


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
     * Set idEvent
     *
     * @param integer $idEvent
     *
     * @return participation
     */
    public function setIdEvent($idEvent)
    {
        $this->idEvent = $idEvent;

        return $this;
    }

    /**
     * Get idEvent
     *
     * @return int
     */
    public function getIdEvent()
    {
        return $this->idEvent;
    }

    /**
     * Set idUser
     *
     * @param integer $idUser
     *
     * @return participation
     */
    public function setIdUser($idUser)
    {
        $this->idUser = $idUser;

        return $this;
    }

    /**
     * Get idUser
     *
     * @return int
     */
    public function getIdUser()
    {
        return $this->idUser;
    }

    /**
     * Set nbrEnfant
     *
     * @param integer $nbrEnfant
     *
     * @return participation
     */
    public function setNbrEnfant($nbrEnfant)
    {
        $this->nbrEnfant = $nbrEnfant;

        return $this;
    }

    /**
     * Get nbrEnfant
     *
     * @return int
     */
    public function getNbrEnfant()
    {
        return $this->nbrEnfant;
    }
}

