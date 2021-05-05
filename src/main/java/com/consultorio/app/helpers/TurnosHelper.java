package com.consultorio.app.helpers;

import java.util.Calendar;

public final class TurnosHelper {

    public static final String generarCodigo(String documento , int codigoSucursal){

        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String strAño= String.valueOf(año);
        String strMes = String.valueOf(mes);
        String strDia = String.valueOf(dia);

        documento = documento.substring(documento.length()-4,documento.length());

        String strFecha = strDia.concat(strMes).concat(strAño);

        String codigo = SucursalesEnum.obtenerSucursal(codigoSucursal).getCodigo();

        return codigo.concat("-").concat(strFecha).concat("-").concat(documento);
    }




}
