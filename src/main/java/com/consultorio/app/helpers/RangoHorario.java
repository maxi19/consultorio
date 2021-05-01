package com.consultorio.app.helpers;

import java.util.HashMap;
import java.util.Map;

public enum RangoHorario {

    Rango1(1,"09 : 00 hs - 09 : 30 hs"),
    Rango2(2,"09 : 30 hs - 10 : 00 hs"),
    Rango3(3,"10 : 00 hs - 10 : 30 hs"),
    Rango4(4,"10 : 30 hs - 11 : 00 hs");

    private static Map<Integer, String> valueToTextMapping;

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
            valueToTextMapping.put(s.getRango(), s.getDescripcion());
        }
    }

    public static  Map<Integer, String> dameTodosLosRangos(){
        initMapping();
        return valueToTextMapping;
    }

    public static String dameRangoDescripcion(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }
}
