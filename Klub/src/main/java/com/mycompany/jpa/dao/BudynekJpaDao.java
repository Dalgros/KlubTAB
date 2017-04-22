package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.BudynekDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Budynek;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BudynekJpaDao extends GenericJpaDao<Budynek, Integer> implements BudynekDao{

    @Override
    public List<Budynek> findByIdKlub(Integer idKlub) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Budynek.findByIdKlub");
        KlubDao kdao = new KlubJpaDao();
        query.setParameter("idKlub", kdao.findById(idKlub));
        List<Budynek> result = query.getResultList();
        em.close();
        return result;
    }
    
}
