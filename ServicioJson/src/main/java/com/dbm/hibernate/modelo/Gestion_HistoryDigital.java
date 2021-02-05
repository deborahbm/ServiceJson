package com.dbm.hibernate.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbm.hibernate.controlador.Controlador;
import com.dbm.hibernate.dao.HistoryDigitalDAO;
import com.dbm.log4j.Traza_Log;
import com.dbm.objetos.DatoDigital;
import com.dbm.objetos.Diccionario;
import com.dbm.objetos.JSHistoryDigital;
import com.dbm.objetos.TagDictionary;
import com.dbm.persistencia.HistoryDigital;
import com.dbm.util.Conversiones;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


@Service
public class Gestion_HistoryDigital implements IGestion_HistoryDigital{

	@Autowired
	private HistoryDigitalDAO historyDigital_dao;	

	//Métodos propios	
	@Override
	@Transactional
	public boolean cargarHistorico(JSHistoryDigital objeto,Diccionario diccionario) {
		
		try  {
			
			if (diccionario != null) {	
				
				List<TagDictionary> tagNames = diccionario.getDiccionario().get(objeto.getIp());	
				List<HistoryDigital> resultados = new ArrayList<HistoryDigital>();
			
			for (DatoDigital o : objeto.getDatos()) {
				
				HistoryDigital resultado = new HistoryDigital();
				resultado.setFecha(Conversiones.toTimestamp(o.getFecha()));
				resultado.setValor(Conversiones.toBoolean(o.getValor()));
				resultado.setTagName(tagNames.stream().filter(x -> Conversiones.toInt(o.getId())==x.getId()).map(TagDictionary::getTagname)
						.findAny().orElse(""));
								
				if (resultado.getFecha()== null || resultado.getValor() == null || resultado.getTagName() == ("")) {
					
					Traza_Log.registro("sql.conversion.null",Traza_Log.LOG_ERROR, new String[]{resultado.toString()});
				
				}else {		
		
					resultados.add(resultado);	
				}			
			}			
				// Creando respuesta para tridium
				Controlador.respuesta.setFecha(Conversiones.parseFecha(new Date()));	
				Controlador.respuesta.modificar(objeto.getIp(),objeto.getFecha(),"Digital ,datos recibidos: " + objeto.getDatos().size() + " datos a escribir: " + resultados.size(),true);			
				
				// Guardar en base de datos
				historyDigital_dao.cargarResultados(resultados);
							
			}else {
				
				Traza_Log.registro("objeto.null",Traza_Log.LOG_ERROR,new String[]{"diccionario"});
				
				// Creando respuesta para tridium
				Controlador.respuesta.setFecha(Conversiones.parseFecha(new Date()));				
				Controlador.respuesta.modificar(objeto.getIp(),objeto.getFecha(),"Diccionario no generado, recibido un null",false);
				
				return false;
			}		
			
			return true;
			
		} catch (Exception e) {
			
			Traza_Log.registro("try.catch.exception",Traza_Log.LOG_ERROR,new String[]{"cargaHistorico digital",e.getMessage()});
			
			// Creando respuesta para tridium
			Controlador.respuesta.setFecha(Conversiones.parseFecha(new Date()));				
			Controlador.respuesta.modificar(objeto.getIp(),objeto.getFecha(),"Fallo en cargar histórico digital",false);
			
			return false;
		}
	}	
	
}
