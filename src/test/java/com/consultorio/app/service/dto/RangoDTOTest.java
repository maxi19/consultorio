package com.consultorio.app.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.consultorio.app.web.rest.TestUtil;

public class RangoDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RangoDTO.class);
        RangoDTO rangoDTO1 = new RangoDTO();
        rangoDTO1.setId(1L);
        RangoDTO rangoDTO2 = new RangoDTO();
        assertThat(rangoDTO1).isNotEqualTo(rangoDTO2);
        rangoDTO2.setId(rangoDTO1.getId());
        assertThat(rangoDTO1).isEqualTo(rangoDTO2);
        rangoDTO2.setId(2L);
        assertThat(rangoDTO1).isNotEqualTo(rangoDTO2);
        rangoDTO1.setId(null);
        assertThat(rangoDTO1).isNotEqualTo(rangoDTO2);
    }
}
