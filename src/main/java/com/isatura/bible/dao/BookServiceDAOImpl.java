package com.isatura.bible.dao;

import com.isatura.bible.form.Books;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class BookServiceDAOImpl implements BookServiceDAO {
    @Autowired
    private SessionFactory sessionFactory;


    public Books getBookById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Books as bib where bib.number=:id");
        query.setInteger("id", id);
        return (Books) query.list().get(0);
    }

    public List<Books> getAllBooks() {
        return sessionFactory.getCurrentSession().createQuery("from Books").list();
    }

}
