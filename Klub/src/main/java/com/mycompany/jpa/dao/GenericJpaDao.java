package com.mycompany.jpa.dao;

import com.mycompany.jpa.daointerfaces.GenericDao;
import com.mycompany.jpaUtil.JpaFactory;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

public class GenericJpaDao<T, K> implements GenericDao<T, K> {

    private final Class<T> type;

    public GenericJpaDao() 
    {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T findById(K id) 
    {
        EntityManager em = getEntityManager();
        BigDecimal bdID = BigDecimal.valueOf((Integer)id);
        T dto = em.find(type, bdID);
        em.close();
        return dto;
    }

    protected EntityManager getEntityManager() 
    {
        return JpaFactory.getEntityManager();
    }
}