package com.example.demo.interservice;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Mascota;

public interface Imascotaservice {

	public List<Mascota>listar();
	public Optional<Mascota>listarId(int id);
	public int save (Mascota m);
	public void delete (int id);
	
	
	
}
