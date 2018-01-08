package it.crazyones.easyexplore.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bilal90 on 10/9/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
