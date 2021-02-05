package com.dbm.hibernate.util;
/*package com.dbm.hibernate.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.dbm.persistencia.Equipo;
import com.dbm.persistencia.HistoryAnalogic;
import com.dbm.persistencia.HistoryDigital;
import com.dbm.persistencia.EquiposAtributos;
import com.dbm.persistencia.Atributo;


// CONFIGURACIÓN DE SESSIÓNFACTORY


public class HibernateUtil {	
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory ==null) {
			try {
				Configuration configuration = new Configuration();
			
				//Equivalencia al hibernate.cfg.xml
				Properties settings=new Properties();
				settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				settings.put(Environment.URL, "jdbc:sqlserver://XXX.XX.X.XXX:XXXX;databaseName=XXXXX");
				settings.put(Environment.USER, "XXXXXXX");
				settings.put(Environment.PASS, "XXXXXX");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");				
				settings.put(Environment.SHOW_SQL, "true");				
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				//Se añaden las clases que contienen las anotaciones a mapear
				configuration.addAnnotatedClass(HistoryAnalogic.class);
				configuration.addAnnotatedClass(HistoryDigital.class);
				configuration.addAnnotatedClass(Equipo.class);
				configuration.addAnnotatedClass(Atributo.class);
				configuration.addAnnotatedClass(EquiposAtributos.class);
				configuration.setProperties(settings);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySetting(AvailableSettings.TRANSACTION_COORDINATOR_STRATEGY, "jdbc" )
						.applySettings(configuration.getProperties())
						.build();
				 
				sessionFactory =configuration.buildSessionFactory(serviceRegistry);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return sessionFactory;
	}	
	
	
}*/