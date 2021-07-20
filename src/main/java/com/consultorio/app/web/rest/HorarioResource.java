package com.consultorio.app.web.rest;

import com.consultorio.app.service.HorarioService;
import com.consultorio.app.service.ReservaService;
import com.consultorio.app.service.dto.HorarioDto;
import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.mapper.EntityMapper;
import com.consultorio.app.service.mapper.implemented.HorarioMapperVmDtoImp;
import com.consultorio.app.web.rest.vm.HorarioVm;
import com.consultorio.app.web.rest.vm.ReservaVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/horarios")
public class HorarioResource {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private ReservaService reservaService;

    @Value("${reservas.rango.dias}")
    private int rangeOfDays;

    private EntityMapper mapper = new HorarioMapperVmDtoImp();

    public HorarioResource(HorarioService horarioService, ReservaService reservaService){
        this.horarioService = horarioService;
        this.reservaService = reservaService;
    }


    @GetMapping("/consultarfecha/{fecha}")
    //busca disponibls a poartir de una fecha determinada
    public ResponseEntity<Map<String, ReservaVM>> dameHorarios( @PathVariable("fecha") @DateTimeFormat(pattern="yyyy-MM-dd") @Valid Date date) {

        List<HorarioDto> horarios = horarioService.dameHorarios();
        List<HorarioVm> horariosVm = mapper.toDto(horarios);

        Map<String, HorarioVm> map = new HashMap<>();

        Calendar fechaTurno = Calendar.getInstance();
        fechaTurno.setTime(date);

        List<ReservaDto> reservas = reservaService.buscarPorFecha(fechaTurno);
        if ( reservas == null || reservas.isEmpty() ){
            return new ResponseEntity (map , HttpStatus.OK);
        }

        for (HorarioVm horarioVm : horariosVm) {
            map.put(horarioVm.getCodigo(),horarioVm);
        }
        for (ReservaDto reservaDto:  reservas) {
            map.get(reservaDto.getHorario()).setEstado(false);
        }

        return new ResponseEntity (map , HttpStatus.OK);
    }

    @GetMapping("/consultarPorSucursal/{sucursal}")
    //busca disponibls a poartir de una fecha determinada
    public ResponseEntity<Map<String, List<HorarioVm>>> consultarPorSucursal( @PathVariable("sucursal") String sucursal) {

        List<HorarioDto> horarios = horarioService.dameHorarios();
        List<HorarioVm> horariosVm = mapper.toDto(horarios);

        Map<String, List<HorarioVm>> mapHorarios = new HashMap<>();

        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);


        for (int i = 0; i < rangeOfDays; i++){
            c.add(Calendar.DATE, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd--MM-yyyy");
            String date = sdf.format(c.getTime());
            mapHorarios.put(date, horariosVm);
        }

        return new ResponseEntity (mapHorarios , HttpStatus.OK);
    }

}
