package com.isatura.bible.dao;

import com.isatura.bible.form.Books;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BookServiceDAO {
    public Books getBookById(int id);
    public List<Books> getAllBooks();

}
