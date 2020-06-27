package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Model.PetType;
import com.spring5.springserviceproject.Service.OwnerService;
import com.spring5.springserviceproject.Service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequiredArgsConstructor
@RequestMapping("/owners/{id}")
public class PetController {


    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner populateOwner(@PathVariable Long id){
        return ownerService.findById(id);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
