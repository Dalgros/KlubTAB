package com.mycompany.controllers;

import com.mycompany.forms.TeamForm;
import com.mycompany.jpa.dao.DruzynaJpaDao;
import com.mycompany.jpa.dao.LigaJpaDao;
import com.mycompany.jpa.dao.SekcjaJpaDao;
import com.mycompany.jpa.daointerfaces.DruzynaDao;
import com.mycompany.jpa.daointerfaces.LigaDao;
import com.mycompany.jpa.daointerfaces.SekcjaDao;
import com.mycompany.jpa.model.Liga;
import com.mycompany.jpa.model.Druzyna;
import com.mycompany.jpa.model.Sekcja;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/club/{idClub}/sections/{idSection}/teams")

public class TeamController {

    Logger log = Logger.getLogger(TeamController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showTeams(@PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, Model model) {
        DruzynaDao ddao = new DruzynaJpaDao();
        model.addAttribute("Section", idSection);
        model.addAttribute("teamList", ddao.findByIdSekcja(Integer.parseInt(idSection)));
        model.addAttribute("Club", idClub);
        return "/team/show_team_view";

    }

    @GetMapping("/remove/{idTeam}")
    public ModelAndView removeTeam(Model model, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam) {
        DruzynaDao ddao = new DruzynaJpaDao();
        ddao.usun(Integer.parseInt(idTeam));
        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/");
    }

    @GetMapping("/create")
    public String createTeam(TeamForm teamForm, Model model, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);

        LigaDao ldao = new LigaJpaDao();
        List<Liga> leagueList = ldao.findAll();
        System.out.println("lista" + leagueList.size());
        model.addAttribute("leagueList", leagueList);

        return "/team/create_team_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createteam(@Valid @ModelAttribute TeamForm teamForm, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, Model model) {

        SekcjaDao sdao = new SekcjaJpaDao();
        Sekcja section = sdao.findById(Integer.parseInt(idSection));

        Druzyna team = new Druzyna();
        team.setNazwa(teamForm.getName());
        team.setIdSekcja(section);

        LigaDao ldao = new LigaJpaDao();
        Liga league = ldao.findById(teamForm.getLeague());
        System.out.println(teamForm.getLeague());
        team.setIdLiga(league);

        DruzynaDao ddao = new DruzynaJpaDao();
        ddao.dodaj(team);

        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/");
    }

    @GetMapping("/edit/{idTeam}")
    public String editTeam(TeamForm teamForm, Model model, @PathVariable("idTeam") String idTeam, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        LigaDao ldao = new LigaJpaDao();
        List<Liga> leagueList = ldao.findAll();
        model.addAttribute("leagueList", leagueList);
        return "/team/edit_team_view";
    }

    @RequestMapping(value = "/edit/{idTeam}", method = RequestMethod.POST)
    public ModelAndView editteam(@Valid TeamForm teamForm, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, Model model) {
        SekcjaDao sdao = new SekcjaJpaDao();
        Sekcja section = sdao.findById(Integer.parseInt(idSection));

        Druzyna team = new Druzyna();
        team.setNazwa(teamForm.getName());
        team.setIdSekcja(section);
        team.setIdDruzyna(new BigDecimal(idTeam));
        LigaDao ldao = new LigaJpaDao();
        Liga league = ldao.findById(teamForm.getLeague());
        team.setIdLiga(league);

        DruzynaDao ddao = new DruzynaJpaDao();
        ddao.edytuj(team);

        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/");
    }

}
