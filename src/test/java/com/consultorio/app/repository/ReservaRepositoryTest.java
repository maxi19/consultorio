package com.consultorio.app.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.consultorio.app.ConsultorioApp;
import com.consultorio.app.domain.Reserva;

@SpringBootTest(classes = ConsultorioApp.class)
@Transactional
public class ReservaRepositoryTest {

	@Autowired
	ReservaRepository reservaRepository;


	@Test
	public void dadoUnaReservaSePersiste() {
		Reserva reserva = new Reserva();
		reserva.setApellido("guzman");
		reserva.setNombre("maxi");
		reservaRepository.save(reserva);

	}




}
