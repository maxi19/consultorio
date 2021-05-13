package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapapperVmDto;
import com.consultorio.app.web.rest.vm.ReservaVM;

import java.util.List;

public class ReservaMapperVmDtoImp implements ReservaMapapperVmDto {

    @Override
    public ReservaVM toEntity(ReservaDto dto) {
        return null;
    }

    @Override
    public ReservaDto toDto(ReservaVM entity) {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setNombre(entity.getNombre());
        reservaDto.setApellido(entity.getApellido());
        reservaDto.setDocumento(entity.getDocumento());
        reservaDto.setSucursal(entity.getSucursal());
        reservaDto.setFechaTurno(entity.getFechaTurno());
        reservaDto.setCodigoHora(entity.getCodigoHora());
        return reservaDto;
    }

    @Override
    public List<ReservaVM> toEntity(List<ReservaDto> dtoList) {
        return null;
    }

    @Override
    public List<ReservaDto> toDto(List<ReservaVM> entityList) {
        return null;
    }
}
