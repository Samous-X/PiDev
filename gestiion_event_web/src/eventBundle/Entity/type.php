<?php

namespace eventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * type
 *
 * @ORM\Table(name="type")
 * @ORM\Entity(repositoryClass="eventBundle\Repository\typeRepository")
 */
class type
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
     * @ORM\Column(name="type_event", type="string", length=255)
     */
    private $typeEvent;


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
     * Set typeEvent
     *
     * @param string $typeEvent
     *
     * @return type
     */
    public function setTypeEvent($typeEvent)
    {
        $this->typeEvent = $typeEvent;

        return $this;
    }

    /**
     * Get typeEvent
     *
     * @return string
     */
    public function getTypeEvent()
    {
        return $this->typeEvent;
    }
    public function __toString()
    {
        return (string) $this->getId();
    }
}

