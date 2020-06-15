package com.spring5.springserviceproject.MapService;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    private  Long id  = 2L;
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        Owner owner = Owner.builder().id(1L).build();
        ownerMapService.save(owner);
        ownerMapService.save(Owner.builder().id(3L).build());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(id).build();
       Owner savedOwner=  ownerMapService.save(owner);
       assertEquals(savedOwner , owner);
    }

    @Test
    void findAll() {
        Set<Owner> set = ownerMapService.findAll();
        assertEquals(1, set.size());
    }

    @Test
    void deleteByID() {
        ownerMapService.deleteByID(1L);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        Owner idOwner = ownerMapService.findById(3L);
        assertEquals(3L, idOwner.getId());
    }
}