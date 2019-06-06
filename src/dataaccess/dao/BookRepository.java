package dataaccess.dao;

import java.util.Map;
import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.exception.BookNotFound;

public class BookRepository
{
    final static DataAccess dbAccess;
    
    final static Map<String, Book> booksMap;
    
    static {
        dbAccess = new DataAccessFacade();
        booksMap = dbAccess.readBooksMap();
    }
    
    public static Book getBook(String ISBN) throws BookNotFound {
        Book book = booksMap.get(ISBN);
        if(book == null)
            throw new BookNotFound();
        return book;
    }
    
    public void updateBook(Book book) {
        dbAccess.updateBook(book);
    }
}
