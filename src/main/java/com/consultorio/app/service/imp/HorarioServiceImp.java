package com.consultorio.app.service.imp;

import com.consultorio.app.domain.Horario;
import com.consultorio.app.repository.HorarioRepository;
import com.consultorio.app.service.HorarioService;
import com.consultorio.app.service.dto.HorarioDto;
import com.consultorio.app.service.mapper.HorarioMapperDtoEntity;
import com.consultorio.app.service.mapper.implemented.HorarioMapperDtoEntityImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImp implements HorarioService {

    private final HorarioRepository horarioRepository;

    private  HorarioMapperDtoEntity mapper = new HorarioMapperDtoEntityImp();

    public HorarioServiceImp(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    public List<HorarioDto> dameHorarios() {
        return mapper.toDto(horarioRepository.findAll()) ;
    }

    @Override
    public void crearHorario(String codigo, String descripcion) throws Exception {
        Horario horario = new Horario(codigo, descripcion);
        horarioRepository.save(horario);
    }

    @Override
    public void eliminarHorario(long id) throws Exception {
        Optional<Horario> horario = horarioRepository.findById(id);
        if (horario.isPresent()){
            horarioRepository.delete(horario.get());
        }else{
            throw new Exception("el horario es inexistente");
        }
    }
}
