package com.spring5.springserviceproject.JpaService;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Repository.OwnerRepository;
import com.spring5.springserviceproject.Repository.PetRepository;
import com.spring5.springserviceproject.Repository.PetTypeRepository;
import com.spring5.springserviceproject.Service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository,
                            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner save(Owner object) {
       return ownerRepository.save(object);

    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    public Owner findByLastName(String secondName) {
        return ownerRepository.findBySecondName(secondName);
    }
}
