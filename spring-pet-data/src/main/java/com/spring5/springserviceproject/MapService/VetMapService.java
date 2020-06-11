package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Speciality;
import com.spring5.springserviceproject.Model.Vet;
import com.spring5.springserviceproject.Service.SpecialityService;
import com.spring5.springserviceproject.Service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetMapService extends MapService<Vet, Long> implements VetService {


    SpecialityService specialityService;

    VetMapService(SpecialityService specialityService){
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialitySet().size() >0){
                object.getSpecialitySet().forEach(speciality -> {
                    if(speciality.getId() == null){
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        }
        return null;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Long id) {

        return super.findById(id);
    }
}
