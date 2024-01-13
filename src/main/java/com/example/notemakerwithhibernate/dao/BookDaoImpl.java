package com.example.notemakerwithhibernate.dao;

import com.example.notemakerwithhibernate.entity.Book;
import com.example.notemakerwithhibernate.utility.SessionHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


@Component
public class BookDaoImpl {

    public void saveBook(Book dbBook) {

        SessionFactory sessionFactory = SessionHelper.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(dbBook);

        tx.commit();

        session.close();
        sessionFactory.close();
    }

    public Book getBook(int bookId) {
        SessionFactory sessionFactory = SessionHelper.getSessionFactory();
        Session session = sessionFactory.openSession();

        Book dbBook = (Book) session.get(Book.class,bookId);

        session.close();
        sessionFactory.close();

        return dbBook;
    }

    public void saveUpdatedBook(Book dbBook) {
        SessionFactory sessionFactory = SessionHelper.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.merge(dbBook);

        tx.commit();

        session.close();
        sessionFactory.close();
    }

    public void deleteBook(int bookId) {
        SessionFactory sessionFactory = SessionHelper.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();


        Book dbBook = (Book) session.get(Book.class,bookId);
        session.delete(dbBook);

        tx.commit();

        session.close();
        sessionFactory.close();
    }
}
