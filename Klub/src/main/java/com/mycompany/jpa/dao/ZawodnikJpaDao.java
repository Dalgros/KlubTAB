package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.DruzynaDao;
import com.mycompany.jpa.daointerfaces.ZawodnikDao;
import com.mycompany.jpa.model.Zawodnik;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class ZawodnikJpaDao extends GenericJpaDao<Zawodnik, Integer> implements ZawodnikDao {

    public List<Zawodnik> findByIdDruzyna(Integer idDruzyna) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Zawodnik.findByIdDruzyna");
        query.setParameter("idDruzyna", new BigInteger(idDruzyna.toString()));
        List<Zawodnik> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public void usun(Integer idZawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunZawodnik");
        query.setParameter("p_idzawodnik", idZawodnik);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Zawodnik zawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajZawodnik");
        query.setParameter("p_imie", zawodnik.getImie());
        query.setParameter("p_nazwisko", zawodnik.getNazwisko());
        query.setParameter("p_data", zawodnik.getDataUrodzenia());
        query.setParameter("p_wzrost", zawodnik.getWzrost());
        query.setParameter("p_waga", zawodnik.getWaga());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Zawodnik zawodnik) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujZawodnik");
        query.setParameter("p_idzawodnik", zawodnik.getIdZawodnik());
        query.setParameter("p_imie", zawodnik.getImie());
        query.setParameter("p_nazwisko", zawodnik.getNazwisko());
        query.setParameter("p_data", zawodnik.getDataUrodzenia());
        query.setParameter("p_wzrost", zawodnik.getWzrost());
        query.setParameter("p_waga", zawodnik.getWaga());
        query.execute();
        em.close();
    }

    @Override
    public List<Zawodnik> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Zawodnik.findAll");
        List<Zawodnik> result = query.getResultList();
        em.close();
        return result;
    }

}
