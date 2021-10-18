package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute MessageForm newMessage, Model model){
        model.addAttribute("greetings", this.messageListService.getMessages());
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
