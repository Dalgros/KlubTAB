package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.SezonDao;
import com.mycompany.jpa.model.Sezon;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SezonJpaDao extends GenericJpaDao<Sezon, Integer> implements SezonDao{

    @Override
    public List<Sezon> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Sezon.findAll");
        List<Sezon> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Sezon> findByYear(Integer year) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Sezon.findByYear");
        query.setParameter("rok", year);
        List<Sezon> result = query.getResultList();
        em.close();
        return result;
    }
    
}
