package com.isatura.bible.service;

import com.isatura.bible.form.VerseEng;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VerseService {
    public VerseEng getVerseByBookAndChapter(int verse, int chapter, int book);
    public int getMaxChapters(int book, int chapter);
}
