package com.consultorio.app.web.rest;

import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/externos")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    public ReservaResource(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReservaDto> registerReserva(@Valid @RequestBody ReservaDto reservaDto) {
        //reservaService.persistir( reservaDto);
      return new ResponseEntity<ReservaDto>(reservaDto,HttpStatus.CREATED) ;
    }

/*
    @GetMapping("/tutorials")
    public ResponseEntity<List<ReservaDto>> getAllTutorials(@RequestParam(required = false) String title) {

    }

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
