package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.Imascota;
import com.example.demo.interservice.Imascotaservice;
import com.example.demo.modelo.Mascota;


@Service
public class MascotaService implements Imascotaservice{

	@Autowired
	private Imascota data;
	
	@Override
	public List<Mascota> listar() {
		
		return (List<Mascota>)data.findAll();
	}

	@Override
	public Optional<Mascota> listarId(int id) {
		
		return data.findById(id);
	}

	@SuppressWarnings("unused")
	@Override
	public int save(Mascota m) {
		int res=0;
		Mascota mascota=data.save(m);
		if(!mascota.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}
	

	
}
