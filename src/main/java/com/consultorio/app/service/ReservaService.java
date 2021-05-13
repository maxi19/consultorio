package com.consultorio.app.service;

import com.consultorio.app.service.dto.ReservaDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface ReservaService {

     public ReservaDto persistir(ReservaDto reserva);

     public boolean existeReservaPorDocumento(String dcumento);


}
