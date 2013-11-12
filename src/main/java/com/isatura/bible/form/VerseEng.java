package com.isatura.bible.form;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/11/13
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "VerseEng")
public class VerseEng {

    @Id
    @Column(name = "row")
    @GeneratedValue
    private int row;
    @Column(name = "book")
    private int book;
    @Column(name = "chapter")
    private int chapter;
    @Column(name = "verseNumber")
    private int verseNumber;
    @Column(name = "text_English")
    private String text;

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVerseNumber() {
        return verseNumber;
    }

    public void setVerseNumber(int verseNumber) {
        this.verseNumber = verseNumber;
    }
}
