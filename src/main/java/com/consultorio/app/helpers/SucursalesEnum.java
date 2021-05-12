package com.consultorio.app.helpers;

public enum SucursalesEnum {

    TORTUGITAS01    ("1","TR01","Buenos Aires 2020","Gran Buenos Aires- Tortugitas","011-3045234","1515"),
    NOGUES01    ("2","NG01","Marcos Sastre 213","Gran Buenos Aires- Pablo Nogues","011-345632","1453");

    private String interno;

    private String codigo;

    private String direccion;

    private String localidad;

    private String telefono;

    private String cp;


    SucursalesEnum(String interno,String codigo, String direccion, String localidad, String telefono, String cp) {
        this.interno = interno;
        this.codigo = codigo;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.cp = cp;
    }

    public static SucursalesEnum obtenerSucursal(int sucursal){
        for(SucursalesEnum s : values()) {
            if (s.getInterno().equals(String.valueOf(sucursal))) {
                    return s;
            }
        }
        return null;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCp() {
        return cp;
    }

    public String getInterno() {
        return interno;
    }
}
