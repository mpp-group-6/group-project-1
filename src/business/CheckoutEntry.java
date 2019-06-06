package business;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * 
 * @author anthonyanyanwu
 * This class holds checkout Entry information.
 * It has been make immutatable since checkout entry is not expected to be modified after it has been created.
 */
final public class CheckoutEntry
{
    private final String id;
    
    private final BookCopy checkoutItem;
    
    private final LocalDateTime dueDate;
    
    private final LocalDateTime checkoutDate;
    
    CheckoutEntry(BookCopy checkoutItem, LocalDateTime dueDate, LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
        this.checkoutItem = checkoutItem;
        this.dueDate = dueDate;
        this.id = UUID.randomUUID().toString();
    }

    public BookCopy getCheckoutItem()
    {
        return checkoutItem;
    }

    public LocalDateTime getDueDate()
    {
        return dueDate;
    }

    public LocalDateTime getCheckoutDate()
    {
        return checkoutDate;
    }

    public String getId()
    {
        return id;
    }
    
    
    
}
