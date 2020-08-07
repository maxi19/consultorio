package com.consultorio.app.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.app.service.RangoService;
import com.consultorio.app.service.dto.RangoDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/externo")
public class ExternoResource {

	   private final Logger log = LoggerFactory.getLogger(RangoResource.class);

	    private static final String ENTITY_NAME = "rango";

	    @Value("${jhipster.clientApp.name}")
	    private String applicationName;

	    private final RangoService rangoService;

	    public ExternoResource(RangoService rangoService) {
	        this.rangoService = rangoService;
	    }
	    
	   @GetMapping("/listarRangos")
	    public List<RangoDTO> getAllRangos() {
	        log.debug("REST request to get all Rangos");
	        return rangoService.findAll();
	    }

	    /**
	     * {@code GET  /rangos/:id} : get the "id" rango.
	     *
	     * @param id the id of the rangoDTO to retrieve.
	     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rangoDTO, or with status {@code 404 (Not Found)}.
	     */
	    @GetMapping("/rangos/{id}")
	    public ResponseEntity<RangoDTO> getRango(@PathVariable Long id) {
	        log.debug("REST request to get Rango : {}", id);
	        Optional<RangoDTO> rangoDTO = rangoService.findOne(id);
	        return ResponseUtil.wrapOrNotFound(rangoDTO);
	    }

	    /**
	     * {@code DELETE  /rangos/:id} : delete the "id" rango.
	     *
	     * @param id the id of the rangoDTO to delete.
	     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	     */
	    @DeleteMapping("/rangos/{id}")
	    public ResponseEntity<Void> deleteRango(@PathVariable Long id) {
	        log.debug("REST request to delete Rango : {}", id);
	        rangoService.delete(id);
	        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
	    }
	
	
}
