package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord
{
    private List<CheckoutEntry> checkoutEntries;
    
    public CheckoutRecord() {
        checkoutEntries = new ArrayList<CheckoutEntry>();
    }
    
    public void addCheckoutEntry(CheckoutEntry checkoutEntry) {
        checkoutEntries.add(checkoutEntry);
    }
    
    public void addCheckoutEntry(BookCopy checkoutItem, LocalDateTime checkoutDate, LocalDateTime dueDate) {
        checkoutEntries.add(new CheckoutEntry(checkoutItem, dueDate, checkoutDate));
    }
    
    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }
}
