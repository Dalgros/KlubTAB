package com.mycompany.controllers;

import com.mycompany.forms.SectionForm;
import com.mycompany.jpa.dao.KlubJpaDao;
import com.mycompany.jpa.dao.SekcjaJpaDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.daointerfaces.SekcjaDao;
import com.mycompany.jpa.model.Klub;
import com.mycompany.jpa.model.Sekcja;
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
@RequestMapping("/club/{idClub}/sections")

public class SectionController {

    Logger log = Logger.getLogger(SectionController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sectionPage(@PathVariable("idClub") String idClub, Model model) {
        SekcjaDao sdao = new SekcjaJpaDao();
        model.addAttribute("sectionList", sdao.findByIdKlub(Integer.parseInt(idClub)));
        model.addAttribute("Club", idClub);
        return "/section/show_section_view";

    }

    @GetMapping("/remove/{idSection}")
    public ModelAndView removeSection(Model model, @PathVariable("idClub") String idClub, @PathVariable("idSection") String idSection) {
        SekcjaDao sdao = new SekcjaJpaDao();
        sdao.usun(Integer.parseInt(idSection));
        return new ModelAndView("redirect:/club/" + idClub + "/sections/");
    }

    @GetMapping("/create")
    public String createSection(SectionForm sectionForm, Model model, @PathVariable("idClub") String idClub) {
        model.addAttribute("Club", idClub);
        return "/section/create_section_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createsection(@Valid SectionForm sectionForm, @PathVariable("idClub") String idClub, Model model) {
        SekcjaDao sdao = new SekcjaJpaDao();
        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(idClub));
        Sekcja section = new Sekcja();
        section.setDyscyplina(sectionForm.getDiscipline());
        section.setPlec(sectionForm.getSex());
        section.setIdKlub(club);
        sdao.dodaj(section);
        return new ModelAndView("redirect:/club/" + idClub + "/sections/");
    }

    @RequestMapping(value = "/edit/{idSection}", method = RequestMethod.GET)
    public String sectionEdit(SectionForm sectionForm, @PathVariable("idSection") String idSection, Model model) {
        SekcjaDao sdao = new SekcjaJpaDao();
        Sekcja section = sdao.findById(Integer.parseInt(idSection));
        model.addAttribute("section", section);
        return "/section/edit_section_view";
    }

    @RequestMapping(value = "/edit/{idSection}", method = RequestMethod.POST)
    public ModelAndView sectionedit(@Valid SectionForm sectionForm, @PathVariable("idSection") String idSection, @PathVariable("idClub") String idClub, Model model) {
        SekcjaDao sdao = new SekcjaJpaDao();
        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(idClub));
        Sekcja section = new Sekcja();
        section.setDyscyplina(sectionForm.getDiscipline());
        section.setPlec(sectionForm.getSex());
        section.setIdKlub(club);
        section.setIdSekcja(new BigDecimal(idSection));
        sdao.edytuj(section);
        return new ModelAndView("redirect:/club/" + idClub + "/sections/");

    }
}
