package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Model.Visit;
import com.spring5.springserviceproject.Service.PetService;
import com.spring5.springserviceproject.Service.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class VisitControllerTest {

    @Mock
    PetService petService;

    @Mock
    VisitService visitService;

    VisitController visitController;

    MockMvc mockMvc;

    Pet pet;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        visitController = new VisitController(visitService, petService);
        mockMvc  = MockMvcBuilders.standaloneSetup(visitController).build();
        pet = Pet.builder().id(1L).build();
    }

    @Test
    void initCreation() throws Exception {
        //when
        when(petService.findById(any())).thenReturn(pet);
        mockMvc.perform(get("/owners/1/pets/1/visits/new")).andExpect(status().isOk())
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdateVisitForm"));

        verify(petService, times(1)).findById(anyLong());
    }

    @Test
    void initProcess() throws Exception {
        //when
        when(petService.findById(any())).thenReturn(pet);
        mockMvc.perform(post("/owners/1/pets/1/visits/new")).andExpect(status().is3xxRedirection())
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("redirect:/owners/1"));

        verify(visitService, times(1)).save(any());
    }
}