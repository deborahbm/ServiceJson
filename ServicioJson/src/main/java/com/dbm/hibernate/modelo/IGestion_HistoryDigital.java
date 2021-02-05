package com.dbm.hibernate.modelo;

import com.dbm.objetos.Diccionario;
import com.dbm.objetos.JSHistoryDigital;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public interface IGestion_HistoryDigital {

	public abstract boolean cargarHistorico (JSHistoryDigital objeto, Diccionario diccionario);
}
