<?php

namespace JardinBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Comment
 *
 * @ORM\Table(name="comment")
 * @ORM\Entity
 */
class Comment
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idc", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idc;

    /**
     * @var string
     *
     * @ORM\Column(name="textec", type="string", length=50, nullable=false)
     */
    private $textec;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="datec", type="date", nullable=false)
     */
    private $datec;

    /**
     * @var string
     *
     * @ORM\Column(name="id", type="string", length=88, nullable=false)
     */
    private $id;



    /**
     * Get idc
     *
     * @return integer
     */
    public function getIdc()
    {
        return $this->idc;
    }

    /**
     * Set textec
     *
     * @param string $textec
     *
     * @return Comment
     */
    public function setTextec($textec)
    {
        $this->textec = $textec;

        return $this;
    }

    /**
     * Get textec
     *
     * @return string
     */
    public function getTextec()
    {
        return $this->textec;
    }

    /**
     * Set datec
     *
     * @param \DateTime $datec
     *
     * @return Comment
     */
    public function setDatec($datec)
    {
        $this->datec = $datec;

        return $this;
    }

    /**
     * Get datec
     *
     * @return \DateTime
     */
    public function getDatec()
    {
        return $this->datec;
    }

    /**
     * Set id
     *
     * @param string $id
     *
     * @return Comment
     */
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * Get id
     *
     * @return string
     */
    public function getId()
    {
        return $this->id;
    }
}
