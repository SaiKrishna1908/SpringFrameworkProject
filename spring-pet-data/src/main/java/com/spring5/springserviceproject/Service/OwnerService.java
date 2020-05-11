package com.spring5.springserviceproject.Service;

import com.spring5.springserviceproject.Model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(long id);

    Owner findByLastName(String LastName);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
