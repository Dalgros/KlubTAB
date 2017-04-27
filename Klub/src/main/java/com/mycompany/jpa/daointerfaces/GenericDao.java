package com.mycompany.jpa.daointerfaces;

public interface GenericDao<T, K> {
    
    T findById(K id);
}
