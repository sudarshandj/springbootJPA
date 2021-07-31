package com.sudarshan.springbootJPA.controller;

import com.sudarshan.springbootJPA.dao.AlienRepo;
import com.sudarshan.springbootJPA.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("showalien.jsp");
        //Alien alien = repo.findById(aid).orElse(new Alien());
        System.out.println("findByTech:"+repo.findByTech("java"));
        System.out.println("findByName:"+repo.findByAname("shriyansh"));
        System.out.println("findByAidGreaterThan:"+repo.findByAidGreaterThan(aid));
        Alien alien = (Alien) repo.findByAidGreaterThan(aid);
        System.out.println("findByAidLessThan"+repo.findByAidLessThan(aid));
        System.out.println("findByTechSorted:"+repo.findByTechSorted("java"));

        mv.addObject(alien);
        return mv;
    }
}
