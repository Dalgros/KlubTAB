package com.mycompany.controllers;

import com.mycompany.forms.BuildingForm;
import com.mycompany.jpa.dao.BudynekJpaDao;
import com.mycompany.jpa.daointerfaces.BudynekDao;
import com.mycompany.jpa.model.Budynek;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
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

//    @RequestMapping(value = "/edit/{idBuilding}", method = RequestMethod.GET)
//    public String buildingEdit(BuildingForm buildingForm, @PathVariable("idBuilding") String idBuilding, Model model) {
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        //creating session object  
//        Session session = factory.openSession();
//
//        Budynek building = session.find(Budynek.class, Integer.parseInt(idBuilding));
//        model.addAttribute("building", building);
//        if (building.getBudynekAdministracyjny() != null) {
//            model.addAttribute("bAdmin", building.getBudynekAdministracyjny());
//        }
//        if (building.getStadion() != null) {
//            model.addAttribute("bArena", building.getStadion());
//
//        }
//        if (building.getObiektTreningowy() != null) {
//            model.addAttribute("bTrainingObject", building.getObiektTreningowy());
//        }
//
//        session.close();
//        factory.close();
//        return "/building/edit_building_view";
//    }
//
//    @RequestMapping(value = "/edit/{idBuilding}", method = RequestMethod.POST)
//    public ModelAndView buildingedit(@Valid BuildingForm buildingForm, @PathVariable("idBuilding") String idBuilding, @PathVariable("idClub") String idClub, Model model) {
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        //creating session object  
//        Session session = factory.openSession();
//
//        Transaction t = session.beginTransaction();
//        Budynek building = session.find(Budynek.class, Integer.parseInt(idBuilding));
//
//        if (building.getStadion() != null) {
//            Stadion arena = session.find(Stadion.class, Integer.parseInt(idBuilding));
//            arena.setDyscyplina(buildingForm.getDiscipline());
//            arena.setIloscMiejsc(Integer.parseInt(buildingForm.getCapacity()));
//            arena.setNazwa(buildingForm.getName());
//            session.update(arena);
//        }
//        if (building.getObiektTreningowy() != null) {
//            model.addAttribute("bTrainingObject", building.getObiektTreningowy());
//        }
//        building.setKodPocztowy(buildingForm.getPostcode());
//        building.setMiejscowosc(buildingForm.getCity());
//        building.setUlicanumer(buildingForm.getStreet());
//
//        session.update(building);
//        t.commit();
//
//        session.close();
//        factory.close();
//
//        return new ModelAndView("redirect:/club/" + idClub + "/buildings/");
//
//    }
//
//    @GetMapping("/remove/{idBuilding}")
//    public ModelAndView removeClub(Model model, @PathVariable("idClub") String idClub, @PathVariable("idBuilding") String idBuilding) {
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        //creating session object  
//        Session session = factory.openSession();
//
//        Transaction t = session.beginTransaction();
//        Budynek building = session.find(Budynek.class, Integer.parseInt(idBuilding));
//        session.remove(building);
//        t.commit();
//        log.info("działa");
//        session.close();
//        factory.close();
//        return new ModelAndView("redirect:/club/" + idClub + "/buildings/");
//    }
//
//    @GetMapping("/create")
//    public String createBuilding(BuildingForm buildingForm, Model model, @PathVariable("idClub") String idClub) {
//        model.addAttribute("Club", idClub);
//        return "/building/create_building_view";
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ModelAndView createbuilding(@Valid BuildingForm buildingForm, @PathVariable("idClub") String idClub, Model model) {
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//
//        //creating session object  
//        Session session = factory.openSession();
//
//        Transaction t = session.beginTransaction();
//
//        Klub klub=session.find(Klub.class, Integer.parseInt(idClub));
//        Budynek building = new Budynek();
//        building.setKodPocztowy(buildingForm.getPostcode());
//        building.setMiejscowosc(buildingForm.getCity());
//        building.setUlicanumer(buildingForm.getStreet());
//        building.setIdKlub(klub);
//        session.persist(building);
//
//        if (buildingForm.getCapacity() != null) {
//            Stadion arena = new Stadion(building.getIdbudynek());
//            arena.setDyscyplina(buildingForm.getDiscipline());
//            arena.setIloscMiejsc(Integer.parseInt(buildingForm.getCapacity()));
//            arena.setNazwa(buildingForm.getName());
//            arena.setBudynek(building);
//            session.persist(arena);
//        } else if (buildingForm.getDiscipline() != null) {
//            ObiektTreningowy ot = new ObiektTreningowy(building.getIdbudynek());
//            ot.setBudynek(building);
//            session.persist(ot);
//        } else {
//            BudynekAdministracyjny ba = new BudynekAdministracyjny(building.getIdbudynek());
//            ba.setBudynek(building);
//            session.persist(ba);
//        }
//
//        t.commit();
//
//        session.close();
//        factory.close();
//
//        return new ModelAndView("redirect:/club/" + idClub + "/buildings/");
//
//    }
}
