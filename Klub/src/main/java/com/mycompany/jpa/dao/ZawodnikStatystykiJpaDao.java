package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.ZawodnikStatystykiDao;
import com.mycompany.jpa.model.Zawodnik_Statystyki;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class ZawodnikStatystykiJpaDao extends GenericJpaDao<Zawodnik_Statystyki, Integer> implements ZawodnikStatystykiDao {

    @Override
    public List<Zawodnik_Statystyki> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ZawodnikStatystyki.findAll");
        List<Zawodnik_Statystyki> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Zawodnik_Statystyki> findByZawodnik(Integer idZawodnik) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ZawodnikStatystyki.findByIdZawodnik");
        query.setParameter("idZawodnik", idZawodnik);
        List<Zawodnik_Statystyki> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Zawodnik_Statystyki> findBySezon(Integer idSezon) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("ZawodnikStatystyki.findByIdSezon");
        query.setParameter("idSezon", idSezon);
        List<Zawodnik_Statystyki> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public void usun(Integer idZawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunStatystyki");
        query.setParameter("p_idzawodnik", idZawodnik);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Zawodnik_Statystyki zawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajStatystyki");
        query.setParameter("p_idsezon", zawodnik.getSezon().getIdSezon());
        query.setParameter("p_strzelone", zawodnik.getStrzeloneBramki());
        query.setParameter("p_stracone", zawodnik.getStraconeBramki());
        query.setParameter("p_zolte", zawodnik.getZolteKartki());
        query.setParameter("p_czerwone", zawodnik.getCzerwoneKartki());
        query.setParameter("p_faule", zawodnik.getFaule());
        query.setParameter("p_minuty", zawodnik.getRozegraneMinuty());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Zawodnik_Statystyki zawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujStatystyki");
        query.setParameter("p_idzwodnik", zawodnik.getZawodnik().getIdZawodnik());
        query.setParameter("p_idsezon", zawodnik.getSezon().getIdSezon());
        query.setParameter("p_strzelone", zawodnik.getStrzeloneBramki());
        query.setParameter("p_stracone", zawodnik.getStraconeBramki());
        query.setParameter("p_zolte", zawodnik.getZolteKartki());
        query.setParameter("p_czerwone", zawodnik.getCzerwoneKartki());
        query.setParameter("p_faule", zawodnik.getFaule());
        query.setParameter("p_minuty", zawodnik.getRozegraneMinuty());
        query.execute();
        em.close();
    }

}
