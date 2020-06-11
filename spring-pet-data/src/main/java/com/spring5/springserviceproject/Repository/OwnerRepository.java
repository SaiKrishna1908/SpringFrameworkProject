package com.spring5.springserviceproject.Repository;

import com.spring5.springserviceproject.Model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findBySecondName(String secondName);
}
