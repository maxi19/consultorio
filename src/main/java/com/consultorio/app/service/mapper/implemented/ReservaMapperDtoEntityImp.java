package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.helpers.TurnosHelper;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapperDtoEntity;

import java.util.GregorianCalendar;
import java.util.List;

public class ReservaMapperDtoEntityImp implements ReservaMapperDtoEntity {

    public ReservaMapperDtoEntityImp(){}

    @Override
    public Reserva toEntity(ReservaDto dto) {
        Reserva rev = new Reserva();
        rev.setNombre(dto.getNombre());
        rev.setApellido(dto.getApellido());
        rev.setDocumento(dto.getDocumento());
        rev.setFecha(new GregorianCalendar());
        rev.setSucursal(dto.getSucursal());
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.YEAR, dto.getFechaTurno().getYear());
        gc.set(GregorianCalendar.MONTH, dto.getFechaTurno().getMonthValue()-1);
        gc.set(GregorianCalendar.DATE, dto.getFechaTurno().getDayOfMonth());
        rev.setFecha_turno(gc);
        rev.setCodigo(TurnosHelper.generarCodigo(dto.getDocumento(),1));
        return rev;
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
