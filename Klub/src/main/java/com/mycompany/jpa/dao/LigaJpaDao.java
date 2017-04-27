package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.LigaDao;
import com.mycompany.jpa.model.Liga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class LigaJpaDao extends GenericJpaDao<Liga, Integer> implements LigaDao {

    @Override
    public List<Liga> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Liga.findAll");
        List<Liga> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public void usun(Integer idLiga) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunLiga");
        query.setParameter("p_idliga", idLiga);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Liga liga) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajLiga");
        query.setParameter("p_nazwa", liga.getNazwa());
        query.setParameter("p_kraj", liga.getKraj());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Liga liga) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujLiga");
        query.setParameter("p_nazwa", liga.getNazwa());
        query.setParameter("p_kraj", liga.getKraj());
        query.setParameter("p_idliga", liga.getIdLiga());
        query.execute();
        em.close();
    }

}
