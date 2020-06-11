package com.spring5.springserviceproject.JpaService;

import com.spring5.springserviceproject.Model.PetType;
import com.spring5.springserviceproject.Repository.PetTypeRepository;
import com.spring5.springserviceproject.Service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class PetTypeServiceImpl implements  PetTypeService{


    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes  = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
