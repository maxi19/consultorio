package com.consultorio.app.service.imp;

import com.consultorio.app.service.SucursalesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SucursalesServiceImp implements SucursalesService {

    @Value("${sucursalGrandBourg}")
    private String SucursalGg;

    @Value("${sucursalNogues}")
    private String SucursalNog;


    @Override
    public void obntenerParametrosSucursales(int idSucursal) {






    }
}
