package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Liga;
import java.util.List;

public interface LigaDao extends GenericDao<Liga,Integer>{
    
    public List<Liga> findAll();
    public void usun(Integer idLiga);
    public void dodaj(Liga liga);
    public void edytuj(Liga liga);
}
