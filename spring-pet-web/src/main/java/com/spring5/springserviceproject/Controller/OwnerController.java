package com.spring5.springserviceproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/owner")
@Controller
public class OwnerController {

    @RequestMapping(value={"/","","index.html","index"})
    String ownerList(){
        return "owner/index";
    }
}
