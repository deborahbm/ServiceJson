package com.dbm.objetos;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public class DatoAnalogic {

	private String valor;
	private String id;

	// Constructores
	public DatoAnalogic() {
	
	}

	public DatoAnalogic(String valor, String id) {
		this.valor = valor;
		this.id = id;
	}


	//Accesores
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "Dato [valor=" + valor + ", identificador=" + id + "]";
	}

	

}
