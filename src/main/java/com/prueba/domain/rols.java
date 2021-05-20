package com.prueba.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol", schema = "public")
public class rols {
	
	private Integer idRol;
	
	private  String nombre;

	
	private List<usuarios> usuarioLista  = new ArrayList<usuarios>(0);

	
	
	

	@Id
	@Column(name = "id_rol", unique = true, nullable = false)
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	// -- Entidad Padre
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public List<usuarios> getUsuarioLista() {
		return usuarioLista;
	}

	public void setUsuarioLista(List<usuarios> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}
	
}
