package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.PetType;
import com.spring5.springserviceproject.Service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends MapService<PetType, Long> implements PetTypeService {
    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
