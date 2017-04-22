package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Budynek;
import java.util.List;

public interface BudynekDao extends GenericDao<Budynek,Integer>{
    
    public List<Budynek> findByIdKlub(Integer idKlub);
}
