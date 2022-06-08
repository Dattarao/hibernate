package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {
	
	public static void main(String[] args) {
			
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		

		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		Question q= (Question)s.get(Question.class, 1212);
		
		
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		
//		eger then eagger
		
//		lazy
		
		System.out.println(q.getAnswer().size());

		tx.commit();
		
	}	
}
