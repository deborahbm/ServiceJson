package com.dbm.hibernate.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbm.persistencia.HistoryDigital;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


public interface IHistoryDigital extends JpaRepository <HistoryDigital, Long>{

}
