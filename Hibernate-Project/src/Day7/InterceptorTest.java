package Day7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class InterceptorTest {

	SessionFactory factory;

	public void setup(){
		Configuration configuration = new Configuration();
		MyInterceptor icptor = new MyInterceptor();
		
		configuration.setInterceptor(icptor);
		configuration.configure();
		
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);		
		
	}
	
	public static void main(String[] args) {
		InterceptorTest ip = new InterceptorTest();
		ip.setup();
		
		Session session = ip.factory.openSession();
	    
		Transaction tx = session.beginTransaction();
		
		Employee e = new Employee();
		e.setJob("Good Job");
		e.setName("Good Name");
		e.setSalary(1000);

		session.save(e);
		tx.commit();
		session.close();
	}

}
