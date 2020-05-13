package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Service.CRUD;

import java.util.Set;

public class OwnerMapService extends MapService<Owner, Long> implements CRUD<Owner, Long> {
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
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
