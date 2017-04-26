package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Klub;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.sql.rowset.serial.SerialBlob;

public class KlubJpaDao extends GenericJpaDao<Klub, Integer> implements KlubDao {

    @Override
    public List<Klub> findAll() {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Klub.findAll");
        List<Klub> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public void usun(Integer idKlub) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunKlub");
        query.setParameter("pid", idKlub);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Klub klub) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajKlub");
        query.setParameter("p_nazwa", klub.getNazwa());
//        try {
//            query.setParameter("p_logo", klub.getLogo());
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Klub klub) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujKlub");
        query.setParameter("p_nazwa", klub.getNazwa());
        query.setParameter("pid", klub.getIdKlub());
        try {
            query.setParameter("p_logo", klub.getLogo());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        query.execute();
        em.close();
    }
}
