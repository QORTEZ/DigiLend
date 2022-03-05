package com.lendTech.digiLend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class MainController {

    @RequestMapping("app")
    public String startUp(){
        return "~If I have seen further than others, it is by standing upon the shoulders of giants.";
    }
}
