package com.consultorio.app.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.consultorio.app.web.rest.TestUtil;

public class RangoTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Rango.class);
        Rango rango1 = new Rango();
        rango1.setId(1L);
        Rango rango2 = new Rango();
        rango2.setId(rango1.getId());
        assertThat(rango1).isEqualTo(rango2);
        rango2.setId(2L);
        assertThat(rango1).isNotEqualTo(rango2);
        rango1.setId(null);
        assertThat(rango1).isNotEqualTo(rango2);
    }
}
