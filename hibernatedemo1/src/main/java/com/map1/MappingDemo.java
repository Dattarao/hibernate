package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(4567);
		e1.setName("ganesh");
		
		e2.setEid(5678);
		e2.setName("dipak");
		
		Project p1 = new Project();
		Project p2 = new Project();
		p1.setPid(876);
		p1.setProjectName("Library managment system....");
		p2.setPid(960);
		p2.setProjectName("CHATBOT...");
		
		List<Emp> emp = new ArrayList<Emp>();
		
		List<Project> proj = new ArrayList<Project>();
		
		e1.setProjects(proj);
		e2.setProjects(proj);
		p1.setEmps(emp);
		p2.setEmps(emp);
		
		emp.add(e1);
		emp.add(e2);
		
		proj.add(p1);
		proj.add(p2);
		Session s = factory.openSession();
		Transaction tx= s.beginTransaction();
		s.save(e1);
		s.save(e2);
		
		s.save(p1);
		s.save(p2);
		tx.commit();
		
		factory.close();	
	}
}
