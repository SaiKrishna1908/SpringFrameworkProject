package com.spring5.springserviceproject.Repository;

import com.spring5.springserviceproject.Model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long > {
}
