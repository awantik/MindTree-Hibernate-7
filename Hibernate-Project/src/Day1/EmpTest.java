package Day1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EmpTest {
	
	SessionFactory factory;

	public void setup(){
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);	

		
	}
	
	public static void main(String[] args) {
		EmpTest et = new EmpTest();
		et.setup();
		
		Session session = et.factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee e = new Employee("Awantik");
		session.save(e);
		Employee f = new Employee("Aabcdef");
		session.save(f);
		tx.commit();
		session.close();
		
		session = et.factory.openSession();
		 tx = session.beginTransaction();
		Employee e1 = (Employee) session.load(Employee.class, 1L);
		e1.name = "awi";
		
	
		
		//tx2.commit();
		
		//session2.close();

	}

}
