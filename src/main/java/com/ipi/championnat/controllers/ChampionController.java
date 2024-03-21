package com.ipi.championnat.controllers;

import com.ipi.championnat.pojos.*;
import com.ipi.championnat.services.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class ChampionController {
    private static String UPLOAD_DIRECTORY = "src/main/resources/static/uploaded-images/";
    private UserService userService;
    private ChampionatService championatService;
    private EquipeService equipeService;
    private JourneeService journeeService;
    private MatchGameService matchGameService;
    private PaysService paysService;
    private StadeService stadeService;
    private HttpSession session;

    public ChampionController(UserService userService, ChampionatService championatService,
                              EquipeService equipeService, JourneeService journeeService,
                              MatchGameService matchGameService, PaysService paysService,
                              StadeService stadeService, HttpSession session) {
        super();
        this.userService = userService;
        this.championatService = championatService;
        this.equipeService = equipeService;
        this.journeeService = journeeService;
        this.matchGameService = matchGameService;
        this.paysService = paysService;
        this.stadeService = stadeService;
        this.session = session;
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

        if (stadeService.recupererStade().isEmpty()) {
            saveStades();
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

    private void saveStades() {
        List<Stade> stades = new ArrayList<>();

        stades.add(new Stade("Santiago Bernabéu", "Madrid, España", 81044, "+34 91 398 43 00"));
        stades.add(new Stade("Camp Nou", "Barcelona, España", 99354, "+34 902 18 99 00"));
        stades.add(new Stade("Wembley Stadium", "Londres, Reino Unido", 90000, "+44 20 8795 9000"));
        stades.add(new Stade("Old Trafford", "Mánchester, Reino Unido", 74140, "+44 161 868 8000"));
        stades.add(new Stade("Allianz Arena", "Múnich, Alemania", 75024, "+49 89 699 31222"));
        stades.add(new Stade("Signal Iduna Park (Westfalenstadion)", "Dortmund, Alemania", 81365, "+49 180 5 99 00 00"));
        stades.add(new Stade("San Siro (Giuseppe Meazza)", "Milán, Italia", 80018, "+39 02 4879991"));
        stades.add(new Stade("Stadio Olimpico", "Roma, Italia", 70634, "+39 06 3685 2745"));
        stades.add(new Stade("Stade de France", "Saint-Denis, Francia", 81338, "+33 892 70 12 32"));
        stades.add(new Stade("Parc des Princes", "París, Francia", 48712, "+33 1 47 43 71 71"));
        stades.add(new Stade("Estádio da Luz", "Lisboa, Portugal", 64642, "+351 21 721 9555"));
        stades.add(new Stade("Estádio do Dragão", "Oporto, Portugal", 50033, "+351 22 508 3311"));
        stades.add(new Stade("Johan Cruyff Arena", "Ámsterdam, Países Bajos", 54990, "+31 20 311 1333"));
        stades.add(new Stade("De Kuip", "Róterdam, Países Bajos", 51117, "+31 10 492 9492"));

        stadeService.ajouterStades(stades);
    }

    private String saveImage(MultipartFile file, String subpath) {
        if (!file.isEmpty()) {
            try {
                File uploadDir = new File(UPLOAD_DIRECTORY + subpath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String nomFile = UUID.randomUUID().toString().substring(0, 8) + "_" + file.getOriginalFilename();

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOAD_DIRECTORY + subpath + nomFile);
                Files.write(path, bytes);

                return subpath + nomFile;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }


    @GetMapping(path = {"/", "/index"})
    public String index(Model model) {

        List<Championat> championats = this.championatService.recupererChampionat();
        List<Pays> paysList = this.paysService.recupererPaysAvecChampionat();

        model.addAttribute("championats", championats);
        model.addAttribute("payslist", paysList);

        return "index";
    }

    @GetMapping(path = "championtresultat")
    public String championtresultat(Model model, @RequestParam Long id) {

        Championat championat = this.championatService.recupererChampionat(id);
        List<MatchGame> matchGames = this.matchGameService.recupererMatchGame(championat);

        List<Date> distinctDateMatchs = matchGames.stream()
                .map(MatchGame::getDateMatchs)
                .distinct()
                .collect(Collectors.toList());


        model.addAttribute("championat", championat);
        model.addAttribute("matchGames", matchGames);
        model.addAttribute("dateMatchs",distinctDateMatchs);

        return "championtresultat";
    }

    @GetMapping(path = "championtclassement")
    public String championtclassement(Model model, @RequestParam Long id) {

        Championat championat = this.championatService.recupererChampionat(id);
        List<MatchGame> matchGames = this.matchGameService.recupererMatchGame(championat);



        model.addAttribute("championat", championat);
        model.addAttribute("matchGames", matchGames) ;

        return "championtresultat";
    }


    @GetMapping(path = "login")
    public String login(@ModelAttribute Connexion connexion) {
        return "login";
    }

    @PostMapping(path = "login")
    public String login(Model model, @Validated @ModelAttribute Connexion connexion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        User user = userService.connexionUser(connexion.getLogin(), connexion.getMdp());

        if (user == null) {
            model.addAttribute("error", "le nom d'utilisateur ou le mot de passe est incorrect");
            return "login";
        }
        session.setAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping(path = "logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping(path = "inscription")
    public String inscription(@ModelAttribute User user) {
        if (this.session.getAttribute("user") == null) {
            return "redirect:/";
        }

        return "inscription";
    }

    @PostMapping(path = "inscription")
    public String inscription(Model model, @Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "inscription";
        }

        User useraux = userService.getUser(user.getPseudo());

        if (useraux != null) {
            model.addAttribute("error", "L’user existe déjà");
            return "inscription";
        }

        userService.addUser(user);


        return "redirect:/";

    }

    @GetMapping(path = "paysadd")
    public String paysAdd(Model model, @ModelAttribute Pays pays) {

        List<Pays> payses = this.paysService.recupererPays();

        model.addAttribute("pays", payses);
        return "paysadd";
    }

    @GetMapping(path = "listchampionat")
    public String championates(Model model) {
        List<Championat> championats = championatService.recupererChampionat();
        model.addAttribute("championats", championats);

        return "listchampionat";
    }


    @GetMapping(path = "championadd")
    public String championAdd(Model model, @ModelAttribute Championat championat) {

        List<Pays> paysList = this.paysService.recupererPays();
        List<Equipe> equipes = this.equipeService.recupererEquipes();

        model.addAttribute("paysList", paysList);
        model.addAttribute("equipes", equipes);

        return "championadd";
    }

    @PostMapping(path = "championadd")
    public String championAdd(Model model, @Validated @ModelAttribute Championat championat, BindingResult bindingResult, @RequestParam("image") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            List<Pays> paysList = this.paysService.recupererPays();
            model.addAttribute("paysList", paysList);
            return "championadd";
        }
        if (championat.getDateDebut().after(championat.getDateFin())) {
            List<Pays> paysList = this.paysService.recupererPays();
            model.addAttribute("paysList", paysList);
            model.addAttribute("error", "Le date début est supérior à la date fin");
            return "championadd";
        }

        String nomFile = saveImage(file, "championat/");
        championat.setLogo(nomFile);


        this.championatService.ajouterChampionat(championat);


        return "redirect:/championatdetail?id=" + championat.getId();
    }


    @GetMapping(path = "championupd")
    public String championUpd(Model model, @RequestParam Long id) {

        List<Pays> paysList = this.paysService.recupererPays();
        Championat champion = this.championatService.recupererChampionat(id);

        model.addAttribute("paysList", paysList);
        model.addAttribute("championat", champion);

        return "championupd";
    }

    @PostMapping(path = "championupd")
    public String championUpd(Model model, @Validated @ModelAttribute Championat championat, BindingResult bindingResult, @RequestParam("image") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            List<Pays> paysList = this.paysService.recupererPays();
            model.addAttribute("paysList", paysList);
            return "championupd";
        }
        if (championat.getDateDebut().after(championat.getDateFin())) {
            List<Pays> paysList = this.paysService.recupererPays();
            model.addAttribute("paysList", paysList);
            model.addAttribute("error", "Le date début est supérior à la date fin");
            return "championupd";
        }


        Championat championatOrg = this.championatService.recupererChampionat(championat.getId());

        String nomFile;

        if (!file.isEmpty()) {
            nomFile = saveImage(file, "championat/");
        } else {
            nomFile = championatOrg.getLogo();
        }
        championat.setLogo(nomFile);

        this.championatService.ajouterChampionat(championat);

        return "redirect:/championatdetail?id=" + championat.getId();
    }


    @GetMapping(path = "championatdetail")
    public String championatDetail(Model model, @RequestParam long id,  @ModelAttribute MatchGame matchgame) {
        Championat championat = championatService.recupererChampionat(id);
        List<MatchGame> matchGames = matchGameService.recupererMatchGame(championat);
        List<Equipe> equipes = equipeService.recupererEquipes();
        List<Stade> stades = stadeService.recupererStade();

        model.addAttribute("championat", championat);
        model.addAttribute("matchGames", matchGames);
        model.addAttribute("equipes", equipes);
        model.addAttribute("stades", stades);

        return "championatdetail";
    }

    @GetMapping(path = "matchgameadd")
    public String matchgameadd(Model model, @RequestParam long id,  @ModelAttribute MatchGame matchgame) {
        Championat championat = championatService.recupererChampionat(id);
       List<Equipe> equipes = equipeService.recupererEquipes();
        List<Stade> stades = stadeService.recupererStade();

        model.addAttribute("championat", championat);
        model.addAttribute("equipes", equipes);
        model.addAttribute("stades", stades);

        return "matchgameadd";
    }



    @PostMapping(path = "matchgameadd")
    public String journeeAdd(Model model, @RequestParam MatchGame matchGame, @RequestParam long id) {
        Journee journee = matchGame.getJournee();
        Championat championat = championatService.recupererChampionat(id);
        journee.setChampionat(championat);
        journeeService.ajouterJournee(matchGame.getJournee());
        matchGameService.ajouterMatchGame(matchGame);
        return "championatdetail";
    }

    @GetMapping(path = "listequipe")
    public String listEquipe(Model model) {
        List<Equipe> equipes = equipeService.recupererEquipes();

        model.addAttribute("equipes", equipes);

        return "listequipes";
    }


    @GetMapping(path = "equipeadd")
    public String equipeAdd(Model model, @ModelAttribute Equipe equipe) {
        List<Stade> stades = stadeService.recupererStade();
        model.addAttribute("stades", stades);

        return "equipeadd";
    }

    @PostMapping(path = "equipeadd")
    public String equipeAdd(Model model, @Validated @ModelAttribute Equipe equipe, BindingResult bindingResult, @RequestParam("image") MultipartFile file) {
        System.out.println(equipe);
        if (bindingResult.hasErrors()) {
            List<Stade> stades = stadeService.recupererStade();
            model.addAttribute("stades", stades);
            return "equipeadd";
        }

        if (equipeService.recupererEquipeByNom(equipe.getNom()) != null) {
            List<Stade> stades = stadeService.recupererStade();
            model.addAttribute("stades", stades);
            model.addAttribute("error", "L’équipe existe déjà");
            return "equipeadd";
        }

      //  Stade stade = stadeService.recupererStade(stadeId);

        //equipe.setStade(stade);

        String nomFile = saveImage(file, "equipes/");

        equipe.setLogo(nomFile);


        equipeService.ajouterEquipe(equipe);


        return "redirect:/equipedetail?id=" + equipe.getId();
    }


    @GetMapping(path = "equipeupd")
    public String equipeUpd(Model model, @RequestParam Long id) {
        List<Stade> stades = stadeService.recupererStade();
        Equipe equipe = equipeService.recupererEquipe(id);

        model.addAttribute("stades", stades);
        model.addAttribute("equipe", equipe);

        return "equipeupd";
    }

    @PostMapping(path = "equipeupd")
    public String equipeUpd(Model model, @Validated @ModelAttribute Equipe equipe, BindingResult bindingResult, @RequestParam("image") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            List<Stade> stades = stadeService.recupererStade();
            model.addAttribute("stades", stades);
            return "equipeupd";
        }


        Equipe equipeAux = equipeService.recupererEquipe(equipe.getId());
        Equipe equipeVal = equipeService.recupererEquipeByNom(equipe.getNom());

        if (equipeVal != null && equipeVal.getId() != equipeAux.getId()) {
            List<Stade> stades = stadeService.recupererStade();
            model.addAttribute("stades", stades);
            model.addAttribute("error", "L’équipe existe déjà");
            return "equipeupd";
        }

      //  Stade stade = stadeService.recupererStade(stadeId);

       // equipe.setStade(stade);

        String nomFile;

        if (!file.isEmpty()) {
            nomFile = saveImage(file, "equipes/");
        } else {
            nomFile = equipeAux.getLogo();
        }

        equipe.setLogo(nomFile);

        equipeService.ajouterEquipe(equipe);

        return "redirect:/equipedetail?id=" + equipe.getId();
    }

    @GetMapping(path = "equipedetail")
    public String equipeDetail(Model model, @RequestParam Long id) {

        Equipe equipe = equipeService.recupererEquipe(id);

        model.addAttribute("equipe", equipe);

        return "equipedetail";
    }




}
