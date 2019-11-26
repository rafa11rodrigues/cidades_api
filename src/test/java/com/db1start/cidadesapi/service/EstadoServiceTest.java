package com.db1start.cidadesapi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTest {

	
	@Autowired
	private EstadoService estadoService;
	
	
	//@After
	public void clean() {
		estadoService.limpar();
	}
	
	//@Test
	public void test() {
		Estado estado = estadoService.criar("Paraná");
		
		assertNotNull(estado);
		System.out.println(estado.getId());
	}

	@Test
	public void deveBuscarEstado() {
		Estado estado = estadoService.buscarPorNome("Paraná");
		assertNotNull(estado);
	}
	
	@Test
	public void deveLancarExcecao() {
		try {
			Estado estado = estadoService.buscarPorNome("São Paulo");	
		}
		catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
