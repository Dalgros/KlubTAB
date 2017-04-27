package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Kontrakt;
import java.util.List;

public interface KontraktDao extends GenericDao<Kontrakt,Integer>{
    
    public List<Kontrakt> findAll();
    public List<Kontrakt> findByZawodnik(Integer idZawodnik);
    public void usunDruzyna(Integer idDruzyna);
    public void dodaj(Kontrakt kontrakt);
    public void usunZawodnik(Integer idZawodnik);
    
}
