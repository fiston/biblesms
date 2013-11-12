package com.isatura.bible.controller;

import com.isatura.bible.form.Books;
import com.isatura.bible.form.VerseEng;
import com.isatura.bible.service.BookService;
import com.isatura.bible.service.VerseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.GetRandomsUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ng1
 * Date: 6/13/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BookVerseControler {
    @Autowired
    private BookService bookService;

    @Autowired
    private VerseService verseService;


    private int getRandomChapter(Books books) {
        System.out.print(books.getNumber() + "\n");

        return GetRandomsUtils.getRandomNumber(1, books.getChapters());
    }

    private String getRandomVerseEngl() {
        int bookId = GetRandomsUtils.getRandomNumber(1, 66);
        Books book = bookService.getBookById(bookId);
        int chapter = getRandomChapter(book);
        System.out.println(chapter + "=====");
        int maxVerse = verseService.getMaxChapters(bookId, chapter);
        System.out.println("max " + maxVerse);
        System.out.println(">>>>" + book.getFull_name_english() + book.getChapters() + " " + chapter);
        int verseN = GetRandomsUtils.getRandomNumber(1, maxVerse);
        System.out.println(book.getFull_name_english() + book.getChapters() + " " + chapter + ":" + verseN);
        if (chapter <= book.getChapters()) {
            VerseEng verseEng = verseService.getVerseByBookAndChapter(verseN, chapter, bookId);
            String bookAbr = book.getAbbrEnglish().split(",")[0];
            String verseReturn = bookAbr + " " + verseEng.getChapter() + ":" + verseEng.getVerseNumber() + " " + verseEng.getText();
//            System.out.print(verseReturn.length());
            return (verseReturn.length() <= 320) ? verseReturn : (bookAbr + " " + verseEng.getChapter() + ":" + verseEng.getVerseNumber());
        }
        return getRandomVerseEngl();
    }

    private String searchVerse(String text) {

        String[] request = text.split(" ");
        for (int i = 0; i < request.length; i++) {
            System.out.println(i + ":" + request[i]);
        }
        Books book = new Books();
        String requestBook = request[2];
        int requestChapter = Integer.parseInt(request[3]);
        int verseN = Integer.parseInt(request[4]);
        List<Books> bookses = bookService.getAllBooks();
        boolean bookExist = false;
        for (Books books : bookses) {
            String bookName = books.getFull_name_english();
            bookName = bookName.replace(" ", "").trim();
            if (bookName.equalsIgnoreCase(requestBook)) {
                book = books;
                bookExist = true;
                break;
            }
        }
        if (bookExist && requestChapter >= 1 && requestChapter <= book.getChapters()) {
            int maxVerse = verseService.getMaxChapters(book.getNumber(), requestChapter);
            if (maxVerse < verseN) {
                return "The requested verse doesn't exist for this book";
            }
            VerseEng verseEng = verseService.getVerseByBookAndChapter(verseN, requestChapter, book.getNumber());
            String bookAbr = book.getAbbrEnglish().split(",")[0];
            String verseReturn = bookAbr + " " + verseEng.getChapter() + ":" + verseEng.getVerseNumber() + " " + verseEng.getText();
            System.out.print(verseReturn.length());
            return (verseReturn.length() <= 320) ? verseReturn : (bookAbr + " " + verseEng.getChapter() + ":" + verseEng.getVerseNumber());

        } else
            return "Message not well formatted, send : BIble search book chapter verse. Ex: Bible search 1John 1 12. Book name should be in English.";

    }

    @RequestMapping(value = "/randomVerse", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String getVerse(@RequestParam(value = "text", required = false) String text, @RequestParam(value = "number") String number, @RequestParam(value = "endpoint") String endpoint) {
        String[] recText = text.split(" ");
        System.out.println(recText.length);
        if (recText.length == 1) {
            return getRandomVerseEngl();
        } else if (recText[1].equalsIgnoreCase("search")) {
            return searchVerse(text);
        } else {
            return "Message not well formatted, send : BIble search book chapter verse. Ex: Bible search 1John 1 12. Book name should be in English.";

        }

    }


}
