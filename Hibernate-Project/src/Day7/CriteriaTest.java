package Day7;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CountProjection;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

class ResultC{
	int count;
	int salary;
	@Override
	public String toString() {
		return "ResultC [count=" + count + ", salary=" + salary + "]";
	}
	
}

public class CriteriaTest {
	
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
		CriteriaTest et = new CriteriaTest();
		 et.setup();
		Session session = et.factory.openSession();
		Transaction tx = session.beginTransaction();
     
        Employee e = new Employee();
        e.job = "engineer";
        e.name ="Awantik";
        e.salary = 1100;
		session.save(e);
		tx.commit();
		
		session = et.factory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		
		//cr.add(Restrictions.between("salary", 1000, 2000));
		//cr.add(Restrictions.like("name", "Awan%"));
		//Criterion name = Restrictions.eq("name", "awi");
		//cr.add(Restrictions.idEq(1));
		//List results = cr.list();
		//System.out.println(results);
		/*
		cr.add(Restrictions.eq("name","Awantik"));
		cr.add(Restrictions.like("name", "Awan%"));
		cr.add(Restrictions.ilike("name", "awa%"));
		cr.add(Restrictions.between("salary", 1000, 5000));
		*/
		//Ctiteria cr = session.createCriteria(arg0)
		//Deattached Criteria as they are not associated with session
		Criterion salary = Restrictions.gt("salary",1500 );
		Criterion name = Restrictions.eq("name", "Awantik");
		
		LogicalExpression orExp = Restrictions.or(salary,name);
		cr.add(orExp);
		cr.addOrder(Order.desc("salary"));
		//cr.addOrder(Order.asc("salary"));
		List results = cr.list(); 
        System.out.println(results);
	   
        CountProjection p = Projections.count("salary");
        
        ProjectionList pl = Projections.projectionList();
        pl.add(Projections.rowCount());
        pl.add(Projections.max("salary"));
        cr.setProjection(pl);
        List r = cr.list();
        
        Iterator it = r.iterator();
        
        while(it.hasNext()){
        	Object obj[] = (Object[])it.next();
        	System.out.println(obj[0] +" " + obj[1]);
        }
	/*
		cr.setProjection(Projections.avg("salary"));
		cr.setProjection(Projections.rowCount());
		List res = cr.list();
		System.out.println(res);
		
		cr.setProjection(Projections.max("salary"));
	    cr.setProjection(Projections.groupProperty("salary"));
		*/
		
	}

}
