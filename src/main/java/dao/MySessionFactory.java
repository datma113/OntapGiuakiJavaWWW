package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MySessionFactory {
	
	public static MySessionFactory instance = null;
	private SessionFactory factory;
	
	
	
	public MySessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		Metadata meta = new MetadataSources(registry)
				.addAnnotatedClass(entity.CreditCard.class)
				.addAnnotatedClass(entity.Person.class)
				.getMetadataBuilder()
				.build();
		
		factory = meta.getSessionFactoryBuilder()
				.build();
	}
	public synchronized static MySessionFactory getInstance() {
		if(instance == null) {
			instance = new MySessionFactory();
		}
		return instance;
	}
	public SessionFactory getFactory() {
		return factory;
	}
	
	
}
