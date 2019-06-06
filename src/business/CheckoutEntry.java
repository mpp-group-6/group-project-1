package business;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    
    private final ZonedDateTime dueDate;
    
    private final ZonedDateTime checkoutDate;
    
    CheckoutEntry(BookCopy checkoutItem, ZonedDateTime dueDate, ZonedDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
        this.checkoutItem = checkoutItem;
        this.dueDate = dueDate;
        this.id = UUID.randomUUID().toString();
    }

    public BookCopy getCheckoutItem()
    {
        return checkoutItem;
    }

    public ZonedDateTime getDueDate()
    {
        return dueDate;
    }

    public ZonedDateTime getCheckoutDate()
    {
        return checkoutDate;
    }

    public String getId()
    {
        return id;
    }
    
    
    
}
