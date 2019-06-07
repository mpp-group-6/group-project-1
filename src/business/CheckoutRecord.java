package business;

import java.io.Serializable;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class CheckoutRecord implements Serializable
{
	
	private static final long serialVersionUID = -4086466632868230528L;
=======
public class CheckoutRecord implements Serializable 
{

    private static final long serialVersionUID = -4086466632868230528L;

>>>>>>> 323fbd4200ace02ea34962b1541b8e51b84cf1ca
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
}
