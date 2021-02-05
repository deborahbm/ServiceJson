package com.dbm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 
 * @author Déborah Blas Muñoz.
 * @since 10/12/2020.
 *
 */


@SpringBootApplication
public class ServicioJsonApplication {

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication (ServicioJsonApplication.class);	
		sa.run(args);
	}
}
