package com.dbm.hibernate.modelo;


import com.dbm.objetos.Diccionario;
import com.dbm.objetos.Respuesta;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public interface IGestion_Equipos {

	public  abstract Diccionario crearDiccionario();
	
	public  abstract Respuesta crearRespuesta();


}