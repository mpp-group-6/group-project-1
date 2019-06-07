package dataaccess.dao;

import java.util.Map;
import business.Book;
import dataaccess.exception.BookNotFound;

public class BookRepository extends ObjectRepository
{
    
    public static Book getBook(String ISBN) throws BookNotFound {
        Map<String, Book> booksMap = dbAccess.readBooksMap();
        Book book = booksMap.get(ISBN);
        if(book == null)
            throw new BookNotFound();
        return book;
    }
    
    public static void updateBook(Book book) {
        dbAccess.updateBook(book);
    }
}
