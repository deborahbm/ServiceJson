
package com.dbm.objetos;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public class Respuesta {	
	
	private String fecha;	
	private List<Mensaje> datos;	

	public Respuesta() {
		super();
	}

	public Respuesta(String fecha,List<Mensaje> data) {
		super();		
		this.fecha = fecha;		
		this.datos = data;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}	

	public List<Mensaje> getDatos() {
		return datos;
	}


	public void setDatos(List<Mensaje> datos) {
		this.datos = datos;
	}


	@Override
	public String toString() {
		return "Response [ fecha=" + fecha +  ", datos=" + datos + "]";
	}
	
	public void modificar(String ip,String fecha, String info, Boolean estado) {
		
		boolean find = false;
		ip = ip.replace(".", "_");
		
		if (getDatos() != null) {
		
				for (Mensaje m : getDatos()) {
					
					if (m.getIp().equals(ip)) {				
						
						m.setFecha(fecha);
						m.setInfo(info);
						m.setEstado(estado);
						find = true;
					}
				}
				
				if (!find) {
					List<Mensaje> dt = getDatos();
					dt.add(new Mensaje(ip,fecha,info,estado));
					setDatos(dt);
				}
				
		}else {
			
			List<Mensaje> dt = new ArrayList<Mensaje>();
			dt.add(new Mensaje(ip,fecha,info,estado));
			setDatos(dt);
		}		
		
	}

}


