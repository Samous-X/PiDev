<?php

namespace MobileBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CatReclamation
 *
 * @ORM\Table(name="cat_reclamation")
 * @ORM\Entity
 */
class CatReclamation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_categorie", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCategorie;

    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=60, nullable=false)
     */
    private $type;



    /**
     * Get idCategorie
     *
     * @return integer
     */
    public function getIdCategorie()
    {
        return $this->idCategorie;
    }

    /**
     * Set type
     *
     * @param string $type
     *
     * @return CatReclamation
     */
    public function setType($type)
    {
        $this->type = $type;

        return $this;
    }

    /**
     * Get type
     *
     * @return string
     */
    public function getType()
    {
        return $this->type;
    }
}
