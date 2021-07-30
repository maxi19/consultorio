package com.consultorio.app.web.rest;

import com.consultorio.app.helpers.RangoHorario;
import com.consultorio.app.service.HorarioService;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.dto.UserDTO;
import com.consultorio.app.service.mapper.ReservaMapapperVmDto;
import com.consultorio.app.service.mapper.implemented.ReservaMapperVmDtoImp;
import com.consultorio.app.web.rest.vm.ReservaVM;
import io.github.jhipster.web.util.PaginationUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@RestController
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private HorarioService horarioService;

    private ReservaMapapperVmDto dtoMapper = new ReservaMapperVmDtoImp();

    public ReservaResource(ReservaService reservaService, HorarioService horarioService){
        this.reservaService = reservaService;
        this.horarioService = horarioService;
    }

    @PostMapping("/externos/reservas/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReservaDto> registerReserva(@Valid  @RequestBody ReservaVM reservaVM) {
        ReservaDto reservaDto = dtoMapper.toDto(reservaVM);

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.YEAR, reservaDto.getFechaTurno().getYear());
        gc.set(GregorianCalendar.MONTH, reservaDto.getFechaTurno().getMonthValue()-1);
        gc.set(GregorianCalendar.DATE, reservaDto.getFechaTurno().getDayOfMonth());
        Calendar fechaTurno = gc;

        if (reservaService.existeReservaPorHorarioYFecha(reservaDto.getCodigoHora(),fechaTurno)){
            ResponseEntity<ReservaDto> reservaDtoResponseEntity = new ResponseEntity<ReservaDto>(reservaDto, HttpStatus.UNPROCESSABLE_ENTITY);
            return reservaDtoResponseEntity;
        }
        reservaService.persistir( reservaDto);
        ResponseEntity<ReservaDto> reservaDtoResponseEntity = new ResponseEntity<ReservaDto>(reservaDto, HttpStatus.CREATED);
        return reservaDtoResponseEntity;
    }


    @GetMapping("/externos/reservas/consultarfecha/{fecha}")
    public ResponseEntity<Map<Integer, String>> dameHorarios(@PathVariable("fecha") String fecha) {
        String miFecha;
        if (!StringUtils.isEmpty(fecha)){
             miFecha = fecha;
        }
     return new ResponseEntity (RangoHorario.dameTodosLosRangos() , HttpStatus.OK);
    }


    @GetMapping("/internos/reservas")
    public ResponseEntity<List<ReservaVM>> obtenerReservas(Pageable pageable) {
        final Page<ReservaDto> page = reservaService.obtenerTodos(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
           return new ResponseEntity(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/internos/reservas/buscar/{id}")
    public ResponseEntity<ReservaVM> buscar( @PathVariable("id") Long id) {
        final ReservaDto reserva = reservaService.buscarPorId(id);
        return new ResponseEntity<ReservaVM>(dtoMapper.toEntity(reserva),HttpStatus.OK) ;
    }

}
