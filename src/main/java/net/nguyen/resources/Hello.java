package net.nguyen.resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.nguyen.Person;
import net.nguyen.Test;
import net.nguyen.entity.Product;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Hello {
	
	@GET
	public String hello() {
		return "Hello, World!";
	}
	

	@GET
	@Path("/jpapersist")
	@Produces("Application/json")
	public Product jpa(@Context EntityManagerFactory emf) {
		Product p = new Product();
		p.setName("TEST PRODUCT");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	@GET
	@Path("/jpaget")
	@Produces("Application/json")
	public Product jpaget(@Context EntityManagerFactory emf) {
		Product p = null;
		EntityManager em = emf.createEntityManager();
		p = em.createQuery("SELECT p from Product p" , Product.class).getResultList().get(0);
		em.close();
		return p;
	}
	
	@GET
	@Path("/person")
	@Produces("Application/json")
	public Person constructPerson(@QueryParam("name") String name) {
		Person p  = new Person();
		p.setName(name);
		return p;
	}
	
	@GET
	@Path("/context")
	@Produces("Application/json")
	public String constructPerson(@Context Test test) {
		return test.hello();
	}
	

	@GET
	@Path("/servlet")
	@Produces("Application/json")
	public String constructPerson(@Context ServletContext se) {
		return se.getAttribute("test").toString();
	}
	
}
