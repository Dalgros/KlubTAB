package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Czlonek_Zarzadu;
import java.util.List;

public interface CzlonekZarzaduDao extends GenericDao<Czlonek_Zarzadu,Integer>{
    
    public List<Czlonek_Zarzadu> findByIdKlub(Integer idKlub);
    public void usun(Integer idCzlonekZarzadu);
    public void dodaj(Czlonek_Zarzadu czlonekZarzadu);
    public void edytuj(Czlonek_Zarzadu czlonekZarzadu);
}
