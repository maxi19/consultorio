package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapapperVmDto;
import com.consultorio.app.web.rest.vm.ReservaVM;

import java.util.ArrayList;
import java.util.List;

public class ReservaMapperVmDtoImp implements ReservaMapapperVmDto {

    @Override
    public ReservaVM toEntity(ReservaDto dto) {
        ReservaVM reservaVM = new ReservaVM();
        reservaVM.setId(dto.getId());
        reservaVM.setNombre(dto.getNombre());
        reservaVM.setApellido(dto.getApellido());
        reservaVM.setDocumento(dto.getDocumento());
        reservaVM.setSucursal(dto.getSucursal());
        reservaVM.setFechaTurno(dto.getFechaTurno());
        reservaVM.setCodigoHora(dto.getCodigoHora());
        return reservaVM;
    }

    @Override
    public ReservaDto toDto(ReservaVM entity) {
        ReservaDto reservaDto = new ReservaDto();
        reservaDto.setId(entity.getId());
        reservaDto.setNombre(entity.getNombre());
        reservaDto.setApellido(entity.getApellido());
        reservaDto.setDocumento(entity.getDocumento());
        reservaDto.setSucursal(entity.getSucursal());
        reservaDto.setFechaTurno(entity.getFechaTurno());
        reservaDto.setCodigoHora(entity.getCodigoHora());
        reservaDto.setHorario(entity.getCodigoHora());
        return reservaDto;
    }

    @Override
    public List<ReservaVM> toEntity(List<ReservaDto> dtoList)
    {
        List<ReservaVM> reservasVM = new ArrayList<>();
        for (ReservaDto dto : dtoList) {
            ReservaVM vm = toEntity(dto);
            reservasVM.add(vm);
        }
        return reservasVM;
    }

    @Override
    public List<ReservaDto> toDto(List<ReservaVM> entityList) {
        List<ReservaDto> reservasDto = new ArrayList<>();
        for (ReservaVM vm : entityList) {
            ReservaDto dto = toDto(vm);
            reservasDto.add(dto);
        }
        return reservasDto;
    }
}
