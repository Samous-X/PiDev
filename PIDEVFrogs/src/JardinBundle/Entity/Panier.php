<?php

namespace JardinBundle\Entity\Entity;

/**
 * Panier
 */
class Panier
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
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date")
     */
    private $date;

    /**
     * @var float
     *
     * @ORM\Column(name="total", type="float")
     */
    private $total;
    /**
     * @ORM\OneToMany(targetEntity="JardinBundle\Entity\Panier_element", mappedBy="panier_elemet")
     */
    private $panier_elements;

    /**
     * @return mixed
     */
    public function getPanierElements()
    {
        return $this->panier_elements;
    }

    /**
     * @param mixed $panier_elements
     */
    public function setPanierElements($panier_elements)
    {
        $this->panier_elements = $panier_elements;
    }






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
     * Set date
     *
     * @param \DateTime $date
     *
     * @return \JardinBundle\Entity\Panier
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
     * Set total
     *
     * @param float $total
     *
     * @return Panier
     */
    public function setTotal($total)
    {
        $this->total = $total;

        return $this;
    }

    /**
     * Get total
     *
     * @return float
     */
    public function getTotal()
    {
        return $this->total;
    }

}

