package com.consultorio.app.calendario;

import java.util.List;

public class Fecha {

    private String fecha;

    private String mensaje;

    private boolean estado;

    private List<Horario> horarios;

    public Fecha(String fecha, String mensaje, boolean estado, List<Horario> horarios) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.estado = estado;
        this.horarios = horarios;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
