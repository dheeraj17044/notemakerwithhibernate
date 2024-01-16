package com.example.notemakerwithhibernate.dao;

import com.example.notemakerwithhibernate.entity.Book;
import com.example.notemakerwithhibernate.utility.SessionFactoryHelper;
import com.example.notemakerwithhibernate.utility.SessionHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class BookDaoImpl {

    @Transactional
    public void saveBook(Book dbBook) {

        Session session = SessionHelper.getSession();

        session.save(dbBook);


//        session.close();
    }

    public Book getBook(int bookId) {
        Session session = SessionHelper.getSession();

        Book dbBook = (Book) session.get(Book.class,bookId);

//        session.close();

        return dbBook;
    }

    @Transactional
    public void saveUpdatedBook(Book dbBook) {
        Session session = SessionHelper.getSession();

        session.update(dbBook);

//        session.close();
    }

    @Transactional
    public void deleteBook(int bookId) {
        Session session = SessionHelper.getSession();

        Book dbBook = (Book) session.get(Book.class,bookId);
        session.delete(dbBook);

//        session.close();
    }
}
