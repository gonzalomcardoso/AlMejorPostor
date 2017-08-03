package test.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import main.controller.Algoritmo;
import main.model.Oferta;

public class AlgoritmoTest {

	@Test
	public void GolosoTest() {
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		ofertas.add(new Oferta(LocalDate.of(2016, 11, 19), 8, 11, 800, "GZ", "1158882866", "2 MICS y Teclado"));
		ofertas.add(new Oferta(LocalDate.of(2016, 11, 19), 12, 15, 700, "Pedro", null, null));
		ofertas.add(new Oferta(LocalDate.of(2016, 11, 19), 11, 16, 500, "Marta", null, null));
		ofertas.add(new Oferta(LocalDate.of(2016, 11, 19), 17, 21, 700, "Lucas", null, null));
		ofertas.add(new Oferta(LocalDate.of(2016, 11, 19),7, 11, 100, "Maxi", null, null));
		
		ArrayList<Oferta> ofertasGoloseadas = Algoritmo.goloso(ofertas);
		
//		System.out.println(ofertasGoloseadas.get(0).get_banda().toString());
//		System.out.println(ofertasGoloseadas.get(1).get_banda().toString());
//		System.out.println(ofertasGoloseadas.get(2).get_banda().toString());
//		System.out.println(ofertasGoloseadas.get(3).get_banda().toString());
//		System.out.println(ofertasGoloseadas.get(4).get_banda().toString());
		
		assertEquals(ofertas.get(0), ofertasGoloseadas.get(0));
		assertEquals(ofertas.get(1), ofertasGoloseadas.get(1));
		assertEquals(new Oferta(LocalDate.of(2016, 11, 19), 17, 21, 700, "Lucas", null, null), ofertasGoloseadas.get(2));
//		assertEquals(ofertas.get(3), ofertasGoloseadas.get(2));
	}

}
