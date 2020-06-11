package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Service.OwnerService;
import com.spring5.springserviceproject.Service.PetService;
import com.spring5.springserviceproject.Service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends MapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            //Persist the PetType
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null){
                        //persist the pet
                        Pet savedPet = petService.save(pet);
                        //TODO check if removing this line has a impact on code
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }
        else{
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }


}
