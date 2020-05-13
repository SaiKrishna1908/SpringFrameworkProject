package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Service.CRUD;

import java.util.Set;

public class PetMapService extends MapService<Pet, Long> implements CRUD<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
    super.deleteById(aLong);
    }

    @Override
    public void delete(Pet object) {
    super.delete(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
