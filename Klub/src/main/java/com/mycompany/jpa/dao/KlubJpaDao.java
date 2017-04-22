package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Klub;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class KlubJpaDao extends GenericJpaDao<Klub, Integer> implements KlubDao{
    
    @Override
    public List<Klub> findAll()
    {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Klub.findAll");
        List<Klub> result = query.getResultList();
        em.close();
        return result;
    }
}
