package com.consultorio.app.service.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String documento;

    @NotBlank
    private String telefono;

    @NotNull
    private int sucursal;

    @NotNull
    private Calendar fechaTurno;

    @NotBlank
    private String codigoHora;

    @NotBlank
    private String horario;

    @Override
    public String toString() {
        return "ReservaDto{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", documento='" + documento + '\'' +
            ", telefono='" + telefono + '\'' +
            ", sucursal=" + sucursal +
            ", fechaTurno=" + fechaTurno +
            ", codigoHora='" + codigoHora + '\'' +
            ", horario='" + horario + '\'' +
            '}';
    }
}
