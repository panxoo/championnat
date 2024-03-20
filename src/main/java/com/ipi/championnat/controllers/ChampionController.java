package com.ipi.championnat.controllers;

import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.pojos.Stade;
import com.ipi.championnat.pojos.User;
import com.ipi.championnat.services.EquipeService;
import com.ipi.championnat.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ChampionController {
    private UserService userService;
    private EquipeService equipeService;

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
        if (equipeService.getEquipes().isEmpty()) {
            Equipe equipe1 = new Equipe("String nom", new Date(), "String logo", "String nomEntraineur", "String president", "String status", "String siege", "String telephone", "String siteWeb", "String stadeId");
            Equipe equipe2 = new Equipe("String nom", new Date(), "String logo", "String nomEntraineur", "String president", "String status", "String siege", "String telephone", "String siteWeb", "String stadeId");

            equipeService.addEquipe(equipe1);
            equipeService.addEquipe(equipe2);
        }
    }

    @PutMapping("updateEquipe/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe newData) {
        Equipe equipeToUpdate = equipeService.getEquipe(id);

        if (equipeToUpdate == null) {
            return null;
        }

        equipeToUpdate.setNom(newData.getNom());
        equipeToUpdate.setLogo(newData.getLogo());
        equipeToUpdate.setNomEntraineur(newData.getNomEntraineur());
        equipeToUpdate.setPresident(newData.getPresident());

        return equipeService.updateEquipe(id, equipeToUpdate);
    }
}
