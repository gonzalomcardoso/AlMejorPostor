package main.model;

import java.time.LocalDate;

public class Oferta 
{
	private LocalDate _fecha;
	private int _inicio;
	private int _fin;
	private int _precio;
	private String _banda;
	private String _telefono;
	private String _facilidades;
	
	public Oferta(LocalDate fecha, int inicio, int fin, int precio, String banda, String telefono, String facilidades)
	{
		_fecha = fecha;
		_inicio = inicio;
		_fin = fin;
		_precio = precio;
		_banda = banda;
		_telefono = telefono;
		_facilidades = facilidades;
	}

	public LocalDate get_fecha() {
		return _fecha;
	}

	public int get_inicio() {
		return _inicio;
	}

	public int get_fin() {
		return _fin;
	}

	public int get_precio() {
		return _precio;
	}

	public String get_banda() {
		return _banda;
	}

	public String get_telefono() {
		return _telefono;
	}

	public String get_facilidades() {
		return _facilidades;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		if (_banda == null) {
			if (other._banda != null)
				return false;
		} else if (!_banda.equals(other._banda))
			return false;
		if (_facilidades == null) {
			if (other._facilidades != null)
				return false;
		} else if (!_facilidades.equals(other._facilidades))
			return false;
		if (_fecha == null) {
			if (other._fecha != null)
				return false;
		} else if (!_fecha.equals(other._fecha))
			return false;
		if (_fin != other._fin)
			return false;
		if (_inicio != other._inicio)
			return false;
		if (_precio != other._precio)
			return false;
		if (_telefono == null) {
			if (other._telefono != null)
				return false;
		} else if (!_telefono.equals(other._telefono))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_banda == null) ? 0 : _banda.hashCode());
		result = prime * result + ((_facilidades == null) ? 0 : _facilidades.hashCode());
		result = prime * result + ((_fecha == null) ? 0 : _fecha.hashCode());
		result = prime * result + _fin;
		result = prime * result + _inicio;
		result = prime * result + _precio;
		result = prime * result + ((_telefono == null) ? 0 : _telefono.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Oferta [_fecha=" + _fecha + ", _inicio=" + _inicio + ", _fin=" + _fin + ", _precio=" + _precio
				+ ", _banda=" + _banda + ", _telefono=" + _telefono + ", _facilidades=" + _facilidades + "]";
	}
	
	
}