package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapService extends MapService<Pet, Long> implements PetService {
    @Override
    public Pet save(Pet object) {
        return super.save(object);
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
