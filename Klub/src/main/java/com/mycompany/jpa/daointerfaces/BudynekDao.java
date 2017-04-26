package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Budynek;
import java.util.List;

public interface BudynekDao extends GenericDao<Budynek,Integer>{
    
    public List<Budynek> findByIdKlub(Integer idKlub);
    public void usun(Integer idBudynek);
    public void dodaj(Budynek budynek);
    public void edytuj(Budynek budynek);
}
