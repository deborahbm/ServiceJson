package com.dbm.objetos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dbm.log4j.Traza_Log;
import com.dbm.persistencia.EquiposAtributos;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public class Diccionario {

	public Map<String, List<TagDictionary>> diccionario;

	public Diccionario() {

	}

	public Map<String, List<TagDictionary>> getDiccionario() {
		return diccionario;
	}

	public void generarDiccionario(List<EquiposAtributos> rs) {	
		
		try {
			
			if (rs !=null) {
				
				Traza_Log.registro(" ##### Resultados consulta vista equipos_atributos:"  + rs.toString() + "  ######",Traza_Log.LOG_DEBUG);
				Traza_Log.registro(" ##### Se va a proceder a generar el diccionario #####",Traza_Log.LOG_INFO);
	
				Map<String, List<TagDictionary>> dicc = new HashMap<String, List<TagDictionary>>();			
	
				// Recorremos los EquiposAtributos para organizar por ip los attrname y tagname
	
				for (EquiposAtributos item : rs) {
					if (!dicc.containsKey(item.getIp())) {
						dicc.put(item.getIp(), new ArrayList<TagDictionary>());
					}
					dicc.get(item.getIp()).add(new TagDictionary(item.getId(),item.getTagname(),item.getEscalado(),item.isEsEscalado(),item.isAgregado(),item.getTiempoAgregado()));					
				}
	
				Traza_Log.registro(" ##### Diccionario generado ######",Traza_Log.LOG_INFO);
				Traza_Log.registro(" ##### Contenido diccionario:"  + dicc.toString() + "  ######",Traza_Log.LOG_DEBUG);
				setDiccionario(dicc);
				
			}else {
				Traza_Log.registro("objeto.null",Traza_Log.LOG_ERROR,new String[]{"vista equipos_atribtos"});	
			}

		} catch (Exception e) {
			Traza_Log.registro("try.catch.exception",Traza_Log.LOG_ERROR,new String[]{"diccionario",e.getMessage()});
			setDiccionario(null);
		}
		
	}

	public void setDiccionario(Map<String, List<TagDictionary>> dicc) {

		this.diccionario = dicc;

	}

}
