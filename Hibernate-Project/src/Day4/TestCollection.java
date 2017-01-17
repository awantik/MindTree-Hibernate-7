package Day4;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestCollection {
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
		TestCollection tc = new TestCollection();
		tc.setup();
		
		Session session = tc.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Maruti","Red"));
		cars.add(new Car("Ford","Green"));
		cars.add(new Car("Skoda","Blue"));
		
		Showroom showroom = new Showroom();
		showroom.setLocation("Bangalore");
		showroom.setManager("Hibernate");
		
		showroom.setCars(cars);
		
		session.save(showroom);
		
		List<Car> cars2 = new ArrayList<>();
		cars2.add(new Car("HM","Red"));
		cars2.add(new Car("Audi","Green"));
		cars2.add(new Car("BMW","Blue"));
		
		Showroom showroom2 = new Showroom();
		showroom2.setLocation("Mumbai");
		showroom2.setManager("Spring");
		showroom2.setCars(cars2);
		
		session.save(showroom2);
		
		tx.commit();
		session.close();

	}

}
