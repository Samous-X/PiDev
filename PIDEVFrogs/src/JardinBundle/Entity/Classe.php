<?php

namespace JardinBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Classe
 *
 * @ORM\Table(name="classe")
 * @ORM\Entity
 */
class Classe
{
    /**
     * @var integer
     *
     * @ORM\Column(name="Id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_classe", type="string", length=50, nullable=false)
     */
    private $nomClasse;

    /**
     * @var integer
     *
     * @ORM\Column(name="niveau_classe", type="integer", nullable=false)
     */
    private $niveauClasse;

    /**
     * @var string
     *
     * @ORM\Column(name="enfant", type="string", length=20, nullable=false)
     */
    private $enfant;

    /**
     * @var integer
     *
     * @ORM\Column(name="nombre", type="integer", nullable=false)
     */
    private $nombre;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set nomClasse
     *
     * @param string $nomClasse
     *
     * @return Classe
     */
    public function setNomClasse($nomClasse)
    {
        $this->nomClasse = $nomClasse;

        return $this;
    }

    /**
     * Get nomClasse
     *
     * @return string
     */
    public function getNomClasse()
    {
        return $this->nomClasse;
    }

    /**
     * Set niveauClasse
     *
     * @param integer $niveauClasse
     *
     * @return Classe
     */
    public function setNiveauClasse($niveauClasse)
    {
        $this->niveauClasse = $niveauClasse;

        return $this;
    }

    /**
     * Get niveauClasse
     *
     * @return integer
     */
    public function getNiveauClasse()
    {
        return $this->niveauClasse;
    }

    /**
     * Set enfant
     *
     * @param string $enfant
     *
     * @return Classe
     */
    public function setEnfant($enfant)
    {
        $this->enfant = $enfant;

        return $this;
    }

    /**
     * Get enfant
     *
     * @return string
     */
    public function getEnfant()
    {
        return $this->enfant;
    }

    /**
     * Set nombre
     *
     * @param integer $nombre
     *
     * @return Classe
     */
    public function setNombre($nombre)
    {
        $this->nombre = $nombre;

        return $this;
    }

    /**
     * Get nombre
     *
     * @return integer
     */
    public function getNombre()
    {
        return $this->nombre;
    }
}
