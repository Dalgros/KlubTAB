package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Sezon;
import java.util.List;

public interface SezonDao extends GenericDao<Sezon, Integer> {

    public List<Sezon> findAll();
    public List<Sezon> findByYear(Integer year);
}
