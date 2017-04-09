package com.mycompany.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/home", "/"})
    public String homePage(Model model) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //creating session object  
        Session session = factory.openSession();
        List<Klub> clubList = session.createCriteria(Klub.class).list();
        model.addAttribute("clubList", clubList);
        session.close();
        factory.close();
        
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
