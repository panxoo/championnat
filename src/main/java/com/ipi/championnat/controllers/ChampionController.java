package com.ipi.championnat.controllers;

import com.ipi.championnat.pojos.Equipe;
import com.ipi.championnat.pojos.User;
import com.ipi.championnat.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    @PutMapping("updateEquipe/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipeDetails) {
        Equipe equipe = equipeService.getEquipeById(id);

        if (equipe == null) {
            throw new ResourceNotFoundException("Équipe non trouvée avec l'ID : " + id);
        }

        Equipe.setNom(equipeDetails.getNom());
        Equipe.setLogo(equipeDetails.getLogo());
        Equipe.setNomEntraineur(equipeDetails.getNomEntraineur());
        Equipe.setPresident(equipeDetails.getPresident());

        return equipeService.saveEquipe(equipe);
}
