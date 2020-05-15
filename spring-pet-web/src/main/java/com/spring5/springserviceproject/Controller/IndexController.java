package com.spring5.springserviceproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value= {"", "/index", "/","index"})
    public String index(){
        return "index";
    }
}
