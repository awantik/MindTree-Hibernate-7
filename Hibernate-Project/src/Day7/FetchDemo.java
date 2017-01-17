package Day7;

import java.util.Iterator;  
import java.util.List;  
  
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.*;  

public class FetchDemo {

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
		// TODO Auto-generated method stub
        FetchDemo et = new FetchDemo();
        et.setup();
		
		Session session = et.factory.openSession();
		                  
		    //Hibernate Named Query  
		    Query query = session.getNamedQuery("findEmployeeByName");  
		    query.setString("name", "awi");  
		          
		    List<Employee> employees=query.list();  
		          
		    Iterator<Employee> itr=employees.iterator();  
		     while(itr.hasNext()){  
		    Employee e=itr.next();  
		    System.out.println(e);  
		     }  
		          
		    session.close();  
		      

	}

}
