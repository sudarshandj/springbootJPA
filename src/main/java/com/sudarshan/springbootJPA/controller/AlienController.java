package com.sudarshan.springbootJPA.controller;

import com.sudarshan.springbootJPA.dao.AlienRepo;
import com.sudarshan.springbootJPA.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @PostMapping("/alien")//Post method mapping data used for save new data entry only
    public Alien addAliens(@RequestBody Alien alien){
        System.out.println("PostMapping");
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("/alien/{aid}")//Delete Method mapping for delete specific record
    public String deleteALien(@PathVariable int aid){//mapping url parameter use PathVariable
        System.out.println("DeleteMapping");
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }

    @GetMapping(value = "/aliens") //, produces = {"application/xml"}//Get Method mapping both XML and JSON Data
    public List<Alien> getAliens(){
        System.out.println("GetMapping");
        return repo.findAll();
    }

    @PutMapping(path = "/alien",consumes = {"application/json"})//Put method mapping for specific json data add or update
    public Alien saveOrUpdate(@RequestBody Alien alien){
        System.out.println("PutMapping");
        repo.save(alien);
        return alien;
    }

    @RequestMapping("/alien/{aid}")//Get/Post Request Method without rest controller
    @ResponseBody//When only response is fetched with @Controller
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        System.out.println("RequestMapping /alien/{aid}");
        return repo.findById(aid);
    }
}