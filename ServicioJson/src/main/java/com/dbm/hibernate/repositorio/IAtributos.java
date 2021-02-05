package com.dbm.hibernate.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbm.persistencia.Atributo;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


@Repository
public interface IAtributos extends JpaRepository <Atributo, Integer>{			
	
}
