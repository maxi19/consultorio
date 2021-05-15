package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.domain.Horario;
import com.consultorio.app.service.dto.HorarioDto;
import com.consultorio.app.service.mapper.HorarioMapperDtoEntity;

import java.util.ArrayList;
import java.util.List;

public class HorarioMapperDtoEntityImp implements HorarioMapperDtoEntity {

    @Override
    public Horario toEntity(HorarioDto dto) {
       Horario horario = new Horario();
       horario.setCodigo(dto.getCodigo());
       horario.setDescripcion(dto.getCodigo());
       return horario;
    }

    @Override
    public HorarioDto toDto(Horario entity) {
        return new HorarioDto(entity.getCodigo(),entity.getDescripcion());
    }

    @Override
    public List<Horario> toEntity(List<HorarioDto> dtoList) {
        List<Horario> horarios = new ArrayList<>();
        for (HorarioDto dto: dtoList) {
           Horario miHorario = toEntity(dto);
           horarios.add(miHorario);
        }
        return horarios;
    }

    @Override
    public List<HorarioDto> toDto(List<Horario> entityList) {
        List<HorarioDto> horarios = new ArrayList<>();
        for (Horario entity: entityList) {
            HorarioDto dto = toDto(entity);
            horarios.add(dto);
        }
        return horarios;
    }
}
