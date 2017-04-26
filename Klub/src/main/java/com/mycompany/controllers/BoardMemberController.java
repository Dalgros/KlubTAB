package com.mycompany.controllers;

import com.mycompany.forms.BoardMemberForm;
import com.mycompany.jpa.dao.CzlonekZarzaduJpaDao;
import com.mycompany.jpa.dao.KlubJpaDao;
import com.mycompany.jpa.daointerfaces.CzlonekZarzaduDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Czlonek_Zarzadu;
import com.mycompany.jpa.model.Klub;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/club/{idClub}/boardmembers")
public class BoardMemberController {

    Logger log = Logger.getLogger(BoardMemberController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String boardMemberPage(@PathVariable("idClub") String idClub, Model model) {
        CzlonekZarzaduDao czdao = new CzlonekZarzaduJpaDao();
        model.addAttribute("club", idClub);
        model.addAttribute("memberList", czdao.findByIdKlub(Integer.parseInt(idClub)));
        return "/boardmember/show_boardmember_view";
    }

    @GetMapping("/create")
    public String createMember(BoardMemberForm boardMemberForm, Model model, @PathVariable("idClub") String idClub) {
        model.addAttribute("club", idClub);
        return "/boardmember/create_boardmember_view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createmember(@Valid BoardMemberForm boardMember, @PathVariable("idClub") String idClub, Model model) {
        
        CzlonekZarzaduDao czdao = new CzlonekZarzaduJpaDao();

        KlubDao kdao = new KlubJpaDao();
        Klub klub = kdao.findById(Integer.parseInt(idClub));
        
        Czlonek_Zarzadu member = new Czlonek_Zarzadu();
        member.setImie(boardMember.getFirstName());
        member.setNazwisko(boardMember.getLastName());
        member.setStanowisko(boardMember.getPosition());
        member.setPensja(new BigInteger(boardMember.getSalary().toString()));
        member.setIdKlub(klub);
        
        czdao.dodaj(member);

        model.addAttribute("club", idClub);
        return new ModelAndView("redirect:/club/" + idClub + "/boardmembers/");

    }
    
    @GetMapping("/edit/{idMember}")
    public String editBoardMember(BoardMemberForm boardMember, Model model, @PathVariable("idClub") String idClub, @PathVariable("idMember") String idMember) {
        CzlonekZarzaduDao czdao = new CzlonekZarzaduJpaDao();
        Czlonek_Zarzadu member = czdao.findById(Integer.parseInt(idMember));
        model.addAttribute("club", idClub);
        model.addAttribute("member", member);
        return "/boardmember/edit_boardmember_view";
    }

    @PostMapping("/edit/{idMember}")
    @ResponseBody
    public ModelAndView editBoardMember(@Valid BoardMemberForm boardMember, BindingResult result, Model model, @PathVariable("idClub") String idClub, @PathVariable("idMember") String idMember) throws IOException {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/club/" + idClub + "/boardmembers/edit/" + idMember);
        }

        CzlonekZarzaduDao czdao = new CzlonekZarzaduJpaDao();
        Czlonek_Zarzadu member = new Czlonek_Zarzadu();
        member.setImie(boardMember.getFirstName());
        member.setNazwisko(boardMember.getLastName());
        member.setStanowisko(boardMember.getPosition());
        member.setPensja(new BigInteger(boardMember.getSalary().toString()));
        KlubDao kdao = new KlubJpaDao();
        Klub klub = kdao.findById(Integer.parseInt(idClub));
        member.setIdKlub(klub);
        member.setIdCzlonek(new BigDecimal(idMember));

        czdao.edytuj(member);

        return new ModelAndView("redirect:/club/" + idClub + "/boardmembers/");

    }
    
    @GetMapping("/remove/{idMember}")
    public ModelAndView removeBoardMember(Model model, @PathVariable("idClub") String idClub,@PathVariable("idMember") String idMember) {
        CzlonekZarzaduDao czdao = new CzlonekZarzaduJpaDao();
        czdao.usun(Integer.parseInt(idMember));
        return new ModelAndView("redirect:/club/" + idClub + "/boardmembers/");
    }
}
