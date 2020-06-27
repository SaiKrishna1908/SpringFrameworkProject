package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Model.PetType;
import com.spring5.springserviceproject.Service.OwnerService;
import com.spring5.springserviceproject.Service.PetService;
import com.spring5.springserviceproject.Service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PetControllerTest {


    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService petService;

    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController(petTypeService, ownerService, petService);
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

        owner = Owner.builder().id(1L).build();
        petTypes = new HashSet<>();
        petTypes.add(new PetType(1L, "cat"));
        petTypes.add(new PetType(2L, "dog"));
        petTypes.add(new PetType(3L, "hamster"));
    }

    @Test
    void initCreation() throws Exception {

        //when
        when(ownerService.findById(any())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new")).andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));

    }

    @Test
    void processCreation() throws Exception {

        when(ownerService.findById(any())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/new")).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());

    }

    @Test
    void initUpdate() throws  Exception{
        when(ownerService.findById(any())).thenReturn(owner);
        when(petService.findById(any())).thenReturn(Pet.builder().id(1L).build());

        mockMvc.perform(get("/owners/1/pets/1/edit")).andExpect(status().isOk()).
                andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));

        verify(petService, times(1)).findById(any());
    }

    @Test
    void processUpdate() throws Exception{
        when(ownerService.findById(any())).thenReturn(owner);
        when(petService.findById(any())).thenReturn(Pet.builder().id(1L).build());

        mockMvc.perform(post("/owners/1/pets/1/edit")).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService, times(1)).save(any());

    }
}