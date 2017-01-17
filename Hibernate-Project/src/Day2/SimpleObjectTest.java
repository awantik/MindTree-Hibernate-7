package Day2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SimpleObjectTest {
	
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
		SimpleObjectTest tc = new SimpleObjectTest();
		tc.setup();
		
		Session session = tc.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		SimpleObject so1 = new SimpleObject();
		so1.setKey("so1");
		so1.setValue(1L);
		
		session.save(so1);
		
		Long id = so1.getId();
		tx.commit();
		session.close();
		
		System.out.println("Id of this object is " + id);
		
		// Created a new session here
		session = tc.factory.openSession();
		tx = session.beginTransaction();
		
		//Access same id object twice in same session
		SimpleObject so2 = (SimpleObject)session.load(SimpleObject.class, id);
		SimpleObject so3 = (SimpleObject)session.load(SimpleObject.class, id);
		
		//Same because they are retrived in same session
		if (so2 == so3){
					System.out.println("Same Session: They are same: so2 & so3");
		}else{
					System.out.println("Same Session: They are not same: so2 & so3");
		}
		
		// so2 & so1 are in different session
		if (so2 == so1){
			System.out.println("Different Session: They are same: so2 & so1");
		}else{
			System.out.println("Different Session: They are not same: so2 & so1");
		}
		
		
		
		
		if (so1.equals(so2)){
			System.out.println("so1 and so2 same");
		}
		if (so2.equals(so3)){
			System.out.println("so2 and so3 same");
		}
		
		System.out.println("so1 :" + so1);
		System.out.println("so2 :" + so2);
		System.out.println("so3 :" + so3);
		
		

	}

}
