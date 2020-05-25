package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends MapService<Owner, Long> implements OwnerService {
    @Override
    public Owner save(Owner object) {
        return super.save( object);
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
