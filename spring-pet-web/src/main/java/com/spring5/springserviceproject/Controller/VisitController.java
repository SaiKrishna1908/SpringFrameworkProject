package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Pet;
import com.spring5.springserviceproject.Model.Visit;
import com.spring5.springserviceproject.Service.PetService;
import com.spring5.springserviceproject.Service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;
    private final PetService petService;

    @InitBinder
    void setUpBindind(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit getVisit(@PathVariable("petId") Long petId, Model model ){

        Pet pet= petService.findById(petId);
        model.addAttribute("pet",pet);
        Visit visit  = new Visit();
        pet.getVisits().add(visit);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initCreation(@PathVariable Long petId, Model model){
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initProcess(@Valid Visit visit, BindingResult bindingResult, @PathVariable Long ownerId){
        if(bindingResult.hasErrors()){
            return "pets/createOrUpdateVisitForm";
        }
        else{
            visitService.save(visit);
            return "redirect:/owners/"+ownerId;
        }
    }
}
