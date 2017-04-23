package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.daointerfaces.SekcjaDao;
import com.mycompany.jpa.model.Sekcja;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SekcjaJpaDao extends GenericJpaDao<Sekcja, Integer> implements SekcjaDao{

    @Override
    public List<Sekcja> findByIdKlub(Integer idKlub) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Sekcja.findByIdKlub");
        KlubDao kdao = new KlubJpaDao();
        query.setParameter("idKlub", kdao.findById(idKlub));
        List<Sekcja> result = query.getResultList();
        em.close();
        return result;
    }
    
}
