package com.consultorio.app.service;

import com.consultorio.app.service.dto.ReservaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public interface ReservaService {

     public ReservaDto persistir(ReservaDto reserva);

     public void eliminarReserva(ReservaDto reservaDto) throws Exception;

     public boolean existeReservaPorDocumento(String dcumento);

     public  boolean existeReservaPorHorarioYFecha(String horario, Calendar fecha);

     public List<ReservaDto> buscarPorFecha(Calendar fechaTurno);

    public Page<ReservaDto> obtenerTodos(Pageable pageable);

    public ReservaDto buscarPorId(Long id);

    public void actualzarTablaAutomatica();

}
