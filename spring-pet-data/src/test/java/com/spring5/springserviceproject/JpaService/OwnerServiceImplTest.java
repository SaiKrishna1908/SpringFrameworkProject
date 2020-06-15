package com.spring5.springserviceproject.JpaService;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Repository.OwnerRepository;
import com.spring5.springserviceproject.Repository.PetRepository;
import com.spring5.springserviceproject.Repository.PetTypeRepository;
import com.spring5.springserviceproject.Service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceImplTest ownerServiceImplTest;


    Owner owner;
    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).secondName("qwerty").build();
    }

    @Test
    void save() {
        Owner owner1 = Owner.builder().id(2L).build();

        when(ownerRepository.save(any())).thenReturn(owner1);

        Owner savedOwner = ownerRepository.save(owner1);

        assertEquals(owner1.getId(), savedOwner.getId());

    }


    @Test
    void findAll() {
    Set<Owner> ownerSet = new HashSet<>();
    ownerSet.add(owner);
    ownerSet.add(Owner.builder().id(2L).build());

    when(ownerRepository.findAll()).thenReturn(ownerSet);

    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners :: add);

    assertEquals(ownerSet.size(),owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner idowner = ownerRepository.findById(1L).get();

        assertEquals(owner.getId(), idowner.getId());

    }

    @Test
    void delete() {
        ownerRepository.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteByID() {
        ownerRepository.deleteById(owner.getId());
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findBySecondName(anyString())).thenReturn(owner);

        Owner nameowner = ownerRepository.findBySecondName("qwerty");

        assertEquals(owner.getSecondName(),nameowner.getSecondName());

        verify(ownerRepository).findBySecondName(any());

    }
}