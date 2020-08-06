package com.consultorio.app.web.rest;

import com.consultorio.app.ConsultorioApp;
import com.consultorio.app.domain.Rango;
import com.consultorio.app.repository.RangoRepository;
import com.consultorio.app.service.RangoService;
import com.consultorio.app.service.dto.RangoDTO;
import com.consultorio.app.service.mapper.RangoMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link RangoResource} REST controller.
 */
@SpringBootTest(classes = ConsultorioApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class RangoResourceIT {

    @Autowired
    private RangoRepository rangoRepository;

    @Autowired
    private RangoMapper rangoMapper;

    @Autowired
    private RangoService rangoService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restRangoMockMvc;

    private Rango rango;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Rango createEntity(EntityManager em) {
        Rango rango = new Rango();
        return rango;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Rango createUpdatedEntity(EntityManager em) {
        Rango rango = new Rango();
        return rango;
    }

    @BeforeEach
    public void initTest() {
        rango = createEntity(em);
    }

    @Test
    @Transactional
    public void createRango() throws Exception {
        int databaseSizeBeforeCreate = rangoRepository.findAll().size();
        // Create the Rango
        RangoDTO rangoDTO = rangoMapper.toDto(rango);
        restRangoMockMvc.perform(post("/api/rangos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(rangoDTO)))
            .andExpect(status().isCreated());

        // Validate the Rango in the database
        List<Rango> rangoList = rangoRepository.findAll();
        assertThat(rangoList).hasSize(databaseSizeBeforeCreate + 1);
        Rango testRango = rangoList.get(rangoList.size() - 1);
    }

    @Test
    @Transactional
    public void createRangoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rangoRepository.findAll().size();

        // Create the Rango with an existing ID
        rango.setId(1L);
        RangoDTO rangoDTO = rangoMapper.toDto(rango);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRangoMockMvc.perform(post("/api/rangos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(rangoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Rango in the database
        List<Rango> rangoList = rangoRepository.findAll();
        assertThat(rangoList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllRangos() throws Exception {
        // Initialize the database
        rangoRepository.saveAndFlush(rango);

        // Get all the rangoList
        restRangoMockMvc.perform(get("/api/rangos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rango.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getRango() throws Exception {
        // Initialize the database
        rangoRepository.saveAndFlush(rango);

        // Get the rango
        restRangoMockMvc.perform(get("/api/rangos/{id}", rango.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(rango.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingRango() throws Exception {
        // Get the rango
        restRangoMockMvc.perform(get("/api/rangos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRango() throws Exception {
        // Initialize the database
        rangoRepository.saveAndFlush(rango);

        int databaseSizeBeforeUpdate = rangoRepository.findAll().size();

        // Update the rango
        Rango updatedRango = rangoRepository.findById(rango.getId()).get();
        // Disconnect from session so that the updates on updatedRango are not directly saved in db
        em.detach(updatedRango);
        RangoDTO rangoDTO = rangoMapper.toDto(updatedRango);

        restRangoMockMvc.perform(put("/api/rangos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(rangoDTO)))
            .andExpect(status().isOk());

        // Validate the Rango in the database
        List<Rango> rangoList = rangoRepository.findAll();
        assertThat(rangoList).hasSize(databaseSizeBeforeUpdate);
        Rango testRango = rangoList.get(rangoList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingRango() throws Exception {
        int databaseSizeBeforeUpdate = rangoRepository.findAll().size();

        // Create the Rango
        RangoDTO rangoDTO = rangoMapper.toDto(rango);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRangoMockMvc.perform(put("/api/rangos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(rangoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Rango in the database
        List<Rango> rangoList = rangoRepository.findAll();
        assertThat(rangoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRango() throws Exception {
        // Initialize the database
        rangoRepository.saveAndFlush(rango);

        int databaseSizeBeforeDelete = rangoRepository.findAll().size();

        // Delete the rango
        restRangoMockMvc.perform(delete("/api/rangos/{id}", rango.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Rango> rangoList = rangoRepository.findAll();
        assertThat(rangoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
