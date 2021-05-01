package com.consultorio.app.service;

import com.consultorio.app.domain.Reserva;
import com.consultorio.app.repository.ReservaRepository;
import com.consultorio.app.service.dto.ReservaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservaServiceImp implements ReservaService{


    private final ReservaRepository reservaRepository;

    public ReservaServiceImp(ReservaRepository reservaRepository ){
        this.reservaRepository =  reservaRepository;
    }

    @Override
    @Transactional
    public ReservaDto persistir(ReservaDto reserva) {
     try {
         this.reservaRepository.save(new Reserva());
     }catch (Exception e)
     {
         return null;
     }
     return  reserva;
    }
}
