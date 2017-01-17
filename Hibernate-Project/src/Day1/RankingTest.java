package Day1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class RankingTest {
	
	SessionFactory factory;

	public void setup(){
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb.applySettings(configuration.getProperties());
		
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);		
		
	}
	
	
	public Skill saveSkill(Session session, String skill){
		//First find, if skill is already presnt
		Skill s = new Skill();
		s.setName(skill);
		session.save(s);
		return s;
	}
	
	public Student saveStudent(Session session, String name){
		Student s = new Student();
		s.setName(name);
		session.save(s);
		return s;
	}
	
	public void createData(Session session, String subjectName, String observerName, String skillName, int rank){
		Student subject = saveStudent(session,subjectName);
		Student observer = saveStudent(session,observerName);
		Skill skill = saveSkill(session,skillName);
		
		Ranking ranking = new Ranking();
		ranking.setSubject(subject);
		ranking.setObserver(observer);
		ranking.setSkill(skill);
		ranking.setRanking(rank);
		
		session.save(ranking);
	}

	public static void main(String[] args) {
		RankingTest rt = new RankingTest();
		rt.setup();
		
		Session session = rt.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		rt.createData(session, "abcd", "defg", "hibernate", 5);
		rt.createData(session, "abc", "xyz", "spring", 15);
		rt.createData(session, "vxyz", "def", "struct", 25);
		
		tx.commit();
		session.close();

	}

}
