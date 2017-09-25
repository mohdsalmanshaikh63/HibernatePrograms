package com.boraji.tutorial.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.boraji.tutorial.hibernate.entity.Customer;

/**
 * @author imssbora
 */
public class SessionSaveExample {
  public static void main(String[] args) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.getTransaction();
      transaction.begin();

      Customer customer = new Customer();
      customer.setId(4l);
      customer.setName("Sunil");
      session.save(customer);

      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
      }
    }

    HibernateUtil.shutdown();
  }
}
