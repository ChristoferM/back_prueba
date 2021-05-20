package com.prueba.service;

import java.util.List;

import com.prueba.domain.usuarios;
import com.prueba.service.GenericService;


public interface usuarioService  extends GenericService <usuarios,Integer> {
	public List<usuarios> BuscarUsuario(String  data);

}
