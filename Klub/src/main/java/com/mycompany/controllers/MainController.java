package com.mycompany.controllers;

import com.mycompany.jpa.dao.KlubJpaDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Klub;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/home", "/"})
    public String homePage(Model model) {

        KlubDao kdao = new KlubJpaDao();
        List<Klub> list = kdao.findAll();
        model.addAttribute("clubList", list);

        return "/home_view";
    }
    
    @RequestMapping({"/login"})
    public String loginPage(Model model) {
        
        return "/login_view";
    }
    
    @RequestMapping({"/loginSuccess"})
    public String loginPage2(Model model) {
        
        return "/login_success_view";
    }

}
