package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.daointerfaces.SekcjaDao;
import com.mycompany.jpa.model.Sekcja;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class SekcjaJpaDao extends GenericJpaDao<Sekcja, Integer> implements SekcjaDao {

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

    @Override
    public void usun(Integer idSekcja) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunSekcja");
        query.setParameter("p_idsekcja", idSekcja);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Sekcja sekcja) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajSekcja");
        query.setParameter("p_idklub", sekcja.getIdKlub().getIdKlub());
        query.setParameter("p_dysc", sekcja.getDyscyplina());
        query.setParameter("p_plec", sekcja.getPlec());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Sekcja sekcja) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujSekcja");
        query.setParameter("p_idklub", sekcja.getIdKlub().getIdKlub());
        query.setParameter("p_dysc", sekcja.getDyscyplina());
        query.setParameter("p_plec", sekcja.getPlec());
        query.setParameter("p_idsekcja", sekcja.getIdSekcja());
        query.execute();
        em.close();
    }

}
