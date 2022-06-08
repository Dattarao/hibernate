package com.firstcache;

import com.demoworkhebernatehibernatedemo1.Student;
import com.map.Answer;
import com.map.Question;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
//		by default enabled
		
		Question question=session.get(Question.class,1212);
		System.out.println(question);
		System.out.println("working something...");
		
		Question question1=session.get(Question.class,1212);
		System.out.println(question1);
		
		
		System.out.println(session.contains(question1));
		
		
	
		session.close();
	}	
}
