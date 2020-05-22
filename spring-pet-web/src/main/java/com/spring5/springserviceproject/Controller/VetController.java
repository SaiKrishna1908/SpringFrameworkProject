package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService ;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping(value = {"/Vet", "/vet","/vet/index.html"})
    public String vet(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }
}
