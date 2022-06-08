package com.states;

import com.demoworkhebernatehibernatedemo1.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		
//	practical of hibernate object states;
		
//		 Transient
//		persistent
//		Detached
//		remove

		System.out.println("Example :");
		
		SessionFactory f =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
//		creating student object:
		Student student = new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		
//		student : Transient
		
		Session s= f.openSession();
		Transaction tx= s.beginTransaction();
		s.save(student);
		
//		student : persistent - session , database
	
		
		f.close();
		
	}	
}