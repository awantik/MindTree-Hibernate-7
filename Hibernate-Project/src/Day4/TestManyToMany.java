package Day4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestManyToMany {
	
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
		TestManyToMany tm = new TestManyToMany();
		tm.setup();
		
		Session session = tm.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Meeting meeting1 = new Meeting(1L,"Discussion on Hibernate");
		Meeting meeting2 = new Meeting(2L,"Discussion on Spring");
		
		Employee emp1 = new Employee("abc","def");
		emp1.getMeetings().add(meeting1);
		emp1.getMeetings().add(meeting2);
		
		Employee emp2 = new Employee("uvw","xyz");
		emp2.getMeetings().add(meeting1);
		emp2.getMeetings().add(meeting2);
		
		session.save(emp1);
		session.save(emp2);
		
		tx.commit();
		session.close();
		

	}

}
