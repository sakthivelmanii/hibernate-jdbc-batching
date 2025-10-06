package org.example6x;


import java.util.Random;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp6x {

  public static void main(String[] args) {
    Transaction transaction = null;

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();

      Random random = new Random();

      for (int i = 0; i < 1000; i++) {
        Singer singer = new Singer();
        singer.setId(random.nextLong());
        singer.setFirstName("First Name" + i);
        singer.setLastName("Last Name" + i);
        singer.setGenre("Genre" + i);
        session.persist(singer);
      }
      transaction.commit();

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace(System.err);
    } finally {
      HibernateUtil.shutdown();
    }
  }
}