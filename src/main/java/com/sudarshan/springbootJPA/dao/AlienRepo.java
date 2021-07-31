package com.sudarshan.springbootJPA.dao;

import com.sudarshan.springbootJPA.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien,Integer> {


}
