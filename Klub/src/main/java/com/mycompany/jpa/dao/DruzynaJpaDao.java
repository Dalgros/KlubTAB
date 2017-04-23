package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.DruzynaDao;
import com.mycompany.jpa.daointerfaces.LigaDao;
import com.mycompany.jpa.daointerfaces.SekcjaDao;
import com.mycompany.jpa.model.Druzyna;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DruzynaJpaDao extends GenericJpaDao<Druzyna, Integer> implements DruzynaDao{

    @Override
    public List<Druzyna> findByIdSekcja(Integer idSekcja) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Druzyna.findByIdSekcja");
        SekcjaDao sdao = new SekcjaJpaDao();
        query.setParameter("idSekcja", sdao.findById(idSekcja));
        List<Druzyna> result = query.getResultList();
        em.close();
        return result;
    }
    
    @Override
    public List<Druzyna> findByIdLiga(Integer idLiga) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Druzyna.findByIdLiga");
        LigaDao ldao = new LigaJpaDao();
        query.setParameter("idLiga", ldao.findById(idLiga));
        List<Druzyna> result = query.getResultList();
        em.close();
        return result;
    }
    
}
