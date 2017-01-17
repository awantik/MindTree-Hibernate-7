package Day3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestIdClass {
	public SessionFactory factory;
	
	 public void setup(){
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
			srBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
	 }

	public static void main(String[] args) {
		TestIdClass tc = new TestIdClass();
		tc.setup();
		
		Session session = tc.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		IdClassBook ibook = new IdClassBook();
		
		//Primary Key
		ibook.setCheckdigit(121212);
		ibook.setGroup(5);
		ibook.setPublisher(10);
		ibook.setTitle(33);
		
		ibook.setName("Java");
		
		session.save(ibook);
		tx.commit();
		session.close();
		
		session = tc.factory.openSession();
		tx = session.beginTransaction();
		
		IdClassBook ibook2 = new IdClassBook();
		
		//Primary Key
		ibook2.setCheckdigit(121212);
		ibook2.setGroup(5);
		ibook2.setPublisher(14);
		ibook2.setTitle(33);
		
		ibook2.setName("Java Adv");
		
		session.save(ibook2);
		
		tx.commit();
		session.close();
		
		session = tc.factory.openSession();
		tx = session.beginTransaction();
		
		IdClassBook jbook = (IdClassBook) session.load(IdClassBook.class, new IdClassBook.EmbeddedISBN(5,14,33,121212));
		
		System.out.println(jbook);
		
		session.close();
		
		
		

	}

}
