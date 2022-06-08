package com.demoworkhebernatehibernatedemo1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("project work");
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);

        
//        creating student
        Student st= new Student();
        st.setId(104);
        st.setName("ashish");
        st.setCity("nanded");
        System.out.println(st);
        
        
//       creating object of address class
        Address ad= new Address();
        ad.setStreet("street1");
        ad.setCity("Delhi");
        ad.setIsopen(true);
        ad.setAddedDate(new java.util.Date());
         ad.setX(1234.234);
         
//        Reading image
//         FileInputStream fis= new FileInputStream("src/main/java/IMG_20210504_113259.jpg");
//         byte[] data = new byte [fis.available()];
//         fis.read(data);
//         ad.setImage(data);
       
     
     Session session   =factory.openSession();
///
     Transaction tx=session.beginTransaction();
    
    
     session.save(st);
     session.save(ad);
        tx.commit();
        session.close();
        factory.close();
        System.out.println("Done...");
          
    }
}
