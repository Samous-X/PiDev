<?php


namespace JardinBundle\Repository;
use Doctrine\ORM\EntityRepository;
use Doctrine\ORM\Query;


class reclamationRepository extends EntityRepository
{
    public function myfindDomaine()
    {
        $qb = $this->getEntityManager()
            ->createQuery
            ("SELECT f.idReclamation, f.contenu, c.type, f.email FROM JardinBundle:Reclamation f JOIN JardinBundle:CatReclamation c WHERE
                    f.CatReclamation=c.idCategorie");
        return $query = $qb->getResult();
    }
    public function findEntitiesByIdReclamation($id)
    {
        $query = $this->getEntityManager()->createQuery("SELECT i FROM JardinBundle:Reclamation i where i.idReclamation = '$id'");

        return $query->getResult();

    }
    public function findByCategorie()
    {
        $qb = $this->getEntityManager()
            ->createQuery
            ("SELECT COUNT(f.idReclamation) FROM JardinBundle:Reclamation f JOIN JardinBundle:CatReclamation c WHERE
                    f.CatReclamation=c.idCategorie");
        return $query = $qb->getResult();

    }

}