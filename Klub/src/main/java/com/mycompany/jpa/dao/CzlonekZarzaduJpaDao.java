package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.CzlonekZarzaduDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Czlonek_Zarzadu;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

public class CzlonekZarzaduJpaDao extends GenericJpaDao<Czlonek_Zarzadu, Integer> implements CzlonekZarzaduDao{

    @Override
    public List<Czlonek_Zarzadu> findByIdKlub(Integer idKlub) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CzlonekZarzadu.findByIdKlub");
        KlubDao kdao = new KlubJpaDao();
        query.setParameter("idKlub", kdao.findById(idKlub));
        List<Czlonek_Zarzadu> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public void usun(Integer idCzlonekZarzadu) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("usunCzlonekZarzadu");
        query.setParameter("p_idczlonek", idCzlonekZarzadu);
        query.execute();
        em.close();
    }

    @Override
    public void dodaj(Czlonek_Zarzadu czlonekZarzadu) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("dodajCzlonekZarzadu");
        query.setParameter("p_imie", czlonekZarzadu.getImie());
        query.setParameter("p_nazwisko", czlonekZarzadu.getNazwisko());
        query.setParameter("p_stanowisko", czlonekZarzadu.getStanowisko());
        query.setParameter("p_pensja", czlonekZarzadu.getPensja());
        query.setParameter("p_idklub", czlonekZarzadu.getIdKlub().getIdKlub());
        query.execute();
        em.close();
    }

    @Override
    public void edytuj(Czlonek_Zarzadu czlonekZarzadu) {
        EntityManager em = getEntityManager();
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("edytujCzlonekZarzadu");
        query.setParameter("p_imie", czlonekZarzadu.getImie());
        query.setParameter("p_nazwisko", czlonekZarzadu.getNazwisko());
        query.setParameter("p_stanowisko", czlonekZarzadu.getStanowisko());
        query.setParameter("p_pensja", czlonekZarzadu.getPensja());
        query.setParameter("p_idklub", czlonekZarzadu.getIdKlub().getIdKlub());
        query.setParameter("p_idczlonek", czlonekZarzadu.getIdCzlonek());
        query.execute();
        em.close();
    }
    
}
