package test.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import main.controller.Ofertas;
import main.model.Oferta;
import main.util.Comparador;

public class ComparadorTest {

	private Ofertas instancia1()
	{
		Ofertas o = new Ofertas();
		o.agregar(new Oferta(LocalDate.of(2016, 11, 19), 8, 11, 800, "GZ", "1158882866", "2 MICS y Teclado"));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 20), 10, 13, 700, "Pedro", null, null));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 10), 11, 16, 500, "Marta", null, null));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 11), 17, 21, 700, "Lucas", null, null));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 15), 7, 11, 700, "Maxi", null, null));

		return o;
	}

	private Ofertas instancia2()
	{
		Ofertas o = new Ofertas();
		o.agregar(new Oferta(LocalDate.of(2016, 11, 19), 8, 11, 800, "GZ", "1158882866", "2 MICS y Teclado"));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 19), 11, 13, 700, "Pedro", null, null));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 19), 11, 16, 500, "Marta", null, null));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 19), 15, 17, 700, "Lucas", null, null));
		o.agregar(new Oferta(LocalDate.of(2016, 11, 19), 7, 11, 700, "Maxi", null, null));

		return o;
	}

	@Test
	public void compareFechaTest()
	{
		Ofertas o = instancia1();

		assertTrue(Comparador.compareFecha(o.get(0).get_fecha(), o.get(0).get_fecha()) == 0);
		assertTrue(Comparador.compareFecha(o.get(0).get_fecha(), o.get(1).get_fecha()) == -1);
		assertTrue(Comparador.compareFecha(o.get(0).get_fecha(), o.get(2).get_fecha()) == 9);
		assertTrue(Comparador.compareFecha(o.get(0).get_fecha(), o.get(3).get_fecha()) == 8);
		assertTrue(Comparador.compareFecha(o.get(0).get_fecha(), o.get(4).get_fecha()) == 4);
		assertTrue(Comparador.compareFecha(o.get(1).get_fecha(), o.get(1).get_fecha()) == 0);
		assertTrue(Comparador.compareFecha(o.get(1).get_fecha(), o.get(2).get_fecha()) == 10);
		assertTrue(Comparador.compareFecha(o.get(1).get_fecha(), o.get(3).get_fecha()) == 9);
		assertTrue(Comparador.compareFecha(o.get(1).get_fecha(), o.get(4).get_fecha()) == 5);
		assertTrue(Comparador.compareFecha(o.get(2).get_fecha(), o.get(2).get_fecha()) == 0);
		assertTrue(Comparador.compareFecha(o.get(2).get_fecha(), o.get(3).get_fecha()) == -1);
		assertTrue(Comparador.compareFecha(o.get(2).get_fecha(), o.get(4).get_fecha()) == -5);
		assertTrue(Comparador.compareFecha(o.get(3).get_fecha(), o.get(3).get_fecha()) == 0);
		assertTrue(Comparador.compareFecha(o.get(3).get_fecha(), o.get(4).get_fecha()) == -4);
		assertTrue(Comparador.compareFecha(o.get(4).get_fecha(), o.get(4).get_fecha()) == 0);
	}

	@Test
	public void porFechaTest()
	{
		Ofertas o = instancia1();

		assertTrue(Comparador.porFecha().compare(o.get(0), o.get(0)) == 0);
		assertTrue(Comparador.porFecha().compare(o.get(0), o.get(1)) == -1);
		assertTrue(Comparador.porFecha().compare(o.get(0), o.get(2)) == 9);
		assertTrue(Comparador.porFecha().compare(o.get(0), o.get(3)) == 8);
		assertTrue(Comparador.porFecha().compare(o.get(0), o.get(4)) == 4);
		assertTrue(Comparador.porFecha().compare(o.get(1), o.get(1)) == 0);
		assertTrue(Comparador.porFecha().compare(o.get(1), o.get(2)) == 10);
		assertTrue(Comparador.porFecha().compare(o.get(1), o.get(3)) == 9);
		assertTrue(Comparador.porFecha().compare(o.get(1), o.get(4)) == 5);
		assertTrue(Comparador.porFecha().compare(o.get(2), o.get(2)) == 0);
		assertTrue(Comparador.porFecha().compare(o.get(2), o.get(3)) == -1);
		assertTrue(Comparador.porFecha().compare(o.get(2), o.get(4)) == -5);
		assertTrue(Comparador.porFecha().compare(o.get(3), o.get(3)) == 0);
		assertTrue(Comparador.porFecha().compare(o.get(3), o.get(4)) == -4);
		assertTrue(Comparador.porFecha().compare(o.get(4), o.get(4)) == 0);
	}

	@Test
	public void porHorarioTest()
	{
		Ofertas o = instancia2();

		assertTrue(Comparador.porHorario().compare(o.get(0), o.get(0)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(0), o.get(1)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(0), o.get(2)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(0), o.get(3)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(0), o.get(4)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(1), o.get(1)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(1), o.get(2)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(1), o.get(3)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(1), o.get(4)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(2), o.get(2)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(2), o.get(3)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(2), o.get(4)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(3), o.get(3)) == 1);
		assertTrue(Comparador.porHorario().compare(o.get(3), o.get(4)) == 0);
		assertTrue(Comparador.porHorario().compare(o.get(4), o.get(4)) == 1);
	}
	
	@Test
	public void porBeneficioTest()
	{
		Ofertas o = instancia2();

		assertTrue(Comparador.porBeneficioMayorAMenor().compare(o.get(0), o.get(0)) == 0);
		assertTrue(Comparador.porBeneficioMayorAMenor().compare(o.get(0), o.get(1)) == -1);
		assertTrue(Comparador.porBeneficioMayorAMenor().compare(o.get(0), o.get(4)) == 1);
		assertTrue(Comparador.porBeneficioMayorAMenor().compare(o.get(1), o.get(2)) == 1);
		assertTrue(Comparador.porBeneficioMayorAMenor().compare(o.get(2), o.get(3)) == -1);
	}

}
