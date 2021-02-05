package com.dbm.hibernate.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbm.hibernate.controlador.Controlador;
import com.dbm.hibernate.dao.HistoryAnalogicDAO;
import com.dbm.log4j.Traza_Log;
import com.dbm.objetos.DatoAnalogic;
import com.dbm.objetos.Diccionario;
import com.dbm.objetos.JSHistoryAnalogic;
import com.dbm.objetos.TagDictionary;
import com.dbm.persistencia.HistoryAnalogic;
import com.dbm.util.Conversiones;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */



@Service
public class Gestion_HistoryAnalogic implements IGestion_HistoryAnalogic {


	@Autowired
	private HistoryAnalogicDAO historyAnalogic_dao;
	

	//Métodos propios
	
	@Override
	@Transactional
	public boolean cargarHistorico(JSHistoryAnalogic objeto,Diccionario diccionario) {
		
		try  {
			
			if (diccionario != null) {
			
				List<TagDictionary> tagNames = diccionario.getDiccionario().get(objeto.getIp());	
				List<HistoryAnalogic> resultados = new ArrayList<HistoryAnalogic>();
				Timestamp fecha = Conversiones.toTimestamp(objeto.getFecha());
			
			for (DatoAnalogic o : objeto.getDatos()) {
				
				HistoryAnalogic resultado = new HistoryAnalogic();
				resultado.setFecha(fecha);
				resultado.setValor(Conversiones.toFloat(o.getValor()));
				resultado.setTagName(tagNames.stream().filter(x -> Conversiones.toInt(o.getId())==x.getId()).map(TagDictionary::getTagname)
						.findAny().orElse(""));
								
				if (resultado.getFecha()== null || resultado.getValor() == null || resultado.getTagName() == ("")) {
					
					Traza_Log.registro("sql.conversion.null",Traza_Log.LOG_ERROR, new String[]{resultado.toString()});
				}
				else {		
					resultados.add(resultado);	
				}
			
			}
			
				// Creando respuesta para tridium
				Controlador.respuesta.setFecha(Conversiones.parseFecha(new Date()));				
				Controlador.respuesta.modificar(objeto.getIp(),objeto.getFecha(),"Analogic ,datos recibidos: " + objeto.getDatos().size() + " datos a escribir: " + resultados.size(),true);
				
				// Guardar en base de datos
				historyAnalogic_dao.cargarResultados(resultados);	
				
			}else {
				
				Traza_Log.registro("objeto.null",Traza_Log.LOG_ERROR,new String[]{"diccionario"});
				
				// Creando respuesta para tridium
				Controlador.respuesta.setFecha(Conversiones.parseFecha(new Date()));				
				Controlador.respuesta.modificar(objeto.getIp(),objeto.getFecha(),"Diccionario no generado, recibido un null",false);
				
				return false;
			}			
			
			return true;
		} catch (Exception e) {
			
			Traza_Log.registro("try.catch.exception",Traza_Log.LOG_ERROR,new String[]{"cargaHistorico analógico",e.getMessage()});
			
			// Creando respuesta para tridium
			Controlador.respuesta.setFecha(Conversiones.parseFecha(new Date()));				
			Controlador.respuesta.modificar(objeto.getIp(),objeto.getFecha(),"Fallo en cargar histórico analógico",false);
			
			return false;
		}
	}

	
}
