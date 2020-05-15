package com.spring5.springserviceproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping(value = {"/Vet", "/vet","/vet/index.html"})
    public String vet(){
        return "vet/index";
    }
}
