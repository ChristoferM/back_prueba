package com.prueba.service.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.Mapper.rolMapper;
import com.prueba.Mapper.usuarioMapper;
import com.prueba.domain.rols;
import com.prueba.domain.usuarios;
import com.prueba.domain.dto.rolDTO;
import com.prueba.domain.dto.usuarioDTO;
import com.prueba.service.rolServiceImpl;
import com.prueba.service.usuarioService;
import com.prueba.service.rolService;
import com.prueba.service.usuarioServiceImpl;


@RestController // Servicio
@RequestMapping("/api/prueba") // Forma de llamar datos
@CrossOrigin
public class pruebaController {
	private final static Logger log = LoggerFactory.getLogger(pruebaController.class);

	@Autowired
	usuarioService usuarioService;

	@Autowired
	rolService rolService;

	@Autowired
	usuarioMapper usuarioMapper;

	@Autowired
	rolMapper rolMapper;

	@RequestMapping("/buscarTodo")
	public ResponseEntity<?> buscarTodosUsuarios() throws Exception {
		// actas acta
		List<usuarios> usuariosList = usuarioService.findAll();
		List<usuarioDTO> usuarioListDTO = usuarioMapper.toUsuariosDTOs(usuariosList);

		return ResponseEntity.ok().body(usuarioListDTO);
	}
	@RequestMapping("/buscarUsuario/{data}")
	public ResponseEntity<?> buscarUsuario(@PathVariable("data") String data) throws Exception {
		// actas acta
		List<usuarios> usuariosList = usuarioService.BuscarUsuario(data);
		List<usuarioDTO> usuarioListDTO = usuarioMapper.toUsuariosDTOs(usuariosList);

		return ResponseEntity.ok().body(usuarioListDTO);
	}
	@RequestMapping("/buscarRoles")
	public ResponseEntity<?> BuscarTodosLosRoles() throws Exception {
		// actas acta
		List<rols> rolsList = rolService.findAll();
		List<rolDTO> rolDTOs = rolMapper.toRolsDTOs(rolsList);

		return ResponseEntity.ok().body(rolDTOs);
	}

	@RequestMapping("/guardarUser")
	public ResponseEntity<?> crearUsuario(@Valid @RequestBody usuarioDTO usuarioDTO) throws Exception {
		log.info("************************************ 1");
		usuarios usuario = new usuarios();
		rols rol = new rols();

		
		log.info("DTO {}", (Object) usuarioDTO.getIdUsuario());

		log.info(usuarioDTO.getNombre());
		log.info(usuarioDTO.getActivo());
		log.info(usuarioDTO.getIdrol().toString());
		log.info("************************************ 2");
		rol.setIdRol(usuarioDTO.getIdrol());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setActivo(usuarioDTO.getActivo());
		usuario.setRol(rol);

		usuarios usuarioNew = usuarioService.save(usuario);

		log.info("************************************ 3");
		usuarioDTO usuarioDTONew = new usuarioDTO();
		usuarioDTONew = usuarioMapper.toUsuarioDTO(usuarioNew);
		log.info("************************************ 4");
		return ResponseEntity.ok().body(usuarioDTONew);
	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity<?> eliminarUsario(@PathVariable("id") Integer id) throws Exception {

		usuarioService.deleteById(id);
		return ResponseEntity.ok().body("Eliminad");

	}

	@PutMapping("/actualizarUsuario")
	public ResponseEntity<?> editarUsuario(@Valid @RequestBody usuarioDTO usuarioDTO) throws Exception {
		rols rol = new rols();
		usuarios usuario = new usuarios();
		log.info("************************************ 1");
		Optional<usuarios> usuarioOptional = usuarioService.findById(usuarioDTO.getIdUsuario());
		log.info("************************************2 ");
		if (usuarioOptional.isPresent()) {
			usuario=usuarioOptional.get();
			rol.setIdRol(usuarioDTO.getIdrol());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setActivo(usuarioDTO.getActivo());
			usuario.setRol(rol);
			log.info("************************************ 3");
			usuario = usuarioService.update(usuario);
			log.info("************************************4 ");
			return ResponseEntity.ok().body(usuarioDTO);
			
		}
		return ResponseEntity.ok().body("USUARIO NO ENCONTRADO");

	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * BuscarTodosLosRoles crearRol
	 */

}
