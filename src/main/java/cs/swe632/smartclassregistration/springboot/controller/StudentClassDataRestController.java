package cs.swe632.smartclassregistration.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs.swe632.smartclassregistration.springboot.model.Greeting;

@RequestMapping("/restresources")
@RestController
public class StudentClassDataRestController {

    private static final String template = "Hello, %s!";
    private static final String templateOther = "Hello, %s! You are number %d";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/{name}/{id}")
    public Greeting greetingWithPathVariable(@PathVariable(value="name") String name, @PathVariable(value="id") int id) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(templateOther, name, id));
    }
    
}