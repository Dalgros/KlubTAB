package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.BudynekDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Budynek;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class BudynekJpaDao extends GenericJpaDao<Budynek, Integer> implements BudynekDao {

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

    @Override
    public void usun(Integer idBudynek) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunBudynek");
        query.setParameter("pid", idBudynek);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Budynek budynek) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajBudynek");
        query.setParameter("pid", budynek.getIdKlub().getIdKlub());
        query.setParameter("kod", budynek.getKodPocztowy());
        query.setParameter("p_miejsce", budynek.getMiejscowosc());
        query.setParameter("p_ulica", budynek.getUlicanumer());
        query.setParameter("p_fun", budynek.getFunkcja());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Budynek budynek) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujBudynek");
        query.setParameter("pid", budynek.getIdKlub().getIdKlub());
        query.setParameter("kod", budynek.getKodPocztowy());
        query.setParameter("p_miejsce", budynek.getMiejscowosc());
        query.setParameter("p_ulica", budynek.getUlicanumer());
        query.setParameter("p_fun", budynek.getFunkcja());
        query.setParameter("id_bud", budynek.getIdBudynek());
        query.execute();
        em.close();
    }

}
