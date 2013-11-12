package com.isatura.bible.service;

import com.isatura.bible.dao.VerseServiceDAO;
import com.isatura.bible.form.VerseEng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class VerseServiceImpl implements VerseService {

    @Autowired
    VerseServiceDAO verseServiceDAO;

    @Transactional
    public VerseEng getVerseByBookAndChapter(int verse, int chapter, int book) {
        return verseServiceDAO.getVerseByBookAndChapter(verse, chapter, book);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    public int getMaxChapters(int book, int chapter) {
        return verseServiceDAO.getMaxChapters(book, chapter);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
