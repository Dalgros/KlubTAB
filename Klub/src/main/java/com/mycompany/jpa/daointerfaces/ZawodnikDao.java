package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Zawodnik;
import java.util.List;

public interface ZawodnikDao extends GenericDao<Zawodnik,Integer>{

    public List<Zawodnik> findByIdDruzyna(Integer idDruzyna);
    public List<Zawodnik> findAll();
    public void usun(Integer idZawodnik);
    public void dodaj(Zawodnik zawodnik);
    public void edytuj(Zawodnik zawodnik);
}
