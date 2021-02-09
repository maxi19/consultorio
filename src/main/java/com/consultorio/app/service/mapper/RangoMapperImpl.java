package com.consultorio.app.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.consultorio.app.domain.Rango;
import com.consultorio.app.service.dto.RangoDTO;

public class RangoMapperImpl implements RangoMapper {

	@Override
	public Rango toEntity(RangoDTO dto) {
		Rango rango = new Rango();
		rango.setId(dto.getId());
		rango.setValue(dto.getValue());
		return rango;
	}

	@Override
	public RangoDTO toDto(Rango entity) {
		RangoDTO dto = new RangoDTO();
		dto.setId(entity.getId());
		dto.setValue(entity.getValue());
		return dto;
	}

	@Override
	public List<Rango> toEntity(List<RangoDTO> dtoList) {
		List<Rango> rangos = new ArrayList<Rango>();
		for (RangoDTO rangoDto : dtoList) {
			Rango rango = new Rango();
			rango.setId(rangoDto.getId());
			rango.setValue(rangoDto.getValue());
			rangos.add(rango);
		}
		
		return rangos;
	}

	@Override
	public List<RangoDTO> toDto(List<Rango> entityList) {
		List<RangoDTO> dtos = new ArrayList<RangoDTO>();
		for (Rango unRango : entityList) {
			RangoDTO dto = new RangoDTO();
			dto.setId(unRango.getId());
			dto.setValue(unRango.getValue());
			dtos.add(dto);
		}
		return dtos;
	}

	
	
	
	
	
	
	
	
	
}
