package Day3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class TestCompoundCode {

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
		TestCompoundCode tc = new TestCompoundCode();
		tc.setup();
		
		Session session = tc.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
        customer.name = " Awesome Good again";
		customer.address = "Mumbai Again";
		
        
		session.save(customer);
		
		tx.commit();
		session.close();

	}

}