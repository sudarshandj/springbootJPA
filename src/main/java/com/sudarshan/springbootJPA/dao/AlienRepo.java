package com.sudarshan.springbootJPA.dao;

import com.sudarshan.springbootJPA.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer> {

    List<Alien> findByTech(String tech);

    List<Alien> findByAname(String name);

    List<Alien> findByAidGreaterThan(int aid);

    List<Alien> findByAidLessThan(int aid);

    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String tech);

}
