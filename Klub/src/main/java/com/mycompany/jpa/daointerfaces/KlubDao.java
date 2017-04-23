package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Klub;
import java.util.List;

public interface KlubDao extends GenericDao<Klub,Integer>{

    public List<Klub> findAll();
    public void usun(Integer idKlub);
    
}
