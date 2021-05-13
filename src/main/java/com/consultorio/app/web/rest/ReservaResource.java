package com.consultorio.app.web.rest;

import com.consultorio.app.helpers.RangoHorario;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapapperVmDto;
import com.consultorio.app.service.mapper.implemented.ReservaMapperVmDtoImp;
import com.consultorio.app.web.rest.vm.ReservaVM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/externos")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    private ReservaMapapperVmDto dtoMapper = new ReservaMapperVmDtoImp();

    public ReservaResource(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReservaDto> registerReserva(@Valid @RequestBody ReservaVM reservaVM) {
    ReservaDto reservaDto = dtoMapper.toDto(reservaVM);
    if (reservaService.existeReservaPorDocumento(reservaDto.getDocumento())){
        ResponseEntity<ReservaDto> reservaDtoResponseEntity = new ResponseEntity<ReservaDto>(reservaDto, HttpStatus.UNPROCESSABLE_ENTITY);
        return reservaDtoResponseEntity;
    }
    reservaService.persistir( reservaDto);
    ResponseEntity<ReservaDto> reservaDtoResponseEntity = new ResponseEntity<ReservaDto>(reservaDto, HttpStatus.CREATED);
    return reservaDtoResponseEntity;
    }


    @GetMapping("/horarios/{fecha}")
    public ResponseEntity<Map<Integer, String>> dameHorarios(@PathVariable("fecha") String fecha) {
        String miFecha;
        if (!StringUtils.isEmpty(fecha)){
             miFecha = fecha;
        }
     return new ResponseEntity (RangoHorario.dameTodosLosRangos() , HttpStatus.OK);
    }
/*
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<ReservaDto> getTutorialById(@PathVariable("id") long id) {

    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {

    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {

    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {

    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {

    }
*/
}
