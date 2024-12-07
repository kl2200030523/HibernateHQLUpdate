package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Hibernate Configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        // Build SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Open Session
        Session session = sessionFactory.openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // HQL Update Query with Positional Parameters
        String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE departmentId = ?3";
        int updatedRecords = session.createQuery(hql)
                                    .setParameter(1, "Updated Name")
                                    .setParameter(2, "Updated Location")
                                    .setParameter(3, 1) // Update department with ID 1
                                    .executeUpdate();

        System.out.println("Number of records updated: " + updatedRecords);

        // Commit Transaction
        transaction.commit();

        // Close Session and SessionFactory
        session.close();
        sessionFactory.close();
    }
}
