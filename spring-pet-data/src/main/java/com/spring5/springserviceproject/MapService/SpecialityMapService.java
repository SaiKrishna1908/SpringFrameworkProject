package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Speciality;
import com.spring5.springserviceproject.Service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialityMapService extends MapService<Speciality, Long> implements SpecialityService {
    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
         super.deleteById(aLong);
    }

    @Override
    public void delete(Speciality object) {
         super.delete(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
