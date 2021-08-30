package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.helpers.TurnosHelper;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapperDtoEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class ReservaMapperDtoEntityImp implements ReservaMapperDtoEntity {

    public ReservaMapperDtoEntityImp(){}

    @Override
    public Reserva toEntity(ReservaDto dto) {
        Reserva rev = new Reserva();
        rev.setNombre(dto.getNombre());
        rev.setApellido(dto.getApellido());
        rev.setDocumento(dto.getDocumento());
        rev.setTelefono(dto.getTelefono());
        rev.setFecha(new GregorianCalendar());
        rev.setSucursal(dto.getSucursal());;
        rev.setFechaTurno(dto.getFechaTurno());
        rev.setCodigo(TurnosHelper.generarCodigo(dto.getDocumento(),1));
        rev.setHorario(StringUtils.upperCase(dto.getHorario()));
        return rev;
    }

    @Override
    public ReservaDto toDto(Reserva entity) {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setId(entity.getId());
        reservaDto.setCodigoHora(entity.getCodigo());
        reservaDto.setDocumento(entity.getDocumento());
        reservaDto.setTelefono(entity.getTelefono());
        reservaDto.setFechaTurno(entity.getFechaTurno());
        reservaDto.setSucursal(entity.getSucursal());
        reservaDto.setNombre(entity.getNombre());
        reservaDto.setApellido(entity.getApellido());
        reservaDto.setHorario(entity.getHorario());
        return reservaDto;
    }

    @Override
    public List<Reserva> toEntity(List<ReservaDto> dtoList) {
        List<Reserva> reservas = new ArrayList<>();
        for (ReservaDto dto: dtoList) {
            Reserva reserva = toEntity(dto);
            reservas.add(reserva);
        }
        return reservas;
    }

    @Override
    public List<ReservaDto> toDto(List<Reserva> entityList) {
        List<ReservaDto> reservas = new ArrayList<>();
        for(Reserva reserva  : entityList) {
            ReservaDto  reservaDto= this.toDto(reserva);
            reservas.add(reservaDto);
        }
        return reservas;
    }
}
