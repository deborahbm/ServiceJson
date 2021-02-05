package com.dbm.hibernate.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbm.hibernate.repositorio.IHistoryAnalogic;
import com.dbm.log4j.Traza_Log;
import com.dbm.persistencia.HistoryAnalogic;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */



@Repository
public class HistoryAnalogicDAO {
	
	@Autowired
	private IHistoryAnalogic historyAnalogic_repo;

	//Métodos CRUD Hibernate
	
	@Transactional
	public boolean cargarResultados(List<HistoryAnalogic> resultados) {
		try  {
			
			if (resultados != null) {
				
				historyAnalogic_repo.saveAll(resultados);					
				return true;
				
			}else {
				
				Traza_Log.registro("objeto.null",Traza_Log.LOG_ERROR,new String[]{"lista HistoryAnalogic"});
				return false;
			}


		} catch (Exception e) {
			Traza_Log.registro("try.catch.exception",Traza_Log.LOG_ERROR,new String[]{"cargarResultados analógico",e.getMessage()});
			return false;
		}
	}

}
