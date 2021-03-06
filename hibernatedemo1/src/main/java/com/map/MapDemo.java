package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
//	creating question
		Question  q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("java is java");
		
//		creating answer
		
		Answer answer = new Answer();
		answer.setAnswerId(123);
		answer.setAnswer("java is programing languge");
		answer.setQuestion(q1);
	
		Answer answer1 = new Answer();
		answer1.setAnswerId(321);
		answer1.setAnswer("with the help of java we can create software");
		answer1.setQuestion(q1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(235);
		answer2.setAnswer("java has different type of framework.");
		answer2.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		
		q1.setAnswer(list);
	
//	session
		
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		
		
		s.save(q1);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);

		
		Question q = (Question)s.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		
		for(Answer a: q.getAnswer()) {
			
			System.out.println(a.getAnswer());
			
		}
	tx.commit();

	s.close();factory.close();
	
	}
}
