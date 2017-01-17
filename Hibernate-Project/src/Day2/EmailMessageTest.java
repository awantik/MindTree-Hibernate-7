package Day2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class EmailMessageTest {
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
		EmailMessageTest emt = new EmailMessageTest();
		emt.setup();
		
		Session session = emt.factory.openSession();
		Transaction tx = session.beginTransaction();
		
	    Email email = new Email("Second Email");
	    Message mesg = new Message("Second Message");
	    
	    mesg.setEmail(email);
	    //email.setMessage(mesg);
	    session.save(email);
	    session.save(mesg);
	    
	   
	    
	    tx.commit();
	    session.close();
	    
	    //System.out.println(email.getMessage());
	    
	    

	}

}
