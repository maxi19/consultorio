package com.consultorio.app.service.mapper.implemented;

import com.consultorio.app.service.dto.HorarioDto;
import com.consultorio.app.service.mapper.HorarioMapperVmDto;
import com.consultorio.app.web.rest.vm.HorarioVm;

import java.util.ArrayList;
import java.util.List;

public class HorarioMapperVmDtoImp implements HorarioMapperVmDto {

    @Override
    public HorarioDto toEntity(HorarioVm dto) {
        return new HorarioDto(dto.getCodigo(),dto.getDescripcion());
    }

    @Override
    public HorarioVm toDto(HorarioDto entity) {
        return new HorarioVm( entity.getCodigo(),entity.getDescripcion());
    }

    @Override
    public List<HorarioDto> toEntity(List<HorarioVm> dtoList) {
        List<HorarioDto> horariosDto = new ArrayList<>();
        for (HorarioVm vm: dtoList) {
            HorarioDto dto =toEntity(vm);
            horariosDto.add(dto);
        }
        return horariosDto;
    }

    @Override
    public List<HorarioVm> toDto(List<HorarioDto> entityList) {
        List<HorarioVm> horariosVm = new ArrayList<>();
        for (HorarioDto dto: entityList) {
            HorarioVm vm =toDto(dto);
            horariosVm.add(vm);
        }
        return horariosVm;
    }
}
