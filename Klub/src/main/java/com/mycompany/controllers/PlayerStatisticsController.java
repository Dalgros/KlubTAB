package com.mycompany.controllers;

import com.mycompany.forms.PlayerStatisticsForm;
import com.mycompany.jpa.dao.KontraktJpaDao;
import com.mycompany.jpa.dao.SezonJpaDao;
import com.mycompany.jpa.dao.ZawodnikJpaDao;
import com.mycompany.jpa.dao.ZawodnikStatystykiJpaDao;
import com.mycompany.jpa.daointerfaces.KontraktDao;
import com.mycompany.jpa.daointerfaces.SezonDao;
import com.mycompany.jpa.daointerfaces.ZawodnikDao;
import com.mycompany.jpa.daointerfaces.ZawodnikStatystykiDao;
import com.mycompany.jpa.model.Kontrakt;
import com.mycompany.jpa.model.Sezon;
import com.mycompany.jpa.model.Zawodnik;
import com.mycompany.jpa.model.Zawodnik_Statystyki;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/club/{idClub}/sections/{idSection}/teams/{idTeam}/players/{idPlayer}")
public class PlayerStatisticsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPlayerStatistics(@PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, @PathVariable("idPlayer") String idPlayer, Model model) {

        ZawodnikStatystykiDao zsdao = new ZawodnikStatystykiJpaDao();
        ZawodnikDao zdao = new ZawodnikJpaDao();
        KontraktDao kdao = new KontraktJpaDao();
        List<Zawodnik_Statystyki> statisticsList = zsdao.findByZawodnik(Integer.parseInt(idPlayer));
        Zawodnik player = zdao.findById(Integer.parseInt(idPlayer));
        List<Kontrakt> contractList = kdao.findByZawodnik(Integer.parseInt(idPlayer));
        model.addAttribute("contractList", contractList);
        model.addAttribute("statisticsList", statisticsList);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        model.addAttribute("Section", idSection);
        model.addAttribute("Player", player);
        return "player/show_concreteplayer_view";
    }
//createContract
    
    @GetMapping("/edit/{idSeason}")
    public String editStatistics(PlayerStatisticsForm playerStatisticsForm, Model model, @PathVariable("idTeam") String idTeam, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idPlayer") String idPlayer, @PathVariable("idSeason") String idSeason) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        model.addAttribute("Player", idPlayer);
        model.addAttribute("Sezon", idSeason);
        return "/player/edit_playerstatistics_view";
    }

    @RequestMapping(value = "/edit/{idSeason}", method = RequestMethod.POST)
    public ModelAndView editPlayerStatistics(@Valid PlayerStatisticsForm playerStatisticsForm, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, Model model, @PathVariable("idPlayer") String idPlayer, @PathVariable("idSeason") String idSeason) throws ParseException {
        
//        Query query = session.createQuery("from ZawodnikStatystyki where id_zawodnik=:id and id_sezon=:ids");
//        query.setParameter("id", idPlayer);
//        query.setParameter("ids", idSeason);
//        List<ZawodnikStatystyki> statistic = query.getResultList();
//        statistic.get(0).setCzerwoneKartki(Integer.parseInt(playerStatisticsForm.getRedCards()));
//        statistic.get(0).setZolteKartki(Integer.parseInt(playerStatisticsForm.getYellowCards()));
//        statistic.get(0).setRozegraneMinuty(Integer.parseInt(playerStatisticsForm.getMinutesPlayed()));
//        statistic.get(0).setFaule(Integer.parseInt(playerStatisticsForm.getFaulsCommited()));
//        statistic.get(0).setStrzeloneBramki(Integer.parseInt(playerStatisticsForm.getScoredGoals()));
//        statistic.get(0).setStraconeBramki(Integer.parseInt(playerStatisticsForm.getLostGoals()));
//
//        session.persist(statistic.get(0));

        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/" + idTeam + "/players/" + idPlayer + "/");

    }

    @GetMapping("/remove/{idSeason}")
    public ModelAndView removeStatitics(Model model, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idTeam") String idTeam, @PathVariable("idPlayer") String idPlayer, @PathVariable("idSeason") String idSeason) {
        ZawodnikStatystykiDao zdao = new ZawodnikStatystykiJpaDao();
        //zdao.usun(Integer.parseInt(idPlayer), Integer.parseInt(idSezon));
        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/" + idTeam + "/players/" + idPlayer + "/");
    }

    @GetMapping("/create/")
    public String createStatistics(PlayerStatisticsForm playerStatisticsForm, Model model, @PathVariable("idTeam") String idTeam, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idPlayer") String idPlayer) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        model.addAttribute("Player", idPlayer);
        SezonDao sdao = new SezonJpaDao();
        List<Sezon> seasonList = sdao.findAll();
        model.addAttribute("seasonList", seasonList);
        return "/player/create_playerstatistics_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createstatistics(PlayerStatisticsForm playerStatisticsForm, Model model, @PathVariable("idTeam") String idTeam, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection, @PathVariable("idPlayer") String idPlayer) {
        model.addAttribute("Section", idSection);
        model.addAttribute("Club", idClub);
        model.addAttribute("Team", idTeam);
        model.addAttribute("Player", idPlayer);

        Zawodnik_Statystyki playerStatistics=new Zawodnik_Statystyki();
        playerStatistics.setCzerwoneKartki(Short.valueOf(playerStatisticsForm.getRedCards()));
        playerStatistics.setZolteKartki(Short.valueOf(playerStatisticsForm.getYellowCards()));
        playerStatistics.setRozegraneMinuty(new BigInteger(playerStatisticsForm.getMinutesPlayed()));
        playerStatistics.setFaule(Short.valueOf(playerStatisticsForm.getFaulsCommited()));
        playerStatistics.setStrzeloneBramki(Short.valueOf(playerStatisticsForm.getScoredGoals()));
        playerStatistics.setStraconeBramki(Short.valueOf(playerStatisticsForm.getLostGoals()));

        SezonDao sdao = new SezonJpaDao();
        List<Sezon> seasonList= sdao.findByYear(Integer.parseInt(playerStatisticsForm.getSeason()));
        playerStatistics.setSezon(seasonList.get(0));
        
        ZawodnikStatystykiDao zsdao = new ZawodnikStatystykiJpaDao();
        zsdao.dodaj(playerStatistics);

        return new ModelAndView("redirect:/club/" + idClub + "/sections/" + idSection + "/teams/" + idTeam + "/players/" + idPlayer + "/");
    }

}
