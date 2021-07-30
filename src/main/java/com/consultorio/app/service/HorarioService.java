package com.consultorio.app.service;

import com.consultorio.app.domain.Horario;
import com.consultorio.app.repository.HorarioRepository;
import com.consultorio.app.service.dto.HorarioDto;
import com.sun.mail.util.LineInputStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface HorarioService {

    public List<HorarioDto> dameHorarios();

    public void crearHorario(String codigo, String descripcion) throws  Exception;

    public void eliminarHorario(long id) throws  Exception;
}
