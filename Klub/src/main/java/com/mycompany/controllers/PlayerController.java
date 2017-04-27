package com.mycompany.controllers;

import com.mycompany.forms.PlayerForm;
import com.mycompany.jpa.dao.DruzynaJpaDao;
import com.mycompany.jpa.dao.KontraktJpaDao;
import com.mycompany.jpa.dao.ZawodnikJpaDao;
import com.mycompany.jpa.daointerfaces.DruzynaDao;
import com.mycompany.jpa.daointerfaces.KontraktDao;
import com.mycompany.jpa.daointerfaces.ZawodnikDao;
import com.mycompany.jpa.model.Druzyna;
import com.mycompany.jpa.model.Kontrakt;
import com.mycompany.jpa.model.Zawodnik;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/club/{idClub}/sections/{idSection}/teams/{idTeam}/players")

public class PlayerController {

    Logger log = Logger.getLogger(TeamController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPlayers(@PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, Model model) {
        ZawodnikDao zdao = new ZawodnikJpaDao();
        model.addAttribute("playersList", zdao.findByIdDruzyna(Integer.parseInt(idTeam)));
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        model.addAttribute("Section", idSection);
        return "player/show_player_view";
    }

    @GetMapping("/remove/{idPlayer}")
    public ModelAndView removePlayer(Model model, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, @PathVariable("idPlayer") String idPlayer) {
        ZawodnikDao zdao = new ZawodnikJpaDao();
        zdao.usun(Integer.parseInt(idPlayer));
        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/" + idTeam + "/players/");
    }

    @GetMapping("/create")
    public String createPlayer(PlayerForm playerForm, Model model, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        return "/player/create_player_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createplayer(@Valid PlayerForm playerForm, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, Model model) throws ParseException {
        DruzynaDao ddao = new DruzynaJpaDao();
        Druzyna team = ddao.findById(Integer.parseInt(idTeam));

        Zawodnik player = new Zawodnik();
        player.setImie(playerForm.getName());
        player.setDataUrodzenia(getDate(playerForm.getDay(), playerForm.getMonth(), playerForm.getYear()));
        player.setNazwisko(playerForm.getLastname());
        player.setWaga(Short.valueOf(playerForm.getWeight()));
        player.setWzrost(Short.valueOf(playerForm.getHeight()));
        
        ZawodnikDao zdao = new ZawodnikJpaDao();
        zdao.dodaj(player);
        
        List<Zawodnik> listZ = zdao.findAll();
        Zawodnik zz = null;
        for(Zawodnik z : listZ){
            if(z.getImie().equals(player.getImie())&& z.getNazwisko().equals(player.getNazwisko()))
                zz = z;
        }

        KontraktDao kdao = new KontraktJpaDao();
        Kontrakt kontrakt = new Kontrakt();
        kontrakt.setDruzyna(team);
        kontrakt.setZawodnik(zz);
        kontrakt.setPoczatekKontraktu(getDate(playerForm.getSday(), playerForm.getSmonth(), playerForm.getSyear()));
        kontrakt.setKoniecKontraktu(getDate(playerForm.getEday(), playerForm.getEmonth(), playerForm.getEyear()));
        kontrakt.setPensja(new BigInteger(playerForm.getSalary()));
        kontrakt.setWartoscRynkowa(new BigInteger(playerForm.getValue()));
        kdao.dodaj(kontrakt);

        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/" + idTeam + "/players/");
    }

    public Date getDate(String day, String month, String year) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        StringBuilder s = new StringBuilder(day);
        s.append("-");
        s.append(month);
        s.append("-");
        s.append(year);
        Date myDate = formatter.parse(s.toString());
        //java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        return myDate;
    }

    @GetMapping("/edit/{idPlayer}")
    public String editPlayer(PlayerForm playerForm, Model model, @PathVariable("idTeam") String idTeam, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idPlayer") String idPlayer) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        model.addAttribute("Player", idPlayer);
        return "/player/edit_player_view";
    }

    @RequestMapping(value = "/edit/{idPlayer}", method = RequestMethod.POST)
    public ModelAndView editteam(@Valid PlayerForm playerForm, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, Model model, @PathVariable("idPlayer") String idPlayer) throws ParseException {
        ZawodnikDao zdao = new ZawodnikJpaDao();

        Zawodnik player = new Zawodnik();
        player.setIdZawodnik(new BigDecimal(idPlayer));
        player.setImie(playerForm.getName());
        player.setDataUrodzenia(getDate(playerForm.getDay(), playerForm.getMonth(), playerForm.getYear()));
        player.setNazwisko(playerForm.getLastname());
        player.setWaga(Short.valueOf(playerForm.getWeight()));
        player.setWzrost(Short.valueOf(playerForm.getHeight()));
        zdao.edytuj(player);

        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/" + idTeam + "/players/");

    }

}
