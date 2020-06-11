package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Model.Visit;
import com.spring5.springserviceproject.Service.PetService;
import com.spring5.springserviceproject.Service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends MapService<Visit, Long> implements VisitService {

    private  final  PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    //first check if the pet asscociated is saved
    @Override
    public Visit save(Visit object) {

        if(object != null){
            if(object.getPet() != null){
                if(object.getPet().getId() == null){
                    Pet savedPet = petService.save(object.getPet());
                    object.getPet().setId(savedPet.getId());
                }
            }
            else{
                throw new RuntimeException("Pet is required");
            }
        }
        else{
            return null;
        }
     return  object;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
    super.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
    super.delete(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
