package FitnessClub;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final int birthYear;

    public Customer(String firstName, String lastName, int birthYear)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getBirthYear()
    {
        return birthYear;
    }
}
