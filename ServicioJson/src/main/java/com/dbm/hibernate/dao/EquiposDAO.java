package com.dbm.hibernate.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbm.hibernate.dao.EquiposDAO;
import com.dbm.hibernate.repositorio.IEquiposAtributos;
import com.dbm.persistencia.EquiposAtributos;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */



@Repository
public class EquiposDAO {

	@Autowired
	private IEquiposAtributos equiposAtributos;

	// Métodos CRUD Hibernate

	@Transactional
	public List<EquiposAtributos> buscarTodo() {		
		
		return equiposAtributos.findAll();
		
	}
}
