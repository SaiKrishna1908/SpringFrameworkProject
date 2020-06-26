package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RequestMapping(value = "/owners")
@Controller
public class OwnerController {

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
}
