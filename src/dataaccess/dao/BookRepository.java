package dataaccess.dao;

import java.util.Map;
import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import exception.LibraryMemberNotFound;

public class BookRepository
{
    final static DataAccess dbAccess;
    
    final static Map<String, Book> booksMap;
    
    static {
        dbAccess = new DataAccessFacade();
        booksMap = dbAccess.readBooksMap();
    }
    
    public static Book getMember(String memberId) throws LibraryMemberNotFound {
        Book member = booksMap.get(memberId);
        if(member == null)
            throw new LibraryMemberNotFound();
        return member;
    }
    
    public void updateBook(Book book) {
        dbAccess.updateBook(book);
    }
}
