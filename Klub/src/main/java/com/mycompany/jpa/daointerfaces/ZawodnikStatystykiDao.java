package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Zawodnik_Statystyki;
import java.util.List;

public interface ZawodnikStatystykiDao extends GenericDao<Zawodnik_Statystyki,Integer>{
    
    public List<Zawodnik_Statystyki> findAll();
    public List<Zawodnik_Statystyki> findByZawodnik(Integer idZawodnik);
    public List<Zawodnik_Statystyki> findBySezon(Integer idSezon);
    public void usun(Integer idZawodnik);
    public void dodaj(Zawodnik_Statystyki zawodnik);
    public void edytuj(Zawodnik_Statystyki zawodnik);
    
}
