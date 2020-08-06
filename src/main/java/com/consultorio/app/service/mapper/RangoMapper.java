package com.consultorio.app.service.mapper;


import com.consultorio.app.domain.*;
import com.consultorio.app.service.dto.RangoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Rango} and its DTO {@link RangoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RangoMapper extends EntityMapper<RangoDTO, Rango> {



    default Rango fromId(Long id) {
        if (id == null) {
            return null;
        }
        Rango rango = new Rango();
        rango.setId(id);
        return rango;
    }
}
