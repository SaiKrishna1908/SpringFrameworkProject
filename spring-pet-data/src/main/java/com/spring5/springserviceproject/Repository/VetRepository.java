package com.spring5.springserviceproject.Repository;

import com.spring5.springserviceproject.Model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
