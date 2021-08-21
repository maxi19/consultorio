package com.consultorio.app.service.imp;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.repository.ReservaRepository;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapperDtoEntity;
import com.consultorio.app.service.mapper.implemented.ReservaMapperDtoEntityImp;
import com.consultorio.app.web.rest.AccountResource;
import com.google.common.base.Converter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;

    private final ReservaMapperDtoEntity reservaMapperDtoEntity = new ReservaMapperDtoEntityImp();

    private final Logger log = LoggerFactory.getLogger(ReservaServiceImp.class);
    //private static final String RANGO_DEPURACION="0 0 22 * * ? *";
    private static final String RANGO_DEPURACION = "15 * * * *";

    public ReservaServiceImp(ReservaRepository reservaRepository){
        this.reservaRepository =  reservaRepository;
    }


    @Override
    public ReservaDto persistir(ReservaDto reserva) {
        Long id = this.reservaRepository.max();
        if (id == null)
            id= new Long(0);

        reserva.setId(id++);
        this.reservaRepository.saveAndFlush(reservaMapperDtoEntity.toEntity(reserva));
     return  reserva;
    }

    public  boolean existeReservaPorDocumento(String documento) {
        List<Reserva> reservas =  reservaRepository.findByDocumento(documento);
        if (reservas.isEmpty()){
            return false;
        }
        return true;
    }

    public  boolean existeReservaPorHorarioYFecha(String horario,Calendar fecha) {
        List<Reserva> reservas =  reservaRepository.findByHorarioAndFechaTurno(StringUtils.upperCase(horario),fecha);
        if (reservas.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public List<ReservaDto> buscarPorFecha(Calendar fechaTurno) {
        List<ReservaDto> reservas = reservaMapperDtoEntity.toDto(reservaRepository.findByFechaTurno(fechaTurno));
        return reservas;
    }

    @Override
    public Page<ReservaDto> obtenerTodos(Pageable pageable) {
         Page<Reserva> page = reservaRepository.findAll(pageable);
         Page<ReservaDto> pageDto = page.map(new Converter<Reserva, ReservaDto>() {
             @Override
             protected ReservaDto doForward(Reserva reserva) {
                return reservaMapperDtoEntity.toDto(reserva);
             }
             @Override
             protected Reserva doBackward(ReservaDto reservaDto) {
                 return reservaMapperDtoEntity.toEntity(reservaDto);
             }
         });

        return pageDto;
    }

    public  boolean existeReservaPorCodigo(String codigo) {
        List<Reserva> reservas =  reservaRepository.findByCodigo(codigo);
        if (reservas.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public ReservaDto buscarPorId(Long id) {
       Optional<Reserva> reserva =  reservaRepository.findById(id);
      if (reserva.get() != null){
          return reservaMapperDtoEntity.toDto(reserva.get());
      }
        return null;
    }

    @Scheduled(fixedDelay = 100000)
    @Override
    public void actualzarTablaAutomatica() {
        reservaRepository.removeOlderThan(obtenerFechaAnterior());
    }


    @Override
    public void eliminarReserva(ReservaDto reservaDto) throws Exception {
        Optional<Reserva> reserva = reservaRepository.findById(reservaDto.getId());
            if (reserva.get()  == null){
                throw new Exception("La reserva no existe");
           }
            reservaRepository.delete(reserva.get());
    }

    public Calendar obtenerFechaAnterior(){
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT-3:00"));
        return new GregorianCalendar(  cal.get(Calendar.YEAR),cal.get(Calendar.MONTH) ,cal.get(Calendar.DAY_OF_MONTH));
    }

}
