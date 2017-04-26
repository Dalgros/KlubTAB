package com.mycompany.controllers;

import com.mycompany.forms.BuildingForm;
import com.mycompany.jpa.dao.BudynekJpaDao;
import com.mycompany.jpa.dao.KlubJpaDao;
import com.mycompany.jpa.daointerfaces.BudynekDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Budynek;
import com.mycompany.jpa.model.Klub;
import java.math.BigDecimal;
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
@RequestMapping("/club/{idClub}/buildings")
public class BuildingController {

    Logger log = Logger.getLogger(BuildingController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String buildingPage(@PathVariable("idClub") String idClub, Model model) {
        BudynekDao bdao = new BudynekJpaDao();
        model.addAttribute("club",idClub);
        model.addAttribute("buildings", bdao.findByIdKlub(Integer.parseInt(idClub)));
        return "/building/show_building_view";
    }

    @RequestMapping(value = "/edit/{idBuilding}", method = RequestMethod.GET)
    public String buildingEdit(BuildingForm buildingForm, @PathVariable("idBuilding") String idBuilding, Model model) {
        BudynekDao bdao = new BudynekJpaDao();
        Budynek building = bdao.findById(Integer.parseInt(idBuilding));
        model.addAttribute("building", building);
        return "/building/edit_building_view";
    }

    @RequestMapping(value = "/edit/{idBuilding}", method = RequestMethod.POST)
    public ModelAndView buildingEdit(@Valid BuildingForm buildingForm, @PathVariable("idBuilding") String idBuilding, @PathVariable("idClub") String idClub, Model model) {
        
        BudynekDao bdao = new BudynekJpaDao();
        Budynek building = new Budynek();
        BigDecimal bd = new BigDecimal(idBuilding);
        building.setIdBudynek(bd);
        building.setKodPocztowy(buildingForm.getPostcode());
        building.setMiejscowosc(buildingForm.getCity());
        building.setUlicanumer(buildingForm.getStreet());
        building.setFunkcja(buildingForm.getFunction());
        
        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(idClub));
        building.setIdKlub(club);
  
        bdao.edytuj(building);
        model.addAttribute("club", idClub);
        return new ModelAndView("redirect:/club/" + idClub + "/buildings/");
    }

    @GetMapping("/remove/{idBuilding}")
    public ModelAndView removeBuilding(Model model, @PathVariable("idClub") String idClub, @PathVariable("idBuilding") String idBuilding) {
        BudynekDao bdao = new BudynekJpaDao();
        bdao.usun(Integer.parseInt(idBuilding));
        return new ModelAndView("redirect:/club/" + idClub + "/buildings/");
    }

    @GetMapping("/create")
    public String createBuilding(BuildingForm buildingForm, Model model, @PathVariable("idClub") String idClub) {
        model.addAttribute("Club", idClub);
        return "/building/create_building_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createBuilding(@Valid BuildingForm buildingForm, @PathVariable("idClub") String idClub, Model model) {
        BudynekDao bdao = new BudynekJpaDao();
        Budynek building = new Budynek();
        building.setKodPocztowy(buildingForm.getPostcode());
        building.setMiejscowosc(buildingForm.getCity());
        building.setUlicanumer(buildingForm.getStreet());
        building.setFunkcja(buildingForm.getFunction());
        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(idClub));
        building.setIdKlub(club);
        bdao.dodaj(building);
        model.addAttribute("club", idClub);
        return new ModelAndView("redirect:/club/" + idClub + "/buildings/");
    }
}
