package main.service;

import java.util.ArrayList;

import main.dataAccess.DataAccessJSON;
import main.model.Oferta;

public class OfertaService 
{
	private static String ofertasRecibidas = "ofertasRecibidas.json";
	
	public static void guardarOfertasRecibidas(ArrayList<Oferta> ofertas)
	{
		DataAccessJSON.writeJSON(ofertasRecibidas, ofertas);
	}
	
	public static ArrayList<Oferta> getOfertasRecibidas()
	{
		ArrayList<Oferta> ofertas;
		ofertas = DataAccessJSON.readJSON(ofertasRecibidas);
		
		if (ofertas == null)
			ofertas = new ArrayList<Oferta>();
		
		return ofertas;
	}
	
	public static ArrayList<Oferta> getOfertasRecibidas(String fecha)
	{
		ArrayList<Oferta> ofertas;
		ofertas = DataAccessJSON.readJSON(ofertasRecibidas);
		
		if (ofertas == null)
			ofertas = new ArrayList<Oferta>();

		ArrayList<Oferta> ret = new ArrayList<Oferta>();
		for(Oferta of: ofertas)
			if (of.get_fecha().toString().equals(fecha))
				ret.add(of);
		
		return ret;
	}
}
