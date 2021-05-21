package com.consultorio.app.web.rest;

import com.consultorio.app.service.HorarioService;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.HorarioDto;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.EntityMapper;
import com.consultorio.app.service.mapper.implemented.HorarioMapperVmDtoImp;
import com.consultorio.app.web.rest.vm.HorarioVm;
import com.consultorio.app.web.rest.vm.ReservaVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/horarios")
public class HorarioResource {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private ReservaService reservaService;

    private EntityMapper mapper = new HorarioMapperVmDtoImp();

    public HorarioResource(HorarioService horarioService, ReservaService reservaService){
        this.horarioService = horarioService;
        this.reservaService = reservaService;
    }


    @GetMapping("/consultarfecha/{fecha}")
    public ResponseEntity<Map<String, ReservaVM>> dameHorarios( @PathVariable("fecha") @DateTimeFormat(pattern="yyyy-MM-dd") @Valid Date date) {

        List<HorarioDto> horarios = horarioService.dameHorarios();
        List<HorarioVm> horariosVm = mapper.toDto(horarios);
        Map<String, HorarioVm> map = new HashMap<>();

        Calendar fechaTurno = Calendar.getInstance();
        fechaTurno.setTime(date);

        List<ReservaDto> reservas = reservaService.buscarPorFecha(fechaTurno);
        if ( reservas == null || reservas.isEmpty() ){
            return new ResponseEntity (map , HttpStatus.OK);
        }

        for (HorarioVm horarioVm : horariosVm) {
            map.put(horarioVm.getCodigo(),horarioVm);
        }
        for (ReservaDto reservaDto:  reservas) {
            map.get(reservaDto.getHorario()).setEstado(false);
        }

        return new ResponseEntity (map , HttpStatus.OK);
    }

}
