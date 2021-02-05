package com.dbm.hibernate.controlador;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbm.hibernate.modelo.Gestion_Equipos;
import com.dbm.hibernate.modelo.Gestion_HistoryAnalogic;
import com.dbm.hibernate.modelo.Gestion_HistoryDigital;
import com.dbm.objetos.Diccionario;
import com.dbm.objetos.JSHistoryAnalogic;
import com.dbm.objetos.JSHistoryDigital;
import com.dbm.objetos.Respuesta;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


@RestController
@RequestMapping("/historico/v0/")
public class Controlador{	
	
	//Instancia para uso de la clase Diccionario
	private static Diccionario diccionario;
	public static Respuesta respuesta;

	//Inyección beans
	@Autowired
	private Gestion_HistoryAnalogic gestion_historyAnalogic;
	@Autowired
	private Gestion_HistoryDigital gestion_historyDigital;
	@Autowired
	private Gestion_Equipos gestion_Equipos;
	
	
	//Consulta Json para datos Analógicos
	
	@GetMapping("/historyAnalogic/")
	public ResponseEntity<Boolean> datosHistoricos(@Valid @RequestBody JSHistoryAnalogic JSHistoryAnalogic) {

		if (diccionario == null) {
			diccionario = gestion_Equipos.crearDiccionario();
			respuesta = gestion_Equipos.crearRespuesta();
		}
		Boolean res = gestion_historyAnalogic.cargarHistorico(JSHistoryAnalogic,diccionario);
		//System.gc();	
        return ResponseEntity.ok().body(res);
    }

	
	// Consulta Json para datos Digitales
	
	@GetMapping("/historyDigital/")
	public ResponseEntity<Boolean> datosHistoricos(@Valid @RequestBody JSHistoryDigital JSHistoryDigital) {

		if (diccionario == null) {
			diccionario = gestion_Equipos.crearDiccionario();
			respuesta = gestion_Equipos.crearRespuesta();
		}			
		Boolean res = gestion_historyDigital.cargarHistorico(JSHistoryDigital,diccionario);	
		//System.gc();
        return ResponseEntity.ok().body(res);
    }
	
	//Respuesta para Tridium	
		@GetMapping("/tridium/")
	    public ResponseEntity<Respuesta> respuesta() {			
						
	        return ResponseEntity.ok().body(respuesta);
	        
	    }	

}
