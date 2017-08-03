package main.controller;

import java.util.ArrayList;
import java.util.Iterator;

import main.model.Oferta;

public class Ofertas implements Iterable<Oferta> {
	private ArrayList<Oferta> _ofertas;
	
	public Ofertas()
	{
		_ofertas = new ArrayList<Oferta>();
	}

	public void agregar(Oferta o)
	{
		_ofertas.add(o);
	}
	
	public void remover(Oferta o)
	{
		_ofertas.remove(o);
	}
	
	public int size()
	{
		return _ofertas.size();
	}
	
	public boolean contains(Oferta o)
	{
		for (Oferta of : _ofertas)
			if (of.equals(o))
				return true;
		
		return false;
	}
	
	public Oferta get(int index)
	{
		return _ofertas.get(index);
	}
	
	public ArrayList<Oferta> getOfertas()
	{
		return _ofertas;
	}
	
	@Override
	public Iterator<Oferta> iterator()
	{
		return _ofertas.iterator();
	}
	
	@Override
	public String toString()
	{
		String ret = "";
		for (Oferta o : _ofertas){
			ret += o;
			ret += "\n";
		}
		return ret;
	}

}
