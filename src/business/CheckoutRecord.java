package business;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable 
{

    private static final long serialVersionUID = -4086466632868230528L;

    private final LibraryMember member;
    
    private List<CheckoutEntry> checkoutEntries;
    
    public CheckoutRecord(LibraryMember member) {
        this.member = member;
        checkoutEntries = new ArrayList<CheckoutEntry>();
    }
    
    public void addCheckoutEntry(BookCopy checkoutItem, ZonedDateTime checkoutDate, ZonedDateTime dueDate) {
        checkoutEntries.add(new CheckoutEntry(checkoutItem, dueDate, checkoutDate));
    }
    
    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    public LibraryMember getMember()
    {
        return member;
    }
    
    public String toString() {
    	String returnVal="";
    	String checkoutDate="";
    	String dueDate="";
    	String isbn = "";
    	String bookTitle="";	
       
    	
    	for(CheckoutEntry entry: checkoutEntries) {
    		checkoutDate = entry.getCheckoutDateString();
    		dueDate  = entry.getDueDateString();
    		isbn = entry.getCheckoutItem().getBook().getIsbn();
            bookTitle = entry.getCheckoutItem().getBook().getTitle();
            returnVal+="Book "+bookTitle+" isbn : "+isbn+"==="+"Checkout date : "+checkoutDate+"===="+"Due date: "+dueDate+"RC";
            //copiesLeft = entry.getCheckoutItem().getBook().
            //authors = entry.getCheckoutItem().getBook().getAuthors().toString();
    	}
    	
    	
    	
    	return returnVal;
    }
}
