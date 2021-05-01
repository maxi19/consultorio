package com.consultorio.app.helpers;

import java.util.HashMap;
import java.util.Map;

public enum RangoHorario {

    Rango1(1,"dfewfd"),
    Rango2(2,"dfewfd"),
    Rango3(3,"dfewfd"),
    Rango4(4,"dfewfd");

    private static Map<Integer, RangoHorario> valueToTextMapping;

    private final int rango;
    private final String descripcion;

    RangoHorario(int rango, String descripcion){
        this.rango = rango;
        this.descripcion = descripcion;
    }

    public int getRango() {
        return rango;
    }

    public String getDescripcion() {
        return descripcion;
    }
    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(RangoHorario s : values()){
            valueToTextMapping.put(s.getRango(), s);
        }
    }
    public static RangoHorario getStatus(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }
}
