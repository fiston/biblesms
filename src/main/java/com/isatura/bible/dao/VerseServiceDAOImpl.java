package com.isatura.bible.dao;


import com.isatura.bible.form.VerseEng;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class VerseServiceDAOImpl implements VerseServiceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<VerseEng> getAllVerse() {
        return sessionFactory.getCurrentSession().createQuery("from VerseEng").list();  //To change body of implemented methods use File | Settings | File Templates.
    }
    public VerseEng getVerseByBookAndChapter(int verse, int chapter, int book) {
        Query query = sessionFactory.getCurrentSession().createQuery("from VerseEng as ver where ver.book=:book and ver.chapter=:chapter and ver.verseNumber=:verse ");
        query.setInteger("verse", verse);
        query.setInteger("chapter", chapter);
        query.setInteger("book", book);
        return (VerseEng) query.list().get(0);
    }

    public int getMaxChapters(int book,int chapter) {
        String queryString="select MAX(verseNumber) as MAX_VERSE from VerseEng where chapter=:chapter and book=:book";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(queryString);
        query.setInteger("chapter",chapter);
        query.setInteger("book",book);
        query.addScalar("MAX_VERSE", Hibernate.INTEGER);

        Object results = query.list().get(0);
            return (Integer) results;

    }
}
