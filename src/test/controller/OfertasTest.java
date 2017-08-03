package test.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import main.model.Oferta;
import main.controller.Ofertas;

public class OfertasTest {
	private LocalDate d = LocalDate.now();
	
	private Ofertas instancia()
	{
		Ofertas o = new Ofertas();
		o.agregar(new Oferta(d,8, 11, 800, "GZ", "1158882866", "2 MICS y Teclado"));
		o.agregar(new Oferta(d,12, 15, 700, "Pedro", null, null));
		o.agregar(new Oferta(d,11, 16, 500, "Marta", null, null));
		o.agregar(new Oferta(d,17, 21, 700, "Lucas", null, null));
		o.agregar(new Oferta(d,7, 11, 700, "Maxi", null, null));

		return o;
	}

	@Test
	public void agregarOfertaTest()
	{
		Ofertas o = instancia();

		assertTrue(o.contains(new Oferta(d,17, 21, 700, "Lucas", null, null)));
		assertTrue(o.contains(new Oferta(d,7, 11, 700, "Maxi", null, null)));

		o.agregar(new Oferta(d,15, 17, 207, "Solana", null, null));
		o.agregar(new Oferta(d,15, 17, 1000, "SI no te rindes", null, null));

		assertTrue(o.contains(new Oferta(d,15, 17, 207, "Solana", null, null)));
		assertTrue(o.contains(new Oferta(d,15, 17, 1000, "SI no te rindes", null,null)) );
	}
	
	@Test
	public void removerOfertaTest()
	{
		Ofertas o = instancia();
		
		assertTrue(o.contains(new Oferta(d,17, 21, 700, "Lucas", null, null)));
		o.remover(new Oferta(d,17, 21, 700, "Lucas", null, null));
		assertFalse(o.contains(new Oferta(d,17, 21, 700, "Lucas", null, null)));

		assertTrue(o.contains(new Oferta(d,7, 11, 700, "Maxi", null, null)));
		o.remover(new Oferta(d,7, 11, 700, "Maxi", null, null));
		assertFalse(o.contains(new Oferta(d,7, 11, 700, "Maxi", null,null)));
	}

}
