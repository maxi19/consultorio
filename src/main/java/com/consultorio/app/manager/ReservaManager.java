package com.consultorio.app.manager;

import com.consultorio.app.service.dto.ReservaDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservaManager {

    ResponseEntity<ReservaDto> registrarReserva(ReservaDto reservaDto)  throws Exception;

    ResponseEntity<List<ReservaDto>> obtenerReservasPorPaginado(Pageable pageable);

    ResponseEntity<ReservaDto> buscarReservaPorId(Long id);

    ResponseEntity<Void> eliminarReserva(ReservaDto reservaDto) throws Exception;
}
