package com.spring5.springserviceproject.Controller;

import com.spring5.springserviceproject.Service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/owner")
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
}
