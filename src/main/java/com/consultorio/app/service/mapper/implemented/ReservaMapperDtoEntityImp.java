package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.helpers.TurnosHelper;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapperDtoEntity;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
        rev.setFechaTurno(gc);
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
        Date input = entity.getFechaTurno().getTime();
        LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        reservaDto.setFechaTurno(localDate);
        reservaDto.setSucursal(entity.getSucursal());
        reservaDto.setNombre(entity.getNombre());
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
