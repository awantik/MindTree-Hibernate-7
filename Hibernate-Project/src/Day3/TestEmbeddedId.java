package Day3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestEmbeddedId {
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
		// TODO Auto-generated method stub
		TestEmbeddedId tc = new TestEmbeddedId();
		tc.setup();
		
		Session session = tc.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		EmbeddedPKBook ebook = new EmbeddedPKBook();
		ebook.id = new EmbeddedPKBook.EmbeddedISBN();
		
		
		
	    ebook.id.setCheckdigit(111);
		ebook.id.setGroup(1);
		ebook.id.setPublisher(5);
		ebook.id.setTitle(7);
		
		ebook.setName("Abcdedf");
		session.save(ebook);
		
		ebook = (EmbeddedPKBook) session.load(EmbeddedPKBook.class, ebook.id);
		
		tx.commit();
		session.close();

	}

}
