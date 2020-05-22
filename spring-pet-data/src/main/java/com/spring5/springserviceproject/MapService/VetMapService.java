package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Vet;
import com.spring5.springserviceproject.Service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends MapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object);
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
