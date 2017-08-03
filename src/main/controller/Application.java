package main.controller;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import main.model.Oferta;
import main.service.OfertaService;
import main.util.Comparador;

public class Application 
{
	public static void agregarOferta(Oferta of)
	{
		ArrayList<Oferta> ofertas = OfertaService.getOfertasRecibidas();
		ofertas.add(of);
		Collections.sort(ofertas, Comparador.porHorario());
		OfertaService.guardarOfertasRecibidas(ofertas);
	}
	
	public static DefaultTableModel mostrarTablaOfertas()
	{
		DefaultTableModel dtm = new DefaultTableModel();
		Object columnNames[] = { "Fecha", "Horario", "Precio", "Banda", "Facilidades", "Telefono" };
		
		for (Object columna : columnNames)
			dtm.addColumn(columna);
		
		ArrayList<Oferta> ofertas = OfertaService.getOfertasRecibidas();
		
		for (Oferta o : ofertas) {
			String datos[] = new String[6];
			datos[0] = o.get_fecha().toString();
			datos[1] = o.get_inicio() + " a " + o.get_fin();
			datos[2] = String.valueOf(o.get_precio());
			datos[3] = o.get_banda();
			datos[4] = o.get_facilidades();
			datos[5] = o.get_telefono();

			dtm.addRow(datos);
		}
		
		return dtm;
	}
	
	public static DefaultTableModel mostrarTablaOfertas(String fecha)
	{
		DefaultTableModel dtm = new DefaultTableModel();
		Object columnNames[] = { "Fecha", "Horario", "Precio", "Banda", "Facilidades", "Telefono" };
		
		for (Object columna : columnNames)
			dtm.addColumn(columna);
		
		ArrayList<Oferta> ofertas = OfertaService.getOfertasRecibidas();
		
		for (Oferta o : ofertas) {
			String datos[] = new String[6];
			datos[0] = o.get_fecha().toString();
			datos[1] = o.get_inicio() + " a " + o.get_fin();
			datos[2] = String.valueOf(o.get_precio());
			datos[3] = o.get_banda();
			datos[4] = o.get_facilidades();
			datos[5] = o.get_telefono();

			dtm.addRow(datos);
		}
		
		return dtm;
	}
	
	public static DefaultTableModel mostrarTablaMejoresOfertas(String fecha)
	{
		DefaultTableModel dtm = new DefaultTableModel();
		Object columnNames[] = { "Fecha", "Horario", "Precio", "Banda", "Facilidades", "Telefono" };
		
		for (Object columna : columnNames)
			dtm.addColumn(columna);
		
		 ArrayList<Oferta> mejoresOfertas = getMejoresOfertas(OfertaService.getOfertasRecibidas(fecha));

		for (Oferta o : mejoresOfertas) {
			String datos[] = new String[6];
			datos[0] = o.get_fecha().toString();
			datos[1] = o.get_inicio() + " a " + o.get_fin();
			datos[2] = String.valueOf(o.get_precio());
			datos[3] = o.get_banda();
			datos[4] = o.get_facilidades();
			datos[5] = o.get_telefono();

			dtm.addRow(datos);
		}
		
		return dtm;
	}
	
	private static ArrayList<Oferta> getMejoresOfertas(ArrayList<Oferta> ofertas)
	{
		ArrayList<Oferta> mejoresOfertas = new ArrayList<Oferta>();
		mejoresOfertas = Algoritmo.goloso(ofertas);
		Collections.sort(mejoresOfertas,Comparador.porHorario());
		return mejoresOfertas;
	}
}
