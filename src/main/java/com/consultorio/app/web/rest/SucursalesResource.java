package com.consultorio.app.web.rest;

import com.consultorio.app.service.dto.ReservaDto;
import com.consultorio.app.service.dto.SucursalDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class SucursalesResource {

    private List<SucursalDto> sucursales = new ArrayList<>();

    @Value("#{'${diasGrandBourd}'.split(',')}")
    private List<Integer> diaserradoGrandBourd;

    @Value("#{'${diasCerradoNogues}'.split(',')}")
    private List<Integer> diasCerradoNogues; ;

    @PostMapping("/externos/sucursales/info")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<SucursalDto>> obtenerSucursales() throws  Exception{
        SucursalDto s1= new SucursalDto();
        s1.setId(1);
        s1.setSucursal("Grand Bourg");
        Integer[] diasGb = new Integer[diaserradoGrandBourd.size()];
        diaserradoGrandBourd.toArray(diasGb);
        s1.setDiasCerrado(diasGb);

        SucursalDto s2= new SucursalDto();
        s2.setId(2);
        s2.setSucursal("Pablo Nogues");
        Integer[] diasNg = new Integer[diasCerradoNogues.size()];
        diasCerradoNogues.toArray(diasNg);
        s2.setDiasCerrado(diasNg);

        sucursales.add(s1);
        sucursales.add(s2);

        return new ResponseEntity<List<SucursalDto>>(sucursales,HttpStatus.OK);
    }

}
