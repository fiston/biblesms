package com.isatura.bible.service;

import com.isatura.bible.dao.BookServiceDAO;

import com.isatura.bible.form.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookServiceDAO bookeServiceDAO;
    @Transactional
    public Books getBookById(int id) {

        return bookeServiceDAO.getBookById(id);
    }
    @Transactional
    public List<Books> getAllBooks() {
        return bookeServiceDAO.getAllBooks();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
