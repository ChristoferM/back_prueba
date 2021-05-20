package com.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.prueba.domain.usuarios;
import com.prueba.repository.usuarioRepository;


@Service
@Scope("singleton")
public class usuarioServiceImpl  implements usuarioService{

	@Autowired
	usuarioRepository usuarioRepository;
	
	@Override
	public List<usuarios> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
	

	@Override
	public Optional<usuarios> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return usuarioRepository.count();
	}

	@Override
	public usuarios save(usuarios entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	public usuarios update(usuarios entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	public void delete(usuarios entity) throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public void validate(usuarios entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<usuarios> BuscarUsuario(String data) {
		// TODO Auto-generated method stub
		return usuarioRepository.BuscarUsuario(data);
	}

}
