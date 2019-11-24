package com.edu.springtilesexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String home() {
        return "site.home";
    }

    @RequestMapping(value = "/greet/{name}", method=RequestMethod.GET)
    public ModelAndView greetTwoWays(@PathVariable(value="name") final String name) {
        return new ModelAndView("site.greeting", "name", name);
    }
}
