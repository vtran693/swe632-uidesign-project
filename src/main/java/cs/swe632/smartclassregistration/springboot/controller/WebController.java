package cs.swe632.smartclassregistration.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class WebController {
	@RequestMapping(value="/")
    public String homepage(){
        return "index";
    }
}
