package com.spring5.springserviceproject.Service;

import java.util.Set;

public interface CRUD<T, ID> {

    T save(T object);

    Set<T> findAll();

    T findById(ID id);

    void delete(T object);

    void deleteByID(ID id);
}
