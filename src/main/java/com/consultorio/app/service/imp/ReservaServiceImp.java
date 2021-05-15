package com.consultorio.app.service.imp;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.repository.ReservaRepository;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.ReservaMapperDtoEntity;
import com.consultorio.app.service.mapper.implemented.ReservaMapperDtoEntityImp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;

    private final ReservaMapperDtoEntity reservaMapperDtoEntity = new ReservaMapperDtoEntityImp();

    public ReservaServiceImp(ReservaRepository reservaRepository){
        this.reservaRepository =  reservaRepository;
    }

    @Override
    public ReservaDto persistir(ReservaDto reserva) {
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


    public  boolean existeReservaPorCodigo(String codigo) {
        List<Reserva> reservas =  reservaRepository.findByCodigo(codigo);
        if (reservas.isEmpty()){
            return false;
        }
        return true;
    }
}
