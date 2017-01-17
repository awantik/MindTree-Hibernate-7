package Day5;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestEhCache {

	SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		TestEhCache tec = new TestEhCache();
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		tec.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		SessionFactory sf = tec.sessionFactory;
		
		Session session = sf.openSession();
		Session newSession = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		Transaction newtx = newSession.beginTransaction();
		/*
		Student s = new Student();
		s.setName("Awantik");
		s.setSalary(1000);
		
		session.save(s);
		*/
		Student s1 = (Student) session.load(Student.class, 2L);
		System.out.println(s1);
		
		Student s2 = (Student) newSession.load(Student.class, 2L);
		System.out.println(s2);
		
		tx.commit();
		session.close();
		newtx.commit();
		newSession.close();

	}

}
