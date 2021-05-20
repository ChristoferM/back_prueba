package com.prueba.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.domain.usuarios;

public interface usuarioRepository extends JpaRepository<usuarios,Integer>{
	

	
	@Query(value ="select * from usuario where usuario.nombre like %?1% ; " ,nativeQuery = true)
	public List<usuarios> BuscarUsuario(String  data);
}
