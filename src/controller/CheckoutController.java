package controller;

import business.CheckoutRecord;
import business.LibraryMember;
import business.Book;
import dataaccess.dao.LibraryMemberRepository;
import dataaccess.exception.BookNotFound;
import dataaccess.dao.BookRepository;
import exception.BookCopyNotAvailable;
import exception.LibraryMemberNotFound;

public class CheckoutController {
    
    public static Integer maxBook;
	
	public CheckoutRecord checkout(String memberId, String ISBN) 
	    throws LibraryMemberNotFound, BookNotFound, BookCopyNotAvailable {
	    LibraryMember member = LibraryMemberRepository.getMember(memberId);
	    Book book = BookRepository.getBook(ISBN);
	    CheckoutRecord checkoutRecord = book.checkout(member);
	    LibraryMemberRepository.updateMember(member);      // update the members object graph which includes checkoutrecord
	    BookRepository.updateBook(book);
	    return checkoutRecord;
	}
	
	
}
