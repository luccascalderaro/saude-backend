package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.CadastroAgenda;
import com.luccascalderaro.lc1.repositories.CadastroAgendaRepository;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class CadastroAgendaService {

	@Autowired
	private CadastroAgendaRepository repo;
	

	public CadastroAgenda insert(CadastroAgenda obj) {

		obj.setId(null);

		return repo.save(obj);

	}

	public List<CadastroAgenda> findAll() {

		return repo.findAll();
	}

	public CadastroAgenda find(Integer id) {

		Optional<CadastroAgenda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Cadastro da Agenda nao encontrado"));
	}
	
	public void delete(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Não foi possivel deletar a agenda");
			
		}
		
	}

}
