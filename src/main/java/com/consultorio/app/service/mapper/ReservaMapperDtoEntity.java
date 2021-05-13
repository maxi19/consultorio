package com.consultorio.app.service.mapper;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.service.dto.ReservaDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface ReservaMapperDtoEntity extends  EntityMapper<ReservaDto,Reserva> {
}
