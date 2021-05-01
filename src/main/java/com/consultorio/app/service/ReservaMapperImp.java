package com.consultorio.app.service;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapper;

import java.util.List;

public class ReservaMapperImp implements ReservaMapper {

    @Override
    public Reserva toEntity(ReservaDto dto) {
       Reserva reserva = new Reserva();
       reserva.setNombre(dto.getNombre());
       reserva.setApellido(dto.getApellido());

        return reserva;
    }

    @Override
    public ReservaDto toDto(Reserva entity) {
        return null;
    }

    @Override
    public List<Reserva> toEntity(List<ReservaDto> dtoList) {
        return null;
    }

    @Override
    public List<ReservaDto> toDto(List<Reserva> entityList) {
        return null;
    }
}
