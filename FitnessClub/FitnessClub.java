package FitnessClub;
import java.time.LocalDate;
public class FitnessClub {
    private final Membership[] gymMemberships;
    private final Membership[] swimmingPoolMemberships;
    private final Membership[] groupClassMemberships;

    public FitnessClub()
    {
        gymMemberships = new Membership[20];
        swimmingPoolMemberships = new Membership[20];
        groupClassMemberships = new Membership[20];
    }
    public void enterFitnessZone(FitnessZone zone, Membership membership)
    {
        switch (zone)
        {
            case GYM:
                enterZone(gymMemberships, membership);
                break;
            case SWIMMING_POOL:
                enterZone(swimmingPoolMemberships, membership);
                break;
            case GROUP_CLASSES:
                enterZone(groupClassMemberships, membership);
                break;
        }
    }
    //проверяем не просрочен ли абонемент если просрочен говорит что нельзя войти.
    private void enterZone(Membership[] zoneMemberships, Membership membership)
    {
        if (membership.getExpiryDate().isBefore(LocalDate.now()))
        {
            System.out.println("Абонемент просрочен");
            return;
        }
        //проверяем может ли пользователь войти в эту зону с его текущим абонементом если нет нельзя войти.
        if (membership.getExpiryDate().isBefore(LocalDate.now()) || !isAllowedForZone(membership, zoneMemberships))
        {
            System.out.println("Невозможно пройти в данную финтес зону по данному абонементу");
            return;
        }
        //если всё соответствует
        for (int i = 0; i < zoneMemberships.length; i++)
        {
            if (zoneMemberships[i] == null)
            {
                zoneMemberships[i] = membership;
                System.out.println("Посетитель вошел в фитнес зону");
                return;
            }
        }
        //если нет мест
        System.out.println("В данной зоне нет свободных мест");
    }
    //проверяет разрешено ли использование абонемента  для доступа к зоне, основываясь на массиве абонементов уже допущенных к зоне.
    private boolean isAllowedForZone(Membership membership, Membership[] zoneMemberships)
    {
        for (Membership m : zoneMemberships)
        {
            if (m != null && m.equals(membership))
            {
                return false;
            }
        }
        return true;
    }
    public void printCustomersInFitnessZones()
    {
        System.out.println("\nПосетители зала:");
        printMemberships(gymMemberships);

        System.out.println("\nПосетители бассейна:");
        printMemberships(swimmingPoolMemberships);

        System.out.println("\nПосетители групповых занятий:");
        printMemberships(groupClassMemberships);
    }

    private void printMemberships(Membership[] memberships)
    {
        for (Membership membership : memberships)
        {
            if (membership != null)
            {
                Customer customer = membership.getCustomer();
                System.out.println(STR."\{customer.getFirstName()} \{customer.getLastName()} (Год рождения: \{customer.getBirthYear()})");
            }
        }
    }
}
