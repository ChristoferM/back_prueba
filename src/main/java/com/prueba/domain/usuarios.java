package com.prueba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "usuario", schema = "public")
public class usuarios {
	
	private Integer idUsuario;
	
	private String nombre;
	
	private String activo;
	
	private rols rol ;

	@Id
	@Column(name = "id_usuario", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "activo", nullable = false)
	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	// Entidad Hija
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_rol")
	public rols getRol() {
		return rol;
	}

	public void setRol(rols rol) {
		this.rol = rol;
	}

	
	

}
