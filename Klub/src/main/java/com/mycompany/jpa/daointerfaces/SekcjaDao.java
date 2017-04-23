package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Sekcja;
import java.util.List;

public interface SekcjaDao extends GenericDao<Sekcja,Integer>{
    
    public List<Sekcja> findByIdKlub(Integer idKlub);
}
