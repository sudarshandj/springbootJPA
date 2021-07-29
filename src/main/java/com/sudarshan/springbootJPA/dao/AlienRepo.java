package com.sudarshan.springbootJPA.dao;

import com.sudarshan.springbootJPA.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien,Integer> {

}
