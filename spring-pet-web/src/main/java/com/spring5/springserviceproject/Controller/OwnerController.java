package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@RequestMapping(value = "/owners")
@Controller
public class OwnerController {

    private final  String CREATEOWNERVIEW = "createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping(value={"/","","index.html","index"})
    String ownerList(Model model)
    {
        //System.out.println(ownerService.findAll().size());
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }


    @GetMapping(value = "/{id}")
    ModelAndView showOwner(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("owner/ownerDetails");
        modelAndView.addObject(ownerService.findById(id));
        System.out.println("Owner Found");
            return modelAndView;
    }

    @GetMapping("/find")
    String findOwner(Model model){
        model.addAttribute(Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping("/search")
    String searchList(Owner owner, BindingResult result, Model model){
        if(owner.getSecondName() == null) {
            owner.setSecondName("");
        }
        Collection<Owner> results = ownerService.findAllBySecondName("%"+owner.getSecondName()+"%");

        if(results.isEmpty()){
            result.rejectValue("secondName", "Not Found", "Not Found");
        }
        else if(results.size() == 1){
            Owner owner1 = results.iterator().next();
            return "redirect:/owners/"+owner1.getId();
        }

        else {
            System.out.println(results.size());
            model.addAttribute("selections", results);
            return "owner/ownersList";
        }
        return "error";
    }

    @GetMapping("/new")
    String newOwner(Model model){

        model.addAttribute("owner",Owner.builder().build());
        return "owner/"+CREATEOWNERVIEW;
    }

    @PostMapping("/new")
    String newPostOwner(Model model, @Valid Owner owner, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "owners/"+CREATEOWNERVIEW;
        }
        else{
            Owner savedOwner = ownerService.save(owner);
            model.addAttribute("owner",savedOwner);
            return "redirect:/owners/"+savedOwner.getId();
        }
    }

    @GetMapping("/{id}/edit")
    String updateOwner(@PathVariable Long id,Model model) throws Exception{
        Owner owner = ownerService.findById(id);
        //todo add validation in-case owner is null
        model.addAttribute("owner", owner);
        return "owner/"+CREATEOWNERVIEW;

    }

    @PostMapping("/{id}/edit")
    String updatePostOwner(@PathVariable Long id, Model model, @Valid Owner owner,BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            return  "owner/"+CREATEOWNERVIEW;
        }
        else{
            owner.setId(id);
            Owner savedOwner = ownerService.save(owner);
            model.addAttribute("owner", owner);
            return "redirect:/owners/"+savedOwner.getId();
        }
    }

}
