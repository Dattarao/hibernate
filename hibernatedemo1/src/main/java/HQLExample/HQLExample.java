package HQLExample;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import com.demoworkhebernatehibernatedemo1.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLExample {
	
	public static void main(String[] args) {
	
		Configuration cfg= new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s= factory.openSession();
		String query ="from Student";
		Query q= s.createQuery(query);
			
//		single -  ( Uniques)
		
//		multiple  -  list
		q.uniqueResult();
		
		List<Student>  list = q.list();
		
		for(Student student: list) {
			System.out.println(student.getName());
		}
	
//		HQL 
//		syntax
		s.close();
		factory.close();
	}
}
