package homework6.userSort;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> people = new ArrayList<>();
        people.add(new User("Homer", "Simpson", 38));
        people.add(new User("Marge", "Bonny", 35));
        people.add(new User("Bart", "Simpson", 15));
        people.add(new User("Lisa", "Bonny", 13));

        SortUserImpl sortUser = new SortUserImpl();
        Comparator<User>[] comparators = new Comparator[]{User.comparingBySurname, User.comparingByName, User.comparingByAge};
        sortUser.sort(people, comparators);
        System.out.println(people.toString());
    }
}
