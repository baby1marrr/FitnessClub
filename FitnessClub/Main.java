package FitnessClub;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
    {
        FitnessClub fitnessClub = new FitnessClub();


        addCustomersToZone(fitnessClub, FitnessZone.GYM);
        addCustomersToZone(fitnessClub, FitnessZone.SWIMMING_POOL);
        addCustomersToZone(fitnessClub, FitnessZone.GROUP_CLASSES);

        fitnessClub.printCustomersInFitnessZones();
    }

    private static void addCustomersToZone(FitnessClub fitnessClub, FitnessZone zone)
    {

        fitnessClub.enterFitnessZone(zone, createMembership("Маргарита", "Макарова", 1991));
        fitnessClub.enterFitnessZone(zone, createMembership("Артем", "Николаев", 1984));
        fitnessClub.enterFitnessZone(zone, createMembership("Лариса", "Козлова", 1977));
        fitnessClub.enterFitnessZone(zone, createMembership("София", "Ильина", 1989));
        fitnessClub.enterFitnessZone(zone, createMembership("Екатерина", "Степанова", 1981));
        fitnessClub.enterFitnessZone(zone, createMembership("Марина", "Крылова", 1974));
        fitnessClub.enterFitnessZone(zone, createMembership("Игорь", "Алексеев", 1993));
        fitnessClub.enterFitnessZone(zone, createMembership("Татьяна", "Куликова", 1973));
    }

    private static Membership createMembership(String firstName, String lastName, int birthYear)
    {
        Customer customer = new Customer(firstName, lastName, birthYear);
        LocalDate registrationDate = LocalDate.now();
        LocalDate expiryDate = registrationDate.plusMonths(1);
        return new Membership(customer, registrationDate, expiryDate);
    }

}
