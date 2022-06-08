package com.cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import com.map.Answer;
import com.map.Question;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CascadeExample {

	public static void main(String[] args) {

		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session s= factory.openSession();
		
		
		Question q1 = new Question();
		q1.setQuestionId(5625);
		q1.setQuestion("what is Swing framework ");
		
		
		Answer a1 = new Answer(231423 ,"use for development", q1);
		Answer a2 = new Answer(2515,"Deskop",q1);
		Answer a3 = new Answer(315 ,"learn by programer" ,q1);
		
		List<Answer> list = new ArrayList<Answer>();
		
		Transaction tx= s.beginTransaction();
		
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(a3);
		
		tx.commit();
		s.close();
		
	}
}
