package com.dbm.objetos;


import java.util.Set;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public class JSHistoryAnalogic {

	
	private String ip;
	private String fecha;
	private Set<DatoAnalogic> datos;

	// Constructores
	public JSHistoryAnalogic() {
	}

	public JSHistoryAnalogic(String ip, String fecha, Set<DatoAnalogic> datos) {
		this.ip = ip;
		this.fecha = fecha;
		this.datos = datos;
	}

	// Accesores
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Set<DatoAnalogic> getDatos() {
		return datos;
	}

	public void setDatos(Set<DatoAnalogic> datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "JSHistoryAnalogic [ip=" + ip + ", fecha=" + fecha + ", datos=" + datos + "]";
	}

	

}
