package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.KontraktDao;
import com.mycompany.jpa.model.Kontrakt;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class KontraktJpaDao extends GenericJpaDao<Kontrakt, Integer> implements KontraktDao {

    @Override
    public List<Kontrakt> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Kontrakt.findAll");
        List<Kontrakt> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public void usunDruzyna(Integer idDruzyna) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunKontraktDruzyna");
        query.setParameter("p_iddruzyna", idDruzyna);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Kontrakt kontrakt) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajKontrakt");
        query.setParameter("p_iddruzyna", kontrakt.getDruzyna().getIdDruzyna());
        query.setParameter("p_idzawodnika", kontrakt.getZawodnik().getIdZawodnik());
        query.setParameter("p_poczatek", kontrakt.getPoczatekKontraktu());
        query.setParameter("p_koniec", kontrakt.getKoniecKontraktu());
        query.setParameter("p_pensja", kontrakt.getPensja());
        query.setParameter("p_wartosc", kontrakt.getWartoscRynkowa());
        query.execute();
        em.close();
    }

    @Override
    public void usunZawodnik(Integer idZawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunKontraktZawodnik");
        query.setParameter("p_idzawodnika", idZawodnik);
        query.execute();
        em.close();
    }

    @Override
    public List<Kontrakt> findByZawodnik(Integer idZawodnik) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Kontrakt.findByZawodnik");
        query.setParameter("idZawodnik", idZawodnik);
        List<Kontrakt> result = query.getResultList();
        em.close();
        return result;
    }

}
