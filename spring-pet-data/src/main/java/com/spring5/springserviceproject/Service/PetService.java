package com.spring5.springserviceproject.Service;

import com.spring5.springserviceproject.Model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById();

    Pet save(Pet pet);

    Set<Pet> findAll();
}
