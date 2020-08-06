package com.consultorio.app.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.consultorio.app.domain.Rango} entity.
 */
public class RangoDTO implements Serializable {
    
    private Long id;

    private String value;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RangoDTO)) {
            return false;
        }

        return id != null && id.equals(((RangoDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RangoDTO{" +
            "id=" + getId() +
            "}";
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
