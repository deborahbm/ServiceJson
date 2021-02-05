package com.dbm.hibernate.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbm.hibernate.repositorio.IHistoryDigital;
import com.dbm.log4j.Traza_Log;
import com.dbm.persistencia.HistoryDigital;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


@Repository
public class HistoryDigitalDAO {
	@Autowired
	private IHistoryDigital historyDigital_repo;

	//Métodos CRUD Hibernate
	
	@Transactional
	public boolean cargarResultados(List<HistoryDigital> resultados) {
		try  {
			
			if (resultados != null) {
					
				historyDigital_repo.saveAll(resultados);				
				return true;
				
			}else {
				
				Traza_Log.registro("objeto.null",Traza_Log.LOG_ERROR,new String[]{"lista HistoryAnalogic"});
				return false;
			}


		} catch (Exception e) {
			Traza_Log.registro("try.catch.exception",Traza_Log.LOG_ERROR,new String[]{"cargarResultados digital",e.getMessage()});
			return false;
		}
	}

}
