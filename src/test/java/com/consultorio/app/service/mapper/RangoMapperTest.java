package com.consultorio.app.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RangoMapperTest {

    private RangoMapper rangoMapper;

    @BeforeEach
    public void setUp() {
        rangoMapper = new RangoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(rangoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(rangoMapper.fromId(null)).isNull();
    }
}
