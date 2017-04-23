package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.DruzynaDao;
import com.mycompany.jpa.daointerfaces.ZawodnikDao;
import com.mycompany.jpa.model.Zawodnik;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ZawodnikJpaDao extends GenericJpaDao<Zawodnik, Integer> implements ZawodnikDao{

}
