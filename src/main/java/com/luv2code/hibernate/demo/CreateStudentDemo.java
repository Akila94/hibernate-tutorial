package com.luv2code.hibernate.demo;

import com.luv2code.jdbc.demo.entity.Student;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] main) {

        //create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create a session
        Session session = sessionFactory.getCurrentSession();

        try {
            //create a student object
            System.out.print("Creating new Student object\n");
            Student student = new Student("Paul", "wall", "paul@wall.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.print("Saving the student...");
            session.save(student);

            //commit the transaction
            session.getTransaction().commit();

            System.out.print("Done!!!");
        } catch (JDBCException e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

}
