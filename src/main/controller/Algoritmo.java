package main.controller;

import java.util.ArrayList;
import java.util.Collections;

import main.model.Oferta;
import main.util.Comparador;

public class Algoritmo 
{
	public static ArrayList<Oferta> goloso(ArrayList<Oferta> ofertas)
	{
		ArrayList<Oferta> ofertasClon = clonar(ofertas);
		ArrayList<Oferta> mejoresOfertas = new ArrayList<Oferta>();
		Collections.sort(ofertasClon, Comparador.porBeneficioMayorAMenor());
		for(Oferta oferta : ofertasClon)
			if(!superPone(oferta,mejoresOfertas))
				mejoresOfertas.add(oferta);
		
		return mejoresOfertas;
		
	}
	
	private static boolean superPone(Oferta ofertaUno, ArrayList<Oferta> ofertas)
	{
		for(Oferta ofertaDos : ofertas)
			if(Comparador.horariosSePisan(ofertaUno, ofertaDos)) return true;
		
		return false;
	}
	
	private static ArrayList<Oferta> clonar(ArrayList<Oferta> ofertas)
	{
		ArrayList<Oferta> clon = new ArrayList<Oferta>();
		for(Oferta o : ofertas)
		{
			clon.add(o);
		}
		return clon;
	}

}
