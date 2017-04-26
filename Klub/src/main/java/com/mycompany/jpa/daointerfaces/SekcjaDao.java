package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Sekcja;
import java.util.List;

public interface SekcjaDao extends GenericDao<Sekcja,Integer>{
    
    public List<Sekcja> findByIdKlub(Integer idKlub);
    public void usun(Integer idSekcja);
    public void dodaj(Sekcja sekcja);
    public void edytuj(Sekcja sekcja);
}
