package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Czlonek_Zarzadu;
import java.util.List;

public interface CzlonekZarzaduDao extends GenericDao<Czlonek_Zarzadu,Integer>{
    
    public List<Czlonek_Zarzadu> findByIdKlub(Integer idKlub);
}
