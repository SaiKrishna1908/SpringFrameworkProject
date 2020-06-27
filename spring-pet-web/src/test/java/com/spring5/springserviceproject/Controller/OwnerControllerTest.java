package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners = new HashSet<>();
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        owners.add(Owner.builder().id(3L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }



    @Test
    void ownerList() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners")).andExpect(status().isOk())
                .andExpect(view().name("owner/index"))
                .andExpect(model().attribute("owners", hasSize(3)));
    }


    @Test
    void showOwner() throws Exception{

        Owner owner = Owner.builder().id(1L).build();

        when(ownerService.findById(anyLong())).thenReturn(owner);

        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk()).andExpect(view().name("owner/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }

    @Test
    void findOneOwner() throws Exception{

        //given
        Collection<Owner> owners = new ArrayList<>();
        Owner owner = Owner.builder().id(1L).build();

        owners.add(owner);

        //when
        when(ownerService.findAllBySecondName(anyString())).thenReturn(owners);

        mockMvc.perform(get("/owners/search")).andExpect(status().is3xxRedirection());


    }

    @Test
    void findMultipleOwners() throws Exception{
        //given
        Collection<Owner> owners = new ArrayList<>();

        Owner owner = Owner.builder().id(1L).build();
        owners.add(owner);

        Owner owner1 = Owner.builder().id(2L).build();
        owners.add(owner1);

        Owner owner2 = Owner.builder().id(3L).build();

        when(ownerService.findAllBySecondName(anyString())).thenReturn(owners);

        mockMvc.perform(get("/owners/search")).andExpect(status().isOk());

        verify(ownerService, times(1)).findAllBySecondName(any());
        
    }

    @Test
    void searchList() throws Exception {

        mockMvc.perform(get("/owners/search")).andExpect(status().isOk())
        .andExpect(view().name("error"));
    }

    @Test
    void newOwner() throws  Exception{

        mockMvc.perform(get("/owners/new")).andExpect(status().isOk())
                .andExpect(view().name("owner/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));


    }

    @Test
    void newOwnerPost() throws Exception{

        Owner owner = Owner.builder().id(1L).firstName("monty").build();

        when(ownerService.save(any())).thenReturn(owner);


        mockMvc.perform(post("/owners/new")).andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/"+owner.getId()))
        .andExpect(model().attributeExists("owner"));

        verify(ownerService, times(1)).save(any());

    }

    @Test
    void updateOwner() throws  Exception{
        Owner owner = Owner.builder().id(1L).build();
        when(ownerService.findById(any())).thenReturn(owner);

        mockMvc.perform(get("/owners/1/edit")).andExpect(status().isOk())
                .andExpect(view().name("owner/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

    }

    @Test
    void updatePostOwner() throws Exception{
        Owner owner = Owner.builder().id(1L).build();


        when(ownerService.save(any())).thenReturn(owner);

        mockMvc.perform(post("/owners/1/edit")).andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/owners/"+owner.getId()))
                    .andExpect(model().attributeExists("owner"));

        verify(ownerService, times(1)).save(any());
    }

}