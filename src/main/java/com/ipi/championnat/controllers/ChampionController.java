package com.ipi.championnat.controllers;

import com.ipi.championnat.pojos.Championat;
import com.ipi.championnat.pojos.MatchGame;
import com.ipi.championnat.pojos.Pays;
import com.ipi.championnat.pojos.User;
import com.ipi.championnat.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ChampionController {
    private UserService userService;
    private ChampionatService championatService;
    private EquipeService equipeService;
    private JourneeService journeeService;
    private MatchGameService matchGameService;
    private PaysService paysService;
    private StadeService stadeService;
    private static String UPLOAD_DIRECTORY = "src/main/resources/static/uploaded-images/";

    public ChampionController(UserService userService, ChampionatService championatService, EquipeService equipeService, JourneeService journeeService, MatchGameService matchGameService, PaysService paysService, StadeService stadeService) {
        super();
        this.userService = userService;
        this.championatService = championatService;
        this.equipeService = equipeService;
        this.journeeService = journeeService;
        this.matchGameService = matchGameService;
        this.paysService = paysService;
        this.stadeService = stadeService;
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

        if (paysService.recupererPays().isEmpty()) {
            savePays();
        }

    }

    private void savePays() {
        List<Pays> payses = new ArrayList<>();

        payses.add(new Pays(" Espagne", "fi fi-es"));
        payses.add(new Pays(" France", "fi fi-fr"));
        payses.add(new Pays(" Italie", "fi fi-it"));
        payses.add(new Pays(" Allemagne", "fi fi-de"));
        payses.add(new Pays(" Royaume-Uni", "fi fi-gb"));
        payses.add(new Pays(" Portugal", "fi fi-pt"));
        payses.add(new Pays(" Pays-Bas", "fi fi-nl"));
        payses.add(new Pays(" Belgique", "fi fi-be"));
        payses.add(new Pays(" Suède", "fi fi-se"));
        payses.add(new Pays(" Autriche", "fi fi-at"));
        payses.add(new Pays(" Suisse", "fi fi-ch"));
        payses.add(new Pays(" Norvège", "fi fi-no"));
        payses.add(new Pays(" Danemark", "fi fi-dk"));
        payses.add(new Pays(" Finlande", "fi fi-fi"));
        payses.add(new Pays(" Grèce", "fi fi-gr"));
        payses.add(new Pays(" République tchèque", "fi fi-cz"));
        payses.add(new Pays(" Pologne", "fi fi-pl"));
        payses.add(new Pays(" Hongrie", "fi fi-hu"));
        payses.add(new Pays(" Roumanie", "fi fi-ro"));
        payses.add(new Pays(" Bulgarie", "fi fi-bg"));
        payses.add(new Pays(" Slovaquie", "fi fi-sk"));
        payses.add(new Pays(" Croatie", "fi fi-hr"));
        payses.add(new Pays(" Slovénie", "fi fi-si"));
        payses.add(new Pays(" Estonie", "fi fi-ee"));
        payses.add(new Pays(" Lettonie", "fi fi-lv"));
        payses.add(new Pays(" Lituanie", "fi fi-lt"));
        payses.add(new Pays(" Serbie", "fi fi-rs"));
        payses.add(new Pays(" Monténégro", "fi fi-me"));
        payses.add(new Pays(" Bosnie-Herzégovine", "fi fi-ba"));
        payses.add(new Pays(" Macédoine du Nord", "fi fi-mk"));
        payses.add(new Pays(" Albanie", "fi fi-al"));
        payses.add(new Pays(" Kosovo", "fi fi-xk"));
        payses.add(new Pays(" Islande", "fi fi-is"));
        payses.add(new Pays(" Malte", "fi fi-mt"));
        payses.add(new Pays(" Chypre", "fi fi-cy"));
        payses.add(new Pays(" Angleterre", "fi fi-gb-eng"));
        payses.add(new Pays(" Écosse", "fi fi-gb-sct"));
        payses.add(new Pays(" Pays de Galles", "fi fi-gb-wls"));
        payses.add(new Pays(" Irlande", "fi fi-ie"));
        payses.add(new Pays(" Suisse", "fi fi-ch"));

        paysService.ajouterPays(payses);
    }

    @GetMapping(path = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping(path = "paysadd")
    public String paysAdd(Model model, @ModelAttribute Pays pays) {

        List<Pays> payses = this.paysService.recupererPays();

        model.addAttribute("pays", payses);
        return "paysadd";
    }

    @GetMapping(path = "listchampionat")
    public String championates(Model model){
        List<Championat> championats = championatService.recupererChampionat();
        model.addAttribute("championats", championats);

        return "listchampionat";
    }

    @GetMapping(path = "championatdetail")
    public String championatDetail(Model model, @RequestParam long id){
        Championat championat = championatService.recupererChampionat(id);
        model.addAttribute("championat", championat);

        return "championatdetail";
    }


    @GetMapping(path = "championadd")
    public String championAdd(Model model, @ModelAttribute Championat championat) {

        List<Pays> paysList = this.paysService.recupererPays();
        model.addAttribute("paysList", paysList);

        return "championadd";
    }

    @PostMapping(path = "championadd")
    public String championAdd(Model model, @Validated @ModelAttribute Championat championat, BindingResult bindingResult, @RequestParam("image") MultipartFile file, @RequestParam("pays.id") Long paysId) {
        if (bindingResult.hasErrors()) {
            return "championadd";
        }
        if (championat.getDateDebut().after(championat.getDateFin())) {
            model.addAttribute("Error", "Le date début est supérior à la date fin");
        }

        Pays selectPays = paysService.recupererPays(paysId);

        championat.setPays(selectPays);


        if (!file.isEmpty()) {
            try {
                File uploadDir = new File(UPLOAD_DIRECTORY + "championat");
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String nomFile = UUID.randomUUID().toString().substring(0, 8) + "_" + file.getOriginalFilename();

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIRECTORY + "championat/" + nomFile);
                Files.write(path, bytes);

                championat.setLogo("championat/" + nomFile);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.championatService.ajouterChampionat(championat);
        return "championadd";
    }


}
