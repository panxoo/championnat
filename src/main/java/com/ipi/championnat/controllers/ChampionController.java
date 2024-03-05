package com.ipi.championnat.controllers;

import com.ipi.championnat.pojos.User;
import com.ipi.championnat.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChampionController {
    private UserService userService;

    public ChampionController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping(path = {"/", "/index"})
    public String index() {
        return "index";
    }

    @PostConstruct
    private void init() {
        if (userService.getUsers().isEmpty()) {
            User user1 = new User("Lopez",
                    "Carlos",
                    "CarlosLogin",
                    "passwordCarlos",
                    "CarlosPseudo",
                    "carlos@email.com");
            User user2 = new User("Perez",
                    "Mia",
                    "MiaLogin",
                    "passwordMia",
                    "MiaPseudo",
                    "mia@email.com");

            userService.addUser(user1);
            userService.addUser(user2);
        }
    }
}
