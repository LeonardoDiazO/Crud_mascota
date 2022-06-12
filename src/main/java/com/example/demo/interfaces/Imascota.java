package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Mascota;


@Repository
public interface Imascota extends CrudRepository<Mascota, Integer >{

}
