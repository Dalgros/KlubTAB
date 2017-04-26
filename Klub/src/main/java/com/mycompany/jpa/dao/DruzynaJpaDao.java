package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.DruzynaDao;
import com.mycompany.jpa.daointerfaces.LigaDao;
import com.mycompany.jpa.daointerfaces.SekcjaDao;
import com.mycompany.jpa.model.Druzyna;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

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

    @Override
    public void usun(Integer idDruzyna) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunDruzyna");
        query.setParameter("p_iddruzyna", idDruzyna);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Druzyna druzyna) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajDruzyna");
        query.setParameter("p_nazwa", druzyna.getNazwa());
        query.setParameter("p_idliga", druzyna.getIdLiga().getIdLiga());
        query.setParameter("p_idsekcja", druzyna.getIdSekcja().getIdSekcja());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Druzyna druzyna) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujDruzyna");
        query.setParameter("p_nazwa", druzyna.getNazwa());
        query.setParameter("p_idliga", druzyna.getIdLiga().getIdLiga());
        query.setParameter("p_idsekcja", druzyna.getIdSekcja().getIdSekcja());
        query.setParameter("p_iddruzyna", druzyna.getIdDruzyna());
        query.execute();
        em.close();
    }
    
}
