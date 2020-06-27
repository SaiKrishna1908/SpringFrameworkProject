package com.spring5.springserviceproject.JpaService;

import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceImplTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetServiceImplTest petServiceImplTest;

    Pet pet;
    Pet pet1;
    @BeforeEach
    void setUp(){
        pet= Pet.builder().id(1L).build();
        pet1 = Pet.builder().id(2L).build();
    }

    @Test
    void save() {
        Pet savepet = Pet.builder().id(3L).build();
        when(petRepository.save(any())).thenReturn(savepet);

        Pet pet  = petRepository.save(savepet);
        assertEquals(savepet.getId(), pet.getId());

    }

    @Test
    void findAll() {
        Set<Pet> pets = new HashSet<>();
        pets.add(pet);
        pets.add(pet1);

        assertNotEquals(null, pet);
        assertNotEquals(null, pets);

        when(petRepository.findAll()).thenReturn(pets);

        Set<Pet> foundpets = new HashSet<>();
        petRepository.findAll().forEach(foundpets::add);

        assertNotEquals(null, foundpets);

        assertEquals(pets.size(), foundpets.size());
    }

    @Test
    void findById() {

    }

    @Test
    void delete() {
    }

    @Test
    void deleteByID() {
    }
}