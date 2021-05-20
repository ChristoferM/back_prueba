package com.prueba;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.domain.rols;
import com.prueba.domain.usuarios;
import com.prueba.repository.rolRepository;
import com.prueba.repository.usuarioRepository;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class pruebaTest {

	private final static Logger log = LoggerFactory.getLogger(pruebaTest.class);

	@Autowired
	usuarioRepository usuarioRepository;

	@Autowired
	rolRepository rolRepository;

	@Test
	@Transactional
	void BuscarTodosLosUsuarios() {
		List<usuarios> usuariosLista = usuarioRepository.findAll();
		for (usuarios usuario : usuariosLista) {
			log.info(usuario.getNombre());
		}

	}

	@Test
	@Transactional
	void crearUsuario() {
		usuarios usuario = new usuarios();
		usuario.setNombre("usuario_4");
		usuario.setActivo("Y");
		Optional<rols> rol = rolRepository.findById(1);
		usuario.setRol(rol.get());
		usuarioRepository.save(usuario);
		this.BuscarTodosLosUsuarios();

	}

	@Test
	@Transactional
	void editarUsuario() {
		Optional<usuarios> usuarioOptional = usuarioRepository.findById(4);

		if (usuarioOptional.isPresent()) {
			usuarios usuario = usuarioOptional.get();
			usuario.setActivo("N");
			usuarioRepository.save(usuario);
			this.BuscarTodosLosUsuarios();
		} else {
			log.info("NO EXISTE ESE SUSARIO");
		}

	}

	@Test
	@Transactional
	void buscarUsuario() {
		String data = "3";
		List<usuarios> usuarioOptional = usuarioRepository.BuscarUsuario(data);

		if (usuarioOptional.size()!=0) {

			for(usuarios usuario: usuarioOptional) {
				log.info("->"+usuario.getNombre());
			}

		} else {
			log.info("NO EXISTE ESE SUSARIO");
		}

	}

	@Test
	@Transactional
	void eliminarUsario() {
		Optional<usuarios> usuarioOptional = usuarioRepository.findById(4);

		if (usuarioOptional.isPresent()) {
			usuarioRepository.delete(usuarioOptional.get());
			this.BuscarTodosLosUsuarios();

		} else {
			log.info("Erro: No se encontro el archivo");
		}

	}

	/// _----------------------------------------------ROLES

	@Test
	@Transactional
	void BuscarTodosLosRoles() {
		List<rols> rolesLista = rolRepository.findAll();
		for (rols rols : rolesLista) {
			log.info(rols.getNombre());
		}

	}

	@Test
	@Transactional
	void crearRol() {
		List<rols> rolesLista = rolRepository.findAll();
		for (rols rols : rolesLista) {
			log.info(rols.getNombre());
		}

	}

}
