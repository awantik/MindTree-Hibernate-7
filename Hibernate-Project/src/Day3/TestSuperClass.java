package Day3;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestSuperClass {
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
		TestSuperClass tc = new TestSuperClass();
		tc.setup();
		
		Session session = tc.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		ComputerBook cb = new ComputerBook();
		cb.setName("XYZ");
		cb.setLocation("Bangalore");
		cb.setLanguage("Python");
		
        
		session.save(cb);
		
		tx.commit();
		session.close();
		
		//Example
		HashMap<ISBN,String> hm = new HashMap<>();

        //hm.pu
	}

}
