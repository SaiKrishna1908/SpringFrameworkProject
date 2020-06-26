package com.spring5.springserviceproject.Service;

import com.spring5.springserviceproject.Model.Owner;

import java.util.Collection;

public interface OwnerService extends CRUD<Owner, Long>{
    Collection<Owner> findAllBySecondName(String secondName);
}
