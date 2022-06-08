package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.criteria.From;

import com.demoworkhebernatehibernatedemo1.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.sql.Select;

public class SQLExample {
	
	public static void main(String[] args) {
		
	SessionFactory factory	= new Configuration().configure().buildSessionFactory();
	
	 Session s=factory.openSession();
	 
//	 sql Query
	 
	 String q= " select * from studentdemo where city='pune'";
	 
	 NativeQuery nq = s.createSQLQuery(q);
	 List<Object[] > list=nq.list();
	 
	 for(Object[] studentdemo: list) {
		 
	System.out.println(studentdemo[1]);
	
	 }
	 s.close();
	 factory.close();
	 
	}
}	



