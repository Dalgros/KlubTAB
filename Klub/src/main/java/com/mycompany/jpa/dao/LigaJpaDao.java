package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.LigaDao;
import com.mycompany.jpa.model.Liga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LigaJpaDao extends GenericJpaDao<Liga, Integer> implements LigaDao{

    @Override
    public List<Liga> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Liga.findAll");
        List<Liga> result = query.getResultList();
        em.close();
        return result;
    }
    
}
