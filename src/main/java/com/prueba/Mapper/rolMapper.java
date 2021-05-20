package com.prueba.Mapper;

import org.mapstruct.Mapper;

import com.prueba.domain.rols;
import com.prueba.domain.dto.rolDTO;


import java.util.List;

@Mapper
public interface rolMapper {
	
	public  rolDTO toRolDTO(rols rol );
	
	public  rols toRol(rolDTO rolDTO );
	
	public List<rolDTO> toRolsDTOs(List<rols> rols);
	
	public List<rols> toRols(List<rolDTO> rolDTOs);
	
	
}
