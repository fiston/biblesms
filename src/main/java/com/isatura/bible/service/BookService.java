package com.isatura.bible.service;

import com.isatura.bible.form.Books;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BookService {
    public Books getBookById(int id);
    public List<Books> getAllBooks();

}
