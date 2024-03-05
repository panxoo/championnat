package com.ipi.championnat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChampionController {

    public ChampionController(){
        super();
    }

    @GetMapping(path = {"/", "/index"})
    public String index(){
        return "index";
    }

}
