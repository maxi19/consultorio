package com.consultorio.app.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDto {

    private int id;

    private String Sucursal;

    private String direccion;

    private String codigoPosta;

    private String telefono;

    private String horarioDescripcion;

    private Integer[] diasCerrado;

}
