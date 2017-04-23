package com.mycompany.jpa.daointerfaces;

import com.mycompany.jpa.model.Liga;
import java.util.List;

public interface LigaDao extends GenericDao<Liga,Integer>{
    
    public List<Liga> findAll();
}
