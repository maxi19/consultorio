package com.consultorio.app.service;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.helpers.TurnosHelper;
import com.consultorio.app.repository.ReservaRepository;
import com.consultorio.app.service.dto.ReservaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ReservaServiceImp implements ReservaService{


    private final ReservaRepository reservaRepository;

    public ReservaServiceImp(ReservaRepository reservaRepository ){
        this.reservaRepository =  reservaRepository;
    }

    @Override
    public ReservaDto persistir(ReservaDto reserva) {
         Reserva rev = new Reserva();
         rev.setNombre(reserva.getNombre());
         rev.setApellido(reserva.getApellido());
         rev.setDocumento(reserva.getDocumento());
         rev.setFecha(new GregorianCalendar());
         rev.setSucursal(reserva.getSucursal());
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(GregorianCalendar.YEAR, reserva.getFechaTurno().getYear());
            gc.set(GregorianCalendar.MONTH, reserva.getFechaTurno().getMonthValue()-1);
            gc.set(GregorianCalendar.DATE, reserva.getFechaTurno().getDayOfMonth());
         rev.setFecha_turno(gc);
         rev.setCodigo(TurnosHelper.generarCodigo(reserva.getDocumento(),1));
         this.reservaRepository.saveAndFlush(rev);
     return  reserva;
    }

    public  boolean existeReserva(String documento) {
        List<Reserva> reservas =  reservaRepository.findByDocumento(documento);
        if (reservas.isEmpty()){
            return false;
        }
        return true;
    }


}
