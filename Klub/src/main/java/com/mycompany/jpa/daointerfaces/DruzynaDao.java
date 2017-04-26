package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Druzyna;
import java.util.List;

public interface DruzynaDao extends GenericDao<Druzyna,Integer>{
    
    public List<Druzyna> findByIdSekcja(Integer idSekcja);
    public List<Druzyna> findByIdLiga(Integer idLiga);
    public void usun(Integer idDruzyna);
    public void dodaj(Druzyna druzyna);
    public void edytuj(Druzyna druzyna);
}
