package com.dbm.hibernate.modelo;


import com.dbm.objetos.Diccionario;
import com.dbm.objetos.JSHistoryAnalogic;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public interface IGestion_HistoryAnalogic {
	
	public abstract boolean cargarHistorico(JSHistoryAnalogic objeto,Diccionario diccionario);

}