package com.spring5.springserviceproject.Service;

import com.spring5.springserviceproject.Model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(long id);

    Set<Vet> findAll();


    Vet save(Vet vet);



}
