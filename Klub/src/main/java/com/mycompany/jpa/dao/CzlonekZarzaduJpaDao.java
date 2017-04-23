package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.CzlonekZarzaduDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Czlonek_Zarzadu;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    
}
