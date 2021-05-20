package com.prueba.Mapper;

import org.mapstruct.Mapper;

import com.prueba.domain.usuarios;
import com.prueba.domain.dto.usuarioDTO;
import java.util.List;


@Mapper
public interface usuarioMapper {
	public usuarioDTO toUsuarioDTO( usuarios usuario  );
	
	public usuarios  toUsuario(usuarioDTO usuarioDTO );
	
	public List<usuarioDTO> toUsuariosDTOs(List<usuarios>  usuarios);
	
	public List<usuarios> toUsuarios(List<usuarioDTO> usuarioDTOs );

}
