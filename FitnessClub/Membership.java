package FitnessClub;
import java.time.LocalDate;
public class Membership {
    private final LocalDate expiryDate;
    private final Customer customer;

    public Membership(Customer customer, LocalDate ignoredRegistrationDate, LocalDate expiryDate)
    {
        this.customer = customer;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate()
    {
        return expiryDate;
    }
    public Customer getCustomer()
    {
        return customer;
    }
}
