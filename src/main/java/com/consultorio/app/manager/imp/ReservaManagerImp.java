package com.consultorio.app.manager.imp;

import com.consultorio.app.manager.ReservaManager;
import com.consultorio.app.service.HorarioService;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.ReservaDto;
import io.github.jhipster.web.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Component
public class ReservaManagerImp implements ReservaManager {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private HorarioService horarioService;

    public ResponseEntity<ReservaDto> registrarReserva(ReservaDto reservaDto)  throws Exception {
        if (reservaService.existeReservaPorHorarioYFecha(reservaDto.getCodigoHora(),reservaDto.getFechaTurno())){
            throw new Exception("ya existe una reserva");
        }
        reservaService.persistir( reservaDto);
        return new ResponseEntity<ReservaDto>(reservaDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ReservaDto>> obtenerReservasPorPaginado(Pageable pageable) {
        Page<ReservaDto> page = reservaService.obtenerTodos(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity(page.getContent(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReservaDto> buscarReservaPorId(Long id) {
        ReservaDto reserva = reservaService.buscarPorId(id);
        return new ResponseEntity<>(reserva,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<Void> eliminarReserva(ReservaDto reservaDto) throws Exception {
        reservaService.eliminarReserva(reservaDto);
        return new ResponseEntity (HttpStatus.NO_CONTENT);
    }


}
