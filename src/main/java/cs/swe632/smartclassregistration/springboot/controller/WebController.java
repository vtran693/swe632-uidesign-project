package cs.swe632.smartclassregistration.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
	@RequestMapping(value="/home")
    public String homepage(){
        return "main-menu";
    }
	
	@RequestMapping(value="/data/inject/student")
	public String loadStudentPage() {
		return "load-data";
	}
}


