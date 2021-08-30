package com.consultorio.app.web.rest;

import com.consultorio.app.helpers.RangoHorario;
import com.consultorio.app.manager.ReservaManager;
import com.consultorio.app.service.dto.ReservaDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class ReservaResource {

    @Autowired
    private ReservaManager reservaManager;

    public ReservaResource(ReservaManager reservaManager ){
        this.reservaManager =  reservaManager;
    }

    @PostMapping("/externos/reservas/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReservaDto> registerReserva(@Valid  @RequestBody ReservaDto reservaDto) throws  Exception{
        return reservaManager.registrarReserva(reservaDto);
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
    public ResponseEntity<List<ReservaDto>> obtenerReservas(Pageable pageable) {
        return reservaManager.obtenerReservasPorPaginado(pageable);
    }

    @GetMapping("/internos/reservas/buscar/{id}")
    public ResponseEntity<ReservaDto> buscar( @PathVariable("id") Long id) {
        return reservaManager.buscarReservaPorId((id));
    }

    @PostMapping("internos/reservas/eliminar/")
    public ResponseEntity<Void> eliominarReserva(@Valid  @RequestBody ReservaDto reservaDto) throws Exception {
        return reservaManager.eliminarReserva(reservaDto);
    }

}
