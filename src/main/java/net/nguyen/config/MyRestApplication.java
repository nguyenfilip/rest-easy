package net.nguyen.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.core.Dispatcher;

@ApplicationPath("/app")
public class MyRestApplication extends Application {

	public MyRestApplication(@Context Dispatcher dispatcher){
		dispatcher.getDefaultContextObjects().put(EntityManagerFactory.class, 
				Persistence.createEntityManagerFactory("default"));
	}
	
}
			