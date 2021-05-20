package com.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.prueba.domain.rols;
import com.prueba.repository.rolRepository;

@Service
@Scope("singleton")
public class rolServiceImpl implements rolService{

	@Autowired
	rolRepository rolRepository;
	
	
	@Override
	public List<rols> findAll() {
		
		return rolRepository.findAll();
	}

	@Override
	public Optional<rols> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return rolRepository.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return rolRepository.count();
	}

	@Override
	public rols save(rols entity) throws Exception {
		// TODO Auto-generated method stub
		return rolRepository.save(entity);
	}

	@Override
	public rols update(rols entity) throws Exception {
		// TODO Auto-generated method stub
		return rolRepository.save(entity);
	}

	@Override
	public void delete(rols entity) throws Exception {
		// TODO Auto-generated method stub
		rolRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);
		
	}

	@Override
	public void validate(rols entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
