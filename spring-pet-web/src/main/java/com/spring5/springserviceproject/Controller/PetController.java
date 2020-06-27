package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Model.PetType;
import com.spring5.springserviceproject.Service.OwnerService;
import com.spring5.springserviceproject.Service.PetService;
import com.spring5.springserviceproject.Service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RequiredArgsConstructor
@RequestMapping("/owners/{id}")
@Controller
public class PetController {


    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;

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

    @GetMapping("/pets/new")
    public String initCreation(Model model, Owner owner) throws Exception{
        Pet pet = Pet.builder().build();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreation(Model model, Owner owner,
                                  @Valid Pet pet,BindingResult bindingResult) throws Exception{
        if(StringUtils.hasLength(pet.getName())&& pet.isNew() && owner.getPet(pet.getName(),true)!=null){
            bindingResult.rejectValue("name","duplicate","already exists");
        }

        owner.getPets().add(pet);
        if(bindingResult.hasErrors()){
            model.addAttribute("pet",pet);
            return "pets/createOrUpdatePetForm";
        }
        else{
            petService.save(pet);
            return "redirect:/owners/"+owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdate(Model model, Owner owner, @PathVariable Long petId) throws Exception{
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdaet(@Valid Pet pet, Model model, Owner owner, @PathVariable Long petId, BindingResult bindingResult)
            throws Exception{
        if(bindingResult.hasErrors()){
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return  "pets/createOrUpdatePetForm";
        }
        else{
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/"+owner.getId();
        }
    }

}
