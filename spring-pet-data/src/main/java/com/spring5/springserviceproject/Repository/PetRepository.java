package com.spring5.springserviceproject.Repository;

import com.spring5.springserviceproject.Model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
