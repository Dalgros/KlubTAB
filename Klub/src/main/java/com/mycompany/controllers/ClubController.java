package com.mycompany.controllers;

import com.mycompany.forms.ClubForm;
import com.mycompany.jpa.dao.KlubJpaDao;
import com.mycompany.jpa.daointerfaces.KlubDao;
import com.mycompany.jpa.model.Klub;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.imageio.ImageIO;
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
@RequestMapping("/club")
public class ClubController {

    Logger log = Logger.getLogger(ClubController.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String clubPage(@PathVariable("id") String id, Model model) {

        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(id));
        model.addAttribute("club", club);

        return "/club/show_club_view";
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] clubPhoto(@PathVariable("id") String id) throws SQLException {
        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(id));
        return club.getLogo();
    }

    @GetMapping("/create")
    public String createClub(ClubForm clubForm) {
        return "/club/create_club_view";
    }
    
    @PostMapping("/create")
    @ResponseBody
    public ModelAndView createClub(@Valid ClubForm clubForm, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/club/create");
        }
       
        KlubDao kdao = new KlubJpaDao();
        Klub club = new Klub();
        club.setNazwa(clubForm.getName());
        club.setLogo(logoConvertion(clubForm.getLogo().getBytes()));
        kdao.dodaj(club);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/{id}/edit")
    public String editClub(ClubForm clubForm, Model model, @PathVariable("id") String id) {
        KlubDao kdao = new KlubJpaDao();
        Klub club = kdao.findById(Integer.parseInt(id));
        model.addAttribute("club", club);
        return "/club/edit_club_view";
    }

    @PostMapping("/{id}/edit")
    @ResponseBody
    public ModelAndView editClub(@Valid ClubForm clubForm, BindingResult result, Model model, @PathVariable("id") String id) throws IOException {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/home");
        }
        
        Klub club = new Klub();
        BigDecimal bd = new BigDecimal(id);
        club.setIdKlub(bd);
        club.setNazwa(clubForm.getName());
        club.setLogo(logoConvertion(clubForm.getLogo().getBytes()));
        return new ModelAndView("redirect:/club/" + club.getIdKlub());

    }
    
    @GetMapping("/{id}/remove")
    public ModelAndView removeClub(Model model, @PathVariable("id") String id) {
        KlubDao kdao = new KlubJpaDao();
        kdao.usun(Integer.parseInt(id));
        return new ModelAndView("redirect:/home");
    }

    private byte[] logoConvertion(byte[] bytes) {
        int width = 200;
        int height = 200;
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            BufferedImage img = ImageIO.read(in);
            if (height == 0) {
                height = (width * img.getHeight()) / img.getWidth();
            }
            if (width == 0) {
                width = (height * img.getWidth()) / img.getHeight();
            }
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            ImageIO.write(imageBuff, "jpg", buffer);

            bytes = buffer.toByteArray();
        } catch (IOException e) {
            log.error("File convertion error");
        }
        return bytes;
    }
}
