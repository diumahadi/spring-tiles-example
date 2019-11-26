package com.edu.springtilesexample;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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


    @GetMapping("/auth")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model, @RequestParam String redirectUrl) {
        model.addAttribute("client_id", "client_key");
        model.addAttribute("client_secret", "client_secret");
        String url = "http://localhost:8081/receive-request-auth";
        ResponseEntity<RestResponse> response = new RestTemplate()
                .postForEntity(url, new User("mahadi","mahadi@gmail.com","Jr"), RestResponse.class);
        System.out.println(response.getBody());
        return new ModelAndView("redirect://"+redirectUrl, model);
    }
}
