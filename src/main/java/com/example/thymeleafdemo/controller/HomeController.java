package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("greetings", new String[]{"Hi", "Hello", "goodbye", "aaagoodbye", "Good day", "Goodbye"});
        return "home";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
        // If I want a name "John" to be displayed instead of "World", URL has to be: http://localhost:8080/greeting?name=John
    }

    @GetMapping("/simple-home")
    public String getSimpleHome(Model model){
        model.addAttribute("firstVisit", "Anything...");
        return "simple-home";
    }

    @PostMapping("/simple-home")
    public String postSimpleHome(){
        return "simple-home";

    }
}
